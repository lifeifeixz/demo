/**
 * <p> Title:</p>
 * <p> Description: </p>
 * @author luwei
 * @date 2016年4月26日
 */
package com.baixiang.chuxing.user.model.vo;
//验证码缓存

import java.io.Serializable;
import java.util.Date;

public class CaptchaVo implements Serializable{

  // 主键，如电话号码，邮箱号码
  private String key;
  
  //验证码
  private String captcha;
  
  //产生时间,改为时间戳
  private Date generateDatetime; 
  
  //过期时间,15分钟后过期
  private int captureExpireInterval;

  public CaptchaVo() {
  }

  /**
   * @param key
   * @param captcha
   */
  public CaptchaVo(String key, String captcha) {
    super();
    this.key = key;
    this.captcha = captcha;
    this.generateDatetime=new Date() ;
    this.captureExpireInterval=60*15;
  }
  
  public CaptchaVo(String key, String captcha, int expiredSeconds) {
    super();
    this.key = key;
    this.captcha = captcha;
    this.generateDatetime=new Date();
    this.captureExpireInterval = expiredSeconds;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * @param key the key to set
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * @return the captcha
   */
  public String getCaptcha() {
    return captcha;
  }

  /**
   * @param captcha the captcha to set
   */
  public void setCaptcha(String captcha) {
    this.captcha = captcha;
  }

  /**
   * @return the generateDatetime
   */
  public Date getGenerateDatetime() {
    return generateDatetime;
  }

  /**
   * @param generateDatetime the generateDatetime to set
   */
  public void setGenerateDatetime(Date generateDatetime) {
    this.generateDatetime = generateDatetime;
  }

  /**
   * @return the captureExpireInterval
   */
  public int getCaptureExpireInterval() {
    return captureExpireInterval;
  }

  /**
   * @param captureExpireInterval the captureExpireInterval to set
   */
  public void setCaptureExpireInterval(int captureExpireInterval) {
    this.captureExpireInterval = captureExpireInterval;
  }


  

}
