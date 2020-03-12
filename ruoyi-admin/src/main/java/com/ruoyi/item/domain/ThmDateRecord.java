package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 体温检测记录日对象 thm_date_record
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public class ThmDateRecord extends BaseEntity
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

    /** 姓名 */
    @Excel(name = "姓名")
    private String personnelName;

    /** 统计日期 */
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attendanceTime;

    /** 检测温度 */
    @Excel(name = "检测温度")
    private Double thermometry;

    /** 检测状态 */
    @Excel(name = "检测状态")
    private String detectionState;

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
    public void setPersonnelName(String personnelName) 
    {
        this.personnelName = personnelName;
    }

    public String getPersonnelName() 
    {
        return personnelName;
    }
    public void setAttendanceTime(Date attendanceTime) 
    {
        this.attendanceTime = attendanceTime;
    }

    public Date getAttendanceTime() 
    {
        return attendanceTime;
    }
    public void setThermometry(Double thermometry) 
    {
        this.thermometry = thermometry;
    }

    public Double getThermometry() 
    {
        return thermometry;
    }
    public void setDetectionState(String detectionState) 
    {
        this.detectionState = detectionState;
    }

    public String getDetectionState() 
    {
        return detectionState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("deptId", getDeptId())
            .append("personnelId", getPersonnelId())
            .append("personnelName", getPersonnelName())
            .append("attendanceTime", getAttendanceTime())
            .append("thermometry", getThermometry())
            .append("detectionState", getDetectionState())
            .toString();
    }
}
