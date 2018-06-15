package com.baixiang.chuxing.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by lipengfei on 2016/11/8.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.baixiang.chuxing.user.persist.mongo")
public class MongoConfig {

}
