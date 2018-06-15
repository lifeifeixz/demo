package com.baixiang.chuxing.user.persist.mapper;

import com.baixiang.chuxing.user.model.pojo.ActivityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by flysLi on 2017/8/15.
 */
@Repository
@Mapper
public interface ActivityUserMapper {

    /**
     * 列表
     * @return
     */
    @Select("SELECT * FROM activity_user")
    List<ActivityUser> findAll();
}
