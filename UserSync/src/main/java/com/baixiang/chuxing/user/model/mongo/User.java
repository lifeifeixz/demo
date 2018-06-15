package com.baixiang.chuxing.user.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by liming on 2017/3/1.
 */
//@Document(collection="user")
//@Entity
public class User {

    public static final String TABLE_NAME = "user";

    @Id//如果属性名是id也可以不写
    private long id;

    //电话号码
    @Indexed(unique = true)
    @Field("mobile_num")
    private String account;

    //名
    private String firstName;

    //姓
    private String lastName;

    //头像
    private String avatar;

    //性别
    private String gender;

    //邮箱地址
    private String email;

    //身份证号
    private String idNo;

    //身份证正面
    private String idPhoto1;

    //身份证反面
    private String idPhoto2;

    //1:待审核，2:审核通过,3:审核不通过
    private int idPhotoCheckStatus;

    //驾驶证号码
    private String driverLicenseNo;

    //驾驶证正面
    private String driverLicense1;

    //驾驶证反面
    private String driverLicense2;

    //驾驶证获取日期
    private Date driverLicenseDate;

    //驾驶证有效期
    private Date driverLicenseValidDate;

    //1:待审核，2:审核通过,3:审核不通过
    private int driverLicenseCheckStatus;

    //默认支付渠道
    private String payChannel;

    //用户状态
    private String status;

    //创建或注册日期
    private Date createDatetime;

    //更新日期
    private Date updateDatetime;

    //登录时间
    private Date loginDatetime;

    //审核人
    private String checkBy;
    //审核原因
    private String checkReason;
    //审核时间
    private Date checkDatetime;

    //所在城市
    private String city;

    //地址
    private String address;

    //车辆数
    private int vehicleNum;

    //集团
    private String group;

    //工号
    private String jobNo;

    //工牌
    private String jobIdPhoto;

    //公司
    private String company;

    //部门
    private String depart;

    //备注
    private String remark;

    //司机审核人员
    private String driverCheckBy;

    //司机审核驳回理由
    private String driverCheckReason;

    //司机审核时间
    private Date driverCheckDatetime;

    //企业审核人员
    private String companyCheckBy;

    //企业审核驳回理由
    private String companyCheckReason;

    //企业审核时间
    private Date companyCheckDatetime;

    //企业审核状态
    private int companyCheckStatus;

    //信用卡
    private String creditNo;

    //信用卡有效期
    private String creditTermOfValidity;

    //发票抬头
    private String invoiceHeader;

    //姓名
    private String userName;

    //公会卡号
    private String unionNo;

    //公会审核人员
    private String unionCheckBy;

    //公会审核驳回理由
    private String unionCheckReason;

    //公会审核时间
    private Date unionCheckDatetime;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    //公会审核状态
    private int unionCheckStatus;

    //用户来源
    private String source;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDriverCheckBy(String driverCheckBy) {
        this.driverCheckBy = driverCheckBy;
    }

    public void setDriverCheckReason(String driverCheckReason) {
        this.driverCheckReason = driverCheckReason;
    }

    public void setDriverCheckDatetime(Date driverCheckDatetime) {
        this.driverCheckDatetime = driverCheckDatetime;
    }

    public void setCompanyCheckBy(String companyCheckBy) {
        this.companyCheckBy = companyCheckBy;
    }

    public void setCompanyCheckReason(String companyCheckReason) {
        this.companyCheckReason = companyCheckReason;
    }

    public void setCompanyCheckDatetime(Date companyCheckDatetime) {
        this.companyCheckDatetime = companyCheckDatetime;
    }

