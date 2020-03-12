package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 来访记录对象 vtr_record
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public class VtrRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long recordId;

    /** 机构 */
    @Excel(name = "机构")
    private Long deptId;

    /** 访客 */
    @Excel(name = "访客")
    private Long subscribeId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String personnelName;

    /** 登记照片 */
    @Excel(name = "登记照片")
    private String registrationPhoto;

    /** 打卡照片 */
    @Excel(name = "打卡照片")
    private String punchCardPhotos;

    /** 打卡时间 */
    @Excel(name = "打卡时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date punchCardTime;

    /** 状态(进场，出场) */
    @Excel(name = "状态(进场，出场)")
    private String punchCardState;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /** 机构名称 */
    @Excel(name = "机构名称")
    private String deptName;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setSubscribeId(Long subscribeId) 
    {
        this.subscribeId = subscribeId;
    }

    public Long getSubscribeId() 
    {
        return subscribeId;
    }
    public void setPersonnelName(String personnelName) 
    {
        this.personnelName = personnelName;
    }

    public String getPersonnelName() 
    {
        return personnelName;
    }
    public void setRegistrationPhoto(String registrationPhoto) 
    {
        this.registrationPhoto = registrationPhoto;
    }

    public String getRegistrationPhoto() 
    {
        return registrationPhoto;
    }
    public void setPunchCardPhotos(String punchCardPhotos) 
    {
        this.punchCardPhotos = punchCardPhotos;
    }

    public String getPunchCardPhotos() 
    {
        return punchCardPhotos;
    }
    public void setPunchCardTime(Date punchCardTime) 
    {
        this.punchCardTime = punchCardTime;
    }

    public Date getPunchCardTime() 
    {
        return punchCardTime;
    }
    public void setPunchCardState(String punchCardState) 
    {
        this.punchCardState = punchCardState;
    }

    public String getPunchCardState() 
    {
        return punchCardState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("deptId", getDeptId())
            .append("subscribeId", getSubscribeId())
            .append("personnelName", getPersonnelName())
            .append("registrationPhoto", getRegistrationPhoto())
            .append("punchCardPhotos", getPunchCardPhotos())
            .append("punchCardTime", getPunchCardTime())
            .append("punchCardState", getPunchCardState())
            .toString();
    }
}
