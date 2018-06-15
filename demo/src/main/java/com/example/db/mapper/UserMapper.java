package com.example.db.mapper;

import com.example.db.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author flysLi
 * @date 2018/6/15
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id查询user
     *
     * @param id
     * @return
     */
    User findById(int id);
}