    public void setCompanyCheckStatus(int companyCheckStatus) {
        this.companyCheckStatus = companyCheckStatus;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public String getDriverCheckBy() {
        return driverCheckBy;
    }

    public String getDriverCheckReason() {
        return driverCheckReason;
    }

    public Date getDriverCheckDatetime() {
        return driverCheckDatetime;
    }

    public String getCompanyCheckBy() {
        return companyCheckBy;
    }

    public String getCompanyCheckReason() {
        return companyCheckReason;
    }

    public Date getCompanyCheckDatetime() {
        return companyCheckDatetime;
    }

    public int getCompanyCheckStatus() {
        return companyCheckStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        StringBuffer userName=new StringBuffer();
        userName.append(this.getLastName()==null?"":this.getLastName());
        userName.append(this.getFirstName()==null?"":this.getFirstName());
        this.userName = userName.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        StringBuffer userName=new StringBuffer();
        userName.append(this.getLastName()==null?"":this.getLastName());
        userName.append(this.getFirstName()==null?"":this.getFirstName());
        this.userName = userName.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(){

    }
    public User(long id, String account, String firstName, String lastName, String avatar, String gender, String email, String idNo, String idPhoto1, String idPhoto2, int idPhotoCheckStatus, String driverLicenseNo, String driverLicense1, String driverLicense2, Date driverLicenseDate, Date driverLicenseValidDate, int driverLicenseCheckStatus, String payChannel, String status, Date createDatetime, Date updateDatetime, Date loginDatetime, String checkBy, String checkReason, Date checkDatetime, String city, String address, int vehicleNum, String group, String jobNo, String company, String depart, String remark, String driverCheckBy, String driverCheckReason, Date driverCheckDatetime, String companyCheckBy, String companyCheckReason, Date companyCheckDatetime, int companyCheckStatus, String creditNo, String creditTermOfValidity, String invoiceHeader) {
        this.id = id;
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
        this.gender = gender;
        this.email = email;
        this.idNo = idNo;
        this.idPhoto1 = idPhoto1;
        this.idPhoto2 = idPhoto2;
        this.idPhotoCheckStatus = idPhotoCheckStatus;
        this.driverLicenseNo = driverLicenseNo;
        this.driverLicense1 = driverLicense1;
        this.driverLicense2 = driverLicense2;
        this.driverLicenseDate = driverLicenseDate;
        this.driverLicenseValidDate = driverLicenseValidDate;
        this.driverLicenseCheckStatus = driverLicenseCheckStatus;
        this.payChannel = payChannel;
        this.status = status;
        this.createDatetime = createDatetime;
        this.updateDatetime = updateDatetime;
        this.loginDatetime = loginDatetime;
        this.checkBy = checkBy;
        this.checkReason = checkReason;
        this.checkDatetime = checkDatetime;
        this.city = city;
        this.address = address;
        this.vehicleNum = vehicleNum;
        this.group = group;
        this.jobNo = jobNo;
        this.company = company;
        this.depart = depart;
        this.remark = remark;
        this.driverCheckBy = driverCheckBy;
        this.driverCheckReason = driverCheckReason;
        this.driverCheckDatetime = driverCheckDatetime;
        this.companyCheckBy = companyCheckBy;
        this.companyCheckReason = companyCheckReason;
        this.companyCheckDatetime = companyCheckDatetime;
        this.companyCheckStatus = companyCheckStatus;
        this.creditNo = creditNo;
        this.creditTermOfValidity = creditTermOfValidity;
        this.invoiceHeader = invoiceHeader;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", idNo='" + idNo + '\'' +
                ", idPhoto1='" + idPhoto1 + '\'' +
                ", idPhoto2='" + idPhoto2 + '\'' +
                ", idPhotoCheckStatus=" + idPhotoCheckStatus +
                ", driverLicenseNo='" + driverLicenseNo + '\'' +
                ", driverLicense1='" + driverLicense1 + '\'' +
                ", driverLicense2='" + driverLicense2 + '\'' +
                ", driverLicenseDate=" + driverLicenseDate +
                ", driverLicenseValidDate=" + driverLicenseValidDate +
                ", driverLicenseCheckStatus=" + driverLicenseCheckStatus +
                ", payChannel='" + payChannel + '\'' +
                ", status='" + status + '\'' +
                ", createDatetime=" + createDatetime +
                ", updateDatetime=" + updateDatetime +
                ", loginDatetime=" + loginDatetime +
                ", checkBy='" + checkBy + '\'' +
                ", checkReason='" + checkReason + '\'' +
                ", checkDatetime=" + checkDatetime +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", vehicleNum=" + vehicleNum +
                ", group='" + group + '\'' +
                ", jobNo='" + jobNo + '\'' +
                ", company='" + company + '\'' +
                ", depart='" + depart + '\'' +
                ", remark='" + remark + '\'' +
                ", driverCheckBy='" + driverCheckBy + '\'' +
                ", driverCheckReason='" + driverCheckReason + '\'' +
                ", driverCheckDatetime=" + driverCheckDatetime +
                ", companyCheckBy='" + companyCheckBy + '\'' +
                ", companyCheckReason='" + companyCheckReason + '\'' +
                ", companyCheckDatetime=" + companyCheckDatetime +
                ", companyCheckStatus=" + companyCheckStatus +
                ", creditNo='" + creditNo + '\'' +
                ", creditTermOfValidity='" + creditTermOfValidity + '\'' +
                ", invoiceHeader='" + invoiceHeader + '\'' +
                '}';
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public void setCreditTermOfValidity(String creditTermOfValidity) {
        this.creditTermOfValidity = creditTermOfValidity;
    }

    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public String getJobNo() {

        return jobNo;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public String getCreditTermOfValidity() {
        return creditTermOfValidity;
    }

    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdPhoto1() {
        return idPhoto1;
    }

    public void setIdPhoto1(String idPhoto1) {
        this.idPhoto1 = idPhoto1;
    }

    public String getIdPhoto2() {
        return idPhoto2;
    }

    public void setIdPhoto2(String idPhoto2) {
        this.idPhoto2 = idPhoto2;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getDriverLicense1() {
        return driverLicense1;
    }

    public void setDriverLicense1(String driverLicense1) {
        this.driverLicense1 = driverLicense1;
    }

    public String getDriverLicense2() {
        return driverLicense2;
    }

    public void setDriverLicense2(String driverLicense2) {
        this.driverLicense2 = driverLicense2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Date getLoginDatetime() {
        return loginDatetime;
    }

    public void setLoginDatetime(Date loginDatetime) {
        this.loginDatetime = loginDatetime;
    }

    public Date getDriverLicenseDate() {
        return driverLicenseDate;
    }

    public void setDriverLicenseDate(Date driverLicenseDate) {
        this.driverLicenseDate = driverLicenseDate;
    }

    public Date getDriverLicenseValidDate() {
        return driverLicenseValidDate;
    }

    public void setDriverLicenseValidDate(Date driverLicenseValidDate) {
        this.driverLicenseValidDate = driverLicenseValidDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName(){
        StringBuffer userName=new StringBuffer();
        userName.append(this.getLastName()==null?"":this.getLastName());
        userName.append(this.getFirstName()==null?"":this.getFirstName());
        return userName.toString();
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public String getCheckReason() {
        return checkReason;
    }

    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    public Date getCheckDatetime() {
        return checkDatetime;
    }

    public void setCheckDatetime(Date checkDatetime) {
        this.checkDatetime = checkDatetime;
    }

    public int getIdPhotoCheckStatus() {
        return idPhotoCheckStatus;
    }

    public void setIdPhotoCheckStatus(int idPhotoCheckStatus) {
        this.idPhotoCheckStatus = idPhotoCheckStatus;
    }

    public int getDriverLicenseCheckStatus() {
        return driverLicenseCheckStatus;
    }

    public void setDriverLicenseCheckStatus(int driverLicenseCheckStatus) {
        this.driverLicenseCheckStatus = driverLicenseCheckStatus;
    }

    public int getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(int vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getJobIdPhoto() {
        return jobIdPhoto;
    }

    public void setJobIdPhoto(String jobIdPhoto) {
        this.jobIdPhoto = jobIdPhoto;
    }

    public String getUnionNo() {
        return unionNo;
    }

    public void setUnionNo(String unionNo) {
        this.unionNo = unionNo;
    }

    public String getUnionCheckBy() {
        return unionCheckBy;
    }

    public void setUnionCheckBy(String unionCheckBy) {
        this.unionCheckBy = unionCheckBy;
    }

    public String getUnionCheckReason() {
        return unionCheckReason;
    }

    public void setUnionCheckReason(String unionCheckReason) {
        this.unionCheckReason = unionCheckReason;
    }

    public Date getUnionCheckDatetime() {
        return unionCheckDatetime;
    }

    public void setUnionCheckDatetime(Date unionCheckDatetime) {
        this.unionCheckDatetime = unionCheckDatetime;
    }

    public int getUnionCheckStatus() {
        return unionCheckStatus;
    }

    public void setUnionCheckStatus(int unionCheckStatus) {
        this.unionCheckStatus = unionCheckStatus;
    }
}
