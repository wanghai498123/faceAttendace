package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 员工请假对象 rec_personnel_leave
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public class RecPersonnelLeave extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long personnelLeaveId;

    /** 人员 */
    @Excel(name = "人员")
    private Long personnelId;

    /** 请假日期 */
    @Excel(name = "请假日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leaveDate;

    /** 请假类型 */
    @Excel(name = "请假类型")
    private String leaveType;

    /** 请假描叙 */
    @Excel(name = "请假描叙")
    private String leaveScript;

    public void setPersonnelLeaveId(Long personnelLeaveId) 
    {
        this.personnelLeaveId = personnelLeaveId;
    }

    public Long getPersonnelLeaveId() 
    {
        return personnelLeaveId;
    }
    public void setPersonnelId(Long personnelId) 
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId() 
    {
        return personnelId;
    }
    public void setLeaveDate(Date leaveDate) 
    {
        this.leaveDate = leaveDate;
    }

    public Date getLeaveDate() 
    {
        return leaveDate;
    }
    public void setLeaveType(String leaveType) 
    {
        this.leaveType = leaveType;
    }

    public String getLeaveType() 
    {
        return leaveType;
    }
    public void setLeaveScript(String leaveScript) 
    {
        this.leaveScript = leaveScript;
    }

    public String getLeaveScript() 
    {
        return leaveScript;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("personnelLeaveId", getPersonnelLeaveId())
            .append("personnelId", getPersonnelId())
            .append("leaveDate", getLeaveDate())
            .append("leaveType", getLeaveType())
            .append("leaveScript", getLeaveScript())
            .toString();
    }
}
