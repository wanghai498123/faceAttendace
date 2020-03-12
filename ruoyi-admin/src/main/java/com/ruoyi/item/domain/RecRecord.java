package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 考勤记录对象 rec_record
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public class RecRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long recordId;

    /** 机构名称 */
    @Excel(name = "机构名称")
    private Long deptId;

    /** 人员 */
    @Excel(name = "人员")
    private Long personnelId;

    /** 班组ID */
    @Excel(name = "班组ID")
    private Long teamId;

    /** 班组 */
    @Excel(name = "班组")
    private String teamName;

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

    /** 设备名称 */
    @Excel(name = "机构名称")
    private String deptName;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setPersonnelId(Long personnelId) 
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId() 
    {
        return personnelId;
    }
    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }
    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
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
            .append("personnelId", getPersonnelId())
            .append("teamId", getTeamId())
            .append("teamName", getTeamName())
            .append("personnelName", getPersonnelName())
            .append("registrationPhoto", getRegistrationPhoto())
            .append("punchCardPhotos", getPunchCardPhotos())
            .append("punchCardTime", getPunchCardTime())
            .append("punchCardState", getPunchCardState())
            .toString();
    }
}
