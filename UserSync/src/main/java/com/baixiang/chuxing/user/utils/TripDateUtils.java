package com.baixiang.chuxing.user.utils;


import java.util.Date;

/**
  @author:luwei
  Date:2017年2月3日
**/
public class TripDateUtils {
     public static boolean driverLicenseValidate(Date date){
        Date today= DateUtils.getStartOfDay(new Date());
         if(date.getTime()>=today.getTime()){
             return false;
         }
        return true;
     }

    public static boolean driverLicenseValidDateValidate(Date date){
        Date today=DateUtils.getStartOfDay(new Date());
        if(date.getTime()<today.getTime()){
            return false;
        }
        Date tenYearsBefore=DateUtils.getBeAfYear(new Date(), 10);
        if(date.getTime()>tenYearsBefore.getTime()){
            return false;
        }
        return true;
    }
}
