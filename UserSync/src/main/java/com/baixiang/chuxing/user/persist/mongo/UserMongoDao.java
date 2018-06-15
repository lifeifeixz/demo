package com.baixiang.chuxing.user.persist.mongo;

import com.baixiang.chuxing.user.model.mongo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@SuppressWarnings("all")
@Repository
public interface UserMongoDao extends MongoRepository<User, Long>,QueryDslPredicateExecutor<User> {

    public User findByAccount(String account);

    public Page<User> findAll(Pageable pageable);

    public User findById(long id);

    public Page<User> findByCompanyNotNull(Pageable pageable);

    public User findByIdNo(String idNo);

    public User findByUnionNoAndUnionCheckStatus(String unionNo, int unionCheckStatus);
}