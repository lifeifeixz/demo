package com.baixiang.chuxing.user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baixiang.chuxing.core.config.helper.IdWorkerHelper;
import com.baixiang.chuxing.core.exception.BaseRuntimeException;
import com.baixiang.chuxing.core.exception.BizException;
import com.baixiang.chuxing.core.model.enums.ResultType;
import com.baixiang.chuxing.core.model.vo.Result;
import com.baixiang.chuxing.core.utils.HttpClientUtils;
import com.baixiang.chuxing.core.utils.StringUtil;
import com.baixiang.chuxing.user.common.TripConstants;
import com.baixiang.chuxing.user.config.ApiConfig;
import com.baixiang.chuxing.user.model.bo.UnionUserBo;
import com.baixiang.chuxing.user.model.mongo.User;
import com.baixiang.chuxing.user.model.vo.CompanyUserVo;
import com.baixiang.chuxing.user.model.vo.UserParamVo;
import com.baixiang.chuxing.user.persist.mapper.ActivityUserMapper;
import com.baixiang.chuxing.user.persist.mongo.UserMongoDao;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p/>
 * <p><b>introduction:</b>
 * </p>
 * <p><b>packageName:</b>com.st.user.service.impl</p>
 * <p><b>projectName:</b>maxmob-message</p>
 * <p><b>User:</b> lipengfei <a href="mailto:lipengfei90@live.cn">lipengfei90@live.cn</a></p>
 * <p><b>Date:</b>2016/9/26</p>
 *
 * @author lipengfei
 */
@SuppressWarnings("all")
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

