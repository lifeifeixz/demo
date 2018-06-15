package com.baixiang.chuxing.user.controller;

import com.baixiang.chuxing.commonsession.service.CommonSessionService;
import com.baixiang.chuxing.core.config.helper.IdWorkerHelper;
import com.baixiang.chuxing.user.model.vo.CompanyUserVo;
import com.baixiang.chuxing.user.model.vo.UserParamVo;
import com.baixiang.chuxing.user.persist.mapper.ActivityUserMapper;
import com.baixiang.chuxing.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by flysLi on 2017/3/15.
 */
@Api("用户信息同步")
@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    UserService userService;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    MongoTemplate mongoTemplate;

    @Autowired
    CommonSessionService commonSessionService;

    @Resource
    IdWorkerHelper idWorkerHelper;

    /**
     * 企业端用户同步
     *
     * @param users
     * @return
     * @auther flysLi
     * @see 2017-05-26
     */
    @ApiOperation("企业端同步用户")
    @RequestMapping(value = "/user/syncUser", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<CompanyUserVo> syncUser(@ApiParam(value = "用户信息集合", required = true) @RequestBody List<UserParamVo> users) {
        return userService.compareUsers(users);
    }

    /**
     * 同步第三方库的用户至user服务中
     * @return
     */
    @ApiOperation("第三方同步用户")
    @RequestMapping(value = "/user/sync",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public int sync(){

        // TODO: 2017/8/14 如果用户已存在(通过手机号判断),将略过;否则就新增用户,并开通钱包 
        return 89;
    }
}
