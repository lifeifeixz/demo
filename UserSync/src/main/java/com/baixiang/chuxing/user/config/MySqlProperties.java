package com.baixiang.chuxing.user.config;

import com.querydsl.core.annotations.Config;
import org.springframework.context.annotation.Configuration;

/**
 * Created by flysLi on 2017/8/15.
 */
@Configuration
public class MySqlProperties {
    public String driver;

    public String username;

    public String password;

    public String databases;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabases() {
        return databases;
    }

    public void setDatabases(String databases) {
        this.databases = databases;
    }
}
