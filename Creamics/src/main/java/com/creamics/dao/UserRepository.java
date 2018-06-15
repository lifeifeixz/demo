package com.creamics.dao;

import com.creamics.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.Resource;

/**
 * Created by flysLi on 2017/8/17.
 */
@Resource
public interface UserRepository extends MongoRepository<User, Integer> {
}
