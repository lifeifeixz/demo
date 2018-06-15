package com.baixiang.chuxing.user.model.vo;

/**
 * Created by flysLi on 2017/6/19.
 */
public class CompanyVo {
    private long userId;

    //企业名称
    private String company;

    //工号
    private String jobNo;

    //企业审核状态
    private int companyCheckStatus;

    public long getUserId() {
        return userId;
    }

    public String getCompany() {
        return company;
    }

    public String getJobNo() {
        return jobNo;
    }

    public int getCompanyCheckStatus() {
        return companyCheckStatus;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public void setCompanyCheckStatus(int companyCheckStatus) {
        this.companyCheckStatus = companyCheckStatus;
    }
}