//    @Value("${base.sessionUrl}")
//    private String sessionUrl;

    @Autowired
    private UserMongoDao userMongoDao;

    @Resource
    private ApiConfig apiConfig;

    @Resource
    MongoTemplate mongoTemplate;

    @Resource
    IdWorkerHelper idWorkerHelper;

    /**
     * 更新登录时间.
     *
     * @param id
     * @param idPhotoCheck
     */
    public void updateLoginDatetime(long id) {
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), Update.update("loginDatetime", new Date()), User.TABLE_NAME);
    }


    public User find(long id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), User.class, User.TABLE_NAME);
    }

    public User findByMobile(String mobile) {
        return userMongoDao.findByAccount(mobile);
    }

    public Page<User> findUsers(int page, int rows) {
        PageRequest pageRequest = new PageRequest(page - 1, rows);
        return userMongoDao.findAll(pageRequest);
    }

    /**
     * 后台更新企业认证
     *
     * @param id
     * @param companyCheckStatus
     * @param companyCheckBy
     * @param companyCheckReason
     */
    public void updateCompanyCheck(long id, int companyCheckStatus, String companyCheckBy, String companyCheckReason) {
        Update update = new Update();
        update.set("companyCheckStatus", companyCheckStatus);
        update.set("companyCheckBy", companyCheckBy);
        update.set("companyCheckReason", companyCheckReason);
        update.set("companyCheckDatetime", new Date());
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), update, User.TABLE_NAME);
    }

    /**
     * 后台更新工会卡认证状态.
     *
     * @param id
     * @param unionCheckStatus
     * @param unionCheckBy
     * @param unionCheckReason
     */
    public void updateUnionCheck(long id, int unionCheckStatus, String unionCheckBy, String unionCheckReason) {
        Update update = new Update();
        update.set("unionCheckStatus", unionCheckStatus);
        update.set("unionCheckBy", unionCheckBy);
        update.set("unionCheckReason", unionCheckReason);
        update.set("unionCheckDatetime", new Date());
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), update, User.TABLE_NAME);
    }

    public void delete(String id) {

    }

    public Page<User> findAll(BooleanExpression predicate, Pageable pageable) {
        return userMongoDao.findAll(predicate, pageable);
    }

    public Page<User> findAll(User user) {

        return null;
    }


    public void updateVehicleNum(long id, int vehicleNum) {
        Update update = new Update();

        update.set("vehicleNum", vehicleNum);
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), update, User.TABLE_NAME);
    }

    public List<User> findByIds(BooleanExpression expression) {
        Iterable<User> iterable = userMongoDao.findAll(expression);
        List<User> users = new ArrayList<User>();
        Iterator<User> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            users.add(iterator.next());
        }
        return users;
    }

    public User updateUser(User user) {
        user.setUpdateDatetime(new Date());
        return userMongoDao.save(user);
    }

    public User findByAccount(String account) {
        User user = userMongoDao.findByAccount(account);
        return user;
    }

    public void save(User user) {
        user.setId(idWorkerHelper.nextId());
//        user.setGender("male");
        user.setCreateDatetime(new Date());
        user.setUpdateDatetime(new Date());
        user.setIdPhotoCheckStatus(TripConstants.CheckStatus.NO_PERFECT);
        user.setDriverLicenseCheckStatus(TripConstants.CheckStatus.NO_PERFECT);
        user.setCompanyCheckStatus(TripConstants.CheckStatus.NO_PERFECT);
        mongoTemplate.insert(user, User.TABLE_NAME);

        //调用钱包模块进行开户
        this.createWallet(user.getId());
    }


    private void createWallet(long userId) {
        String url = apiConfig.getWalletUrl() + "/create";

        Map<String, String> params = new HashMap();
        params.put("userId", String.valueOf(String.valueOf(userId)));
        String resultStr = HttpClientUtils.post(url, JSON.toJSONString(params));
        if (StringUtil.isEmpty(resultStr)) {
            throw new BaseRuntimeException("调用钱包接口失败");
        }
        JSONObject resultJson = JSON.parseObject(resultStr);
        Result result = JSONObject.toJavaObject(resultJson, Result.class);
        if (result.getStatus().equals(ResultType.FAIL)) {//获取失败直接返回
            logger.error(" call" + url + " error, params are " + userId);
            throw new BaseRuntimeException("调用钱包接口失败");
        }
    }

    public void createUser(User user) {
        User u = this.findByAccount(user.getAccount());
        if (u == null) {
            save(user);
        } else {
            throw new BizException("用户已经存在");
        }

    }

    /**
     * 验证用户
     * 验证规则：1.如果用户idCard存在，继续验证name是否相等。如果这两个条件都满足
     * 则将信息装入list<companyUserVo>中等待返回。
     * 2.如果用户idcard存在，但name不相同，不做操作，将不存在状态存入等待返回
     * 3.idCard不存在，将创建用户，并将创建之后的用户信息存入list。。。等待返回
     *
     * @param companyUserVos{name:'',idCard:''}
     * @return
     */
    public List<CompanyUserVo> compareUsers(List<UserParamVo> userParamVos) {
        List<CompanyUserVo> companyUserVos = new ArrayList<CompanyUserVo>();//用户返回信息的集合

        for (int i = 0; i < userParamVos.size(); i++) {
            CompanyUserVo companyUservo = null;
            //拿出一条信息
            UserParamVo userParam = userParamVos.get(i);
            //查询其身份证号是否存在
            User user = userMongoDao.findByIdNo(userParam.getIdCard());
            //如果这个身份证存在，则验证其姓名
            if (user != null) {
                //如果姓名也相同，就将用户信息存入待返回集合中
                if (user.getUserName().equals(userParam.getName())) {
                    companyUservo = new CompanyUserVo("匹配成功", true, user);
                } else {
                    companyUservo = new CompanyUserVo("姓名不匹配", false, null);
                }
            } else//如果该身份证号不存在，则创建改用户
            {
                companyUservo = new CompanyUserVo("用户不存在", false, null);
            }
            companyUservo.setUserParamVo(userParam);//将当前用户塞入
            companyUserVos.add(companyUservo);
        }

        return companyUserVos;
    }

    public User findByUnionNoAndUnionCheckStatus(String unionNo, int unionCheckStatus) {
        return userMongoDao.findByUnionNoAndUnionCheckStatus(unionNo, unionCheckStatus);
    }

    public User findByIdNo(String idNo) {
        return userMongoDao.findByIdNo(idNo);
    }
}
