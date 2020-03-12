package com.ruoyi.item.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 考勤日报对象 rec_daterecord
 * 
 * @author wanghai
 * @date 2019-11-12
 */
public class RecDaterecord extends BaseEntity
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

    /** 班组 */
    @Excel(name = "班组")
    private String teamName;

    /** 姓名 */
    @Excel(name = "姓名")
    private String personnelName;

    /** 统计日期 */
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attendanceTime;

    /** 上班打卡时间 */
    @Excel(name = "上班打卡时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date punchCardTime1;

    /** 休息打卡时间 */
    @Excel(name = "休息打卡时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date punchCardTime2;

    /** 休息上班时间 */
    @Excel(name = "休息上班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date punchCardTime3;

    /** 下班打卡时间 */
    @Excel(name = "下班打卡时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date punchCardTime4;

    /** 迟到次数 */
    @Excel(name = "迟到次数")
    private Long lateness;

    /** 迟到时长 */
    @Excel(name = "迟到时长")
    private Long lateArrivalTime;

    /** 早退次数 */
    @Excel(name = "早退次数")
    private Long earlyRetirementTimes;

    /** 早退时长 */
    @Excel(name = "早退时长")
    private Long arlyRetirementTime;

    /** 旷工 */
    @Excel(name = "旷工")
    private Long neglectWork;

    /** 有效工日 */
    @Excel(name = "有效工日")
    private Long effectiveWorkingDay;

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
    public void setAttendanceTime(Date attendanceTime) 
    {
        this.attendanceTime = attendanceTime;
    }

    public Date getAttendanceTime() 
    {
        return attendanceTime;
    }
    public void setPunchCardTime1(Date punchCardTime1) 
    {
        this.punchCardTime1 = punchCardTime1;
    }

    public Date getPunchCardTime1() 
    {
        return punchCardTime1;
    }
    public void setPunchCardTime2(Date punchCardTime2) 
    {
        this.punchCardTime2 = punchCardTime2;
    }

    public Date getPunchCardTime2() 
    {
        return punchCardTime2;
    }
    public void setPunchCardTime3(Date punchCardTime3) 
    {
        this.punchCardTime3 = punchCardTime3;
    }

    public Date getPunchCardTime3() 
    {
        return punchCardTime3;
    }
    public void setPunchCardTime4(Date punchCardTime4) 
    {
        this.punchCardTime4 = punchCardTime4;
    }

    public Date getPunchCardTime4() 
    {
        return punchCardTime4;
    }
    public void setLateness(Long lateness) 
    {
        this.lateness = lateness;
    }

    public Long getLateness() 
    {
        return lateness;
    }
    public void setLateArrivalTime(Long lateArrivalTime) 
    {
        this.lateArrivalTime = lateArrivalTime;
    }

    public Long getLateArrivalTime() 
    {
        return lateArrivalTime;
    }
    public void setEarlyRetirementTimes(Long earlyRetirementTimes) 
    {
        this.earlyRetirementTimes = earlyRetirementTimes;
    }

    public Long getEarlyRetirementTimes() 
    {
        return earlyRetirementTimes;
    }
    public void setArlyRetirementTime(Long arlyRetirementTime) 
    {
        this.arlyRetirementTime = arlyRetirementTime;
    }

    public Long getArlyRetirementTime() 
    {
        return arlyRetirementTime;
    }
    public void setNeglectWork(Long neglectWork) 
    {
        this.neglectWork = neglectWork;
    }

    public Long getNeglectWork() 
    {
        return neglectWork;
    }
    public void setEffectiveWorkingDay(Long effectiveWorkingDay) 
    {
        this.effectiveWorkingDay = effectiveWorkingDay;
    }

    public Long getEffectiveWorkingDay() 
    {
        return effectiveWorkingDay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("deptId", getDeptId())
            .append("personnelId", getPersonnelId())
            .append("teamName", getTeamName())
            .append("personnelName", getPersonnelName())
            .append("attendanceTime", getAttendanceTime())
            .append("punchCardTime1", getPunchCardTime1())
            .append("punchCardTime2", getPunchCardTime2())
            .append("punchCardTime3", getPunchCardTime3())
            .append("punchCardTime4", getPunchCardTime4())
            .append("lateness", getLateness())
            .append("lateArrivalTime", getLateArrivalTime())
            .append("earlyRetirementTimes", getEarlyRetirementTimes())
            .append("arlyRetirementTime", getArlyRetirementTime())
            .append("neglectWork", getNeglectWork())
            .append("effectiveWorkingDay", getEffectiveWorkingDay())
            .toString();
    }
}
