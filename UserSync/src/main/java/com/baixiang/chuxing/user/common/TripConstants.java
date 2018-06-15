package com.baixiang.chuxing.user.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiyuan on 2016/10/19.
 */
public class TripConstants {

    public static boolean DEBUG = false;    //是否调试模式

    public static final String SESSION_USER = "SESSION_USER";
    
    public interface DriverTripStatus{
        public static final String NEW = "new";         //新订单
        public static final String ORDERED = "ordered";     //已接单
        public static final String STARTED = "started";   //已开始
        public static final String DONE = "done";           //已完成
        public static final String CANCELLED="cancelled";   //已取消
    }

    public interface PassengerTripStatus{
        public static final String NEW = "new";         //新订单
        public static final String ORDERED = "ordered";     //已被接单
        public static final String STARTED = "started";   //已开始
        public static final String PICKUPED = "pickuped";   //已接到
        public static final String DONE = "done";           //已完成
        public static final String CANCELLED="cancelled";   //已取消
    }
    
    /**
     * 租车行程状态
     * @author luwei
     * Date:2017年1月18日
     *
     */
    public interface RentTripStatus{
        public static final String NEW = "new";         //新订单
        public static final String STARTED = "started";   //已开始
        public static final String DONE = "done";           //已完成
        public static final String CANCELLED="cancelled";   //已取消
    }
    
    public interface RoleType{
    	public static final String passenger="passenger";
    	public static final String driver="driver";
    }
    
    public interface TripType{
    	public static final String share="share";
    	public static final String rent="rent";
    	public static final String bus="bus";
    }
    
    public interface OrderStatus{
    	public static String CANCELED="CANCELED";
    	public static String CREATE="CREATE";
        public static String IN_VEHICLE="IN_VEHICLE";
        public static String FINISHED="FINISHED";
    }

    public interface PayStatus{
        public static String PAID="PAID";
        public static String WAIT_PAY="WAIT_PAY";
        public static String NOT_NEED_PAY="NOT_NEED_PAY";
        public static String CREATE="CREATE";
    }
    
    /**
     * 车辆租赁状态
     * @author luwei
     * Date:2017年1月18日
     *
     */
    public interface VehicleRentStatus{
    	public static String HIRING="HIRING";//租赁中
    	public static String TOHIRE="TOHIRE";//可租赁
    	public static String BOOKED="BOOKED";//已预约
    }
    
    /**
     * 车辆的拼车状态
     * @author luwei
     * Date:2017年1月20日
     *
     */
    public interface VehicleShareStatus{
    	public static String REST="REST";//空闲中
    	public static String WAITING="WAITING";//正在拼车中
    	public static String RUNNING="RUNNING";//运行中
    }


    public static class ZebraCommandResultType{
    	static Map<String,String> resultType=new HashMap<String,String>();
    	static {
    	resultType.put("00", "等待中");
    	resultType.put("01", "执行中");
    	resultType.put("02", "已完成");
    	resultType.put("03", "失败");
    	resultType.put("99", "未知参数");
    	}
    	
    }
    
    /**
     * 支持的消息类型
     * @author luwei
     * Date:2016年12月12日
     *
     */
    public interface MessageChannel{
        
        public static final String UI = "ui"; //站内信
        public static final String EMAIL = "email";  //邮件    
        public static final String WECHAT = "wechat"; //微信 
        public static final String SMS = "sms"; //短信
        public static final String GETUI = "getui";  //个推      
      }
    
    public interface MessageSenario{
    	/*----------------------------拼车乘客端---------------------------------------------------*/
    	//public static final String SHARE_PASS_MATCH_SUCCESS="share_pass_match_success";//乘客匹配成功
    	public static final String SHARE_PASS_MATCH_FAIL="share_pass_match_fail";//乘客匹配失败,20分钟后，未有接单则提示
    	public static final String SHARE_PASS_ORDERED="share_pass_match_ordered";//被接单
    	public static final String SHARE_PASS_START="share_pass_start";//司机出发开始接乘客
    	public static final String SHARE_PASS_DONE="share_pass_done";//行程结束
    	//public static final String SHARE_PASS_WAIT_PAY="share_pass_wait_pay";//行程结束,未支付,这条消息，由订单发送比较合适
    	//public static final String SHARE_PASS_CANCELL="share_pass_cancell";//乘客取消了行程
    	public static final String SHARE_PASS_DRIVER_CANCELL="share_pass_driver_cancell";//司机取消了行程
    	
    	/*---------------------------拼车司机端--------------------------------------------------*/
    	public static final String SHARE_DRIVER_PASS_NEW="share_driver_pass_new";//有新的乘客匹配行程。
    	public static final String SHARE_DRIVER_PASS_CANCELL="share_driver_pass_cancell";//乘客取消
    	public static final String SHARE_DRIVER_PASS_PAY="share_driver_pass_pay";//乘客支付完成后提示
    	//public static final String SHARE_DRIVER_TODAY_INCOME="share_driver_today_income";//今日收入
    	public static final String SHARE_DRIVER_TODAY_TRIP="share_driver_today_trip";//今日行程，出发前20分钟提示
    	//public static final String SHARE_DRIVER_PARK="share_driver_today_trip";//获取停车入场资格提示
    	//public static final String SHARE_DRIVER_DONE="share_driver_done";//行程完成
    	
    	/*--------------------------- 用户信息变化---------------------------------------------------*/
     	public static final String USER_INFO_CHECKED="share_driver_info_checked";//信息验证
    	public static final String USER_INFO_CHANGE_CHECKED="user_info_change_checked";//信息变更验证
    	public static final String USER_INFO_CHANGE="user_info_change";//用户信息变更
    	
    	
    	
    }
    
    public interface CheckStatus{
        public static int NO_PERFECT=0;//未完善
    	public static int TO_CHECK=1;//待审核
    	public static int CHECK_PASS=2;//审核通过
    	public static int CHECK_FAIL=3;//审核不通过
    }
    
    public interface VehicleOwnerType{
    	public static String PERSONAL="personal";
    	public static String COMPANY="company";
    	public static String SELF="self";
    }

    /*结果*/
    public interface Result{
        public static String SUCCESS = "SUCCESS";//成功
        public static String FAIL = "FAIL";//失败
        public static String UNKNOWN = "Unknown";//未知
    }

    //用户认证渠道
    public interface AuthChannel{
        public static String UNION = "Union";//工会
        public static String ALIPAY = "Alipay";//支付宝
        public static String BACKSTAGE = "Backstage";//后台
    }

}
