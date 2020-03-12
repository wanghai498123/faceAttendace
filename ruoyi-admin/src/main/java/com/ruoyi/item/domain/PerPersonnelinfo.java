package com.ruoyi.item.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 人员信息对象 per_personnelinfo
 *
 * @author wanghai
 * @date 2019-11-09
 */
public class PerPersonnelinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    private List<MultipartFile> files;
    /** 标识 */
    private Long personnelId;

    /** 机构 */
    @Excel(name = "机构")
    private Long deptId;

    /** 设备名称 */
    @Excel(name = "机构")
    private String deptName;

    /** 姓名 */
    @Excel(name = "姓名")
    private String personnelName;

    /** 识别卡号 */
    @Excel(name = "识别卡号")
    private String cardNumber;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private Date birthday;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String sex;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contact;

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

    /** 人员类型 */
    @Excel(name = "人员类型")
    private String personnelType;

    /** 岗位 */
    @Excel(name = "岗位")
    private int postId;

    /** 考勤班次 */
    @Excel(name = "考勤班次名称")
    private String classesName;

    /** 关键岗位 */
    @Excel(name = "关键岗位")
    private String keyJob;

    /** 在岗时间 */
    @Excel(name = "在岗时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dutyTime;

    /** 进场时间 */
    @Excel(name = "进场时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approachTime;

    /** 有效期 */
    @Excel(name = "有效期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date validity;

    /** 数据下发 */
    @Excel(name = "数据下发")
    private String dataDissemination;

    /** 人脸 */
    @Excel(name = "人脸")
    private String facePath;

    /** 证件 */
    @Excel(name = "证件")
    private String certificatePath;

    /** 在职状态 */
    @Excel(name = "在职状态")
    private String incumbency;

    /** 数据下发状态 */
    @Excel(name = "数据下发状态")
    private String dataState;

    /** 头像路径 */
    @Excel(name = "头像路径")
    private String avatar;

    public void setPersonnelId(Long personnelId)
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId()
    {
        return personnelId;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setPersonnelName(String personnelName)
    {
        this.personnelName = personnelName;
    }

    public String getPersonnelName()
    {
        return personnelName;
    }
    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }
    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber()
    {
        return idNumber;
    }
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Date getBirthday()
    {
        return birthday;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getContact()
    {
        return contact;
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
    public void setPersonnelType(String personnelType)
    {
        this.personnelType = personnelType;
    }

    public String getPersonnelType()
    {
        return personnelType;
    }
    public void setPostId(int postId)
    {
        this.postId = postId;
    }

    public int getPostId()
    {
        return postId;
    }
    public void setKeyJob(String keyJob)
    {
        this.keyJob = keyJob;
    }

    public String getKeyJob()
    {
        return keyJob;
    }
    public void setDutyTime(Date dutyTime)
    {
        this.dutyTime = dutyTime;
    }

    public Date getDutyTime()
    {
        return dutyTime;
    }
    public void setApproachTime(Date approachTime)
    {
        this.approachTime = approachTime;
    }

    public Date getApproachTime()
    {
        return approachTime;
    }
    public void setValidity(Date validity)
    {
        this.validity = validity;
    }

    public Date getValidity()
    {
        return validity;
    }
    public void setDataDissemination(String dataDissemination)
    {
        this.dataDissemination = dataDissemination;
    }

    public String getDataDissemination()
    {
        return dataDissemination;
    }
    public void setFacePath(String facePath)
    {
        this.facePath = facePath;
    }

    public String getFacePath()
    {
        return facePath;
    }
    public void setCertificatePath(String certificatePath)
    {
        this.certificatePath = certificatePath;
    }

    public String getCertificatePath()
    {
        return certificatePath;
    }
    public void setIncumbency(String incumbency)
    {
        this.incumbency = incumbency;
    }

    public String getIncumbency()
    {
        return incumbency;
    }
    public void setDataState(String dataState) 
    {
        this.dataState = dataState;
    }

    public String getDataState() 
    {
        return dataState;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("personnelId", getPersonnelId())
                .append("deptId", getDeptId())
                .append("personnelName", getPersonnelName())
                .append("cardNumber", getCardNumber())
                .append("idNumber", getIdNumber())
                .append("birthday", getBirthday())
                .append("sex", getSex())
                .append("contact", getContact())
                .append("province", getProvince())
                .append("city", getCity())
                .append("region", getRegion())
                .append("fullAddress", getFullAddress())
                .append("personnelType", getPersonnelType())
                .append("postId", getPostId())
                .append("keyJob", getKeyJob())
                .append("dutyTime", getDutyTime())
                .append("approachTime", getApproachTime())
                .append("validity", getValidity())
                .append("dataDissemination", getDataDissemination())
                .append("facePath", getFacePath())
                .append("certificatePath", getCertificatePath())
                .append("incumbency", getIncumbency())
                .append("dataState", getDataState())
            .append("avatar", getAvatar())
                .toString();
    }
}
