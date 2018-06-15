package com.baixiang.chuxing.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by caiyuan on 2016/11/15.
 */
@Configuration
public class ApiConfig {

    @Value("${http.orderUrl}")
    private String orderUrl;

    @Value("${http.walletUrl}")
    private String walletUrl;
    
    @Value("${http.notificationUrl}")
    private String notificationUrl;

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getWalletUrl() {
        return walletUrl;
    }

    public void setWalletUrl(String walletUrl) {
        this.walletUrl = walletUrl;
    }

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}
    
   
}
