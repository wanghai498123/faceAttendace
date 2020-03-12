package com.ruoyi.item.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 建筑公司对象 item_company
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public class ItemCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long companyId;

    /** 劳务公司 */
    @Excel(name = "劳务公司")
    private Long deptId;

    /** 设备名称 */
    @Excel(name = "劳务公司")
    private String deptName;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phonenumber;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String region;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String fullAddress;

    /** 纳税人识别号 */
    @Excel(name = "纳税人识别号")
    private String taxpayerNumber;

    /** 信用代码 */
    @Excel(name = "信用代码")
    private String creditCode;

    /** 注册资金 */
    @Excel(name = "注册资金")
    private String registeredCapital;

    /** 单位类型 */
    @Excel(name = "单位类型")
    private String unittype;

    /** 银行代码 */
    @Excel(name = "银行代码")
    private String bankCode;

    /** 支行名称 */
    @Excel(name = "支行名称")
    private String subbranch;

    /** 银行卡号 */
    @Excel(name = "银行卡号")
    private String bankNumber;

    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public String getContact() 
    {
        return contact;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setFullAddress(String fullAddress) 
    {
        this.fullAddress = fullAddress;
    }

    public String getFullAddress() 
    {
        return fullAddress;
    }
    public void setTaxpayerNumber(String taxpayerNumber) 
    {
        this.taxpayerNumber = taxpayerNumber;
    }

    public String getTaxpayerNumber() 
    {
        return taxpayerNumber;
    }
    public void setCreditCode(String creditCode) 
    {
        this.creditCode = creditCode;
    }

    public String getCreditCode() 
    {
        return creditCode;
    }
    public void setRegisteredCapital(String registeredCapital) 
    {
        this.registeredCapital = registeredCapital;
    }

    public String getRegisteredCapital() 
    {
        return registeredCapital;
    }
    public void setUnittype(String unittype) 
    {
        this.unittype = unittype;
    }

    public String getUnittype() 
    {
        return unittype;
    }
    public void setBankCode(String bankCode) 
    {
        this.bankCode = bankCode;
    }

    public String getBankCode() 
    {
        return bankCode;
    }
    public void setSubbranch(String subbranch) 
    {
        this.subbranch = subbranch;
    }

    public String getSubbranch() 
    {
        return subbranch;
    }

    public void setBankNumber(String bankNumber)
    {
        this.bankNumber = bankNumber;
    }
    public String getBankNumber() 
    {
        return bankNumber;
    }

    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("deptId", getDeptId()).append("companyName", getCompanyName())
            .append("contact", getContact())
            .append("phonenumber", getPhonenumber())
            .append("email", getEmail())
            .append("province", getProvince())
            .append("city", getCity())
            .append("region", getRegion())
            .append("fullAddress", getFullAddress())
            .append("taxpayerNumber", getTaxpayerNumber())
            .append("creditCode", getCreditCode())
            .append("registeredCapital", getRegisteredCapital())
            .append("unittype", getUnittype())
            .append("bankCode", getBankCode())
            .append("subbranch", getSubbranch())
            .append("bankNumber", getBankNumber())
            .toString();
    }
}
