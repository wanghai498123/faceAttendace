package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Time;
import java.util.Date;

/**
 * 考勤时间设置对象 rec_time_rule
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public class RecTimeRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long timeRuleId;

    /** 部门 */
    @Excel(name = "部门")
    private Long deptId;

    /** 上班时间 */
    @Excel(name = "上班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String workTime;

    /** 下班时间 */
    @Excel(name = "下班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String workoutTime;

    /** 晚于(分钟)算迟到 */
    @Excel(name = "晚于(分钟)算迟到")
    private Long lateArrival;

    /** 晚于(分钟)算旷工 */
    @Excel(name = "晚于(分钟)算旷工")
    private Long lateArrivalNeglect;

    /** 早于(分钟)算早退 */
    @Excel(name = "早于(分钟)算早退")
    private Long arlyRetirement;

    /** 早于(分钟)算旷工 */
    @Excel(name = "早于(分钟)算旷工")
    private Long arlyRetirementNeglect;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /** 设备名称 */
    @Excel(name = "机构名称")
    private String deptName;

    public void setTimeRuleId(Long timeRuleId) 
    {
        this.timeRuleId = timeRuleId;
    }

    public Long getTimeRuleId() 
    {
        return timeRuleId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setWorkTime(String workTime)
    {
        this.workTime = workTime;
    }

    public String getWorkTime()
    {
        return workTime;
    }
    public void setWorkoutTime(String workoutTime)
    {
        this.workoutTime = workoutTime;
    }

    public String getWorkoutTime()
    {
        return workoutTime;
    }
    public void setLateArrival(Long lateArrival) 
    {
        this.lateArrival = lateArrival;
    }

    public Long getLateArrival() 
    {
        return lateArrival;
    }
    public void setLateArrivalNeglect(Long lateArrivalNeglect) 
    {
        this.lateArrivalNeglect = lateArrivalNeglect;
    }

    public Long getLateArrivalNeglect() 
    {
        return lateArrivalNeglect;
    }
    public void setArlyRetirement(Long arlyRetirement) 
    {
        this.arlyRetirement = arlyRetirement;
    }

    public Long getArlyRetirement() 
    {
        return arlyRetirement;
    }
    public void setArlyRetirementNeglect(Long arlyRetirementNeglect) 
    {
        this.arlyRetirementNeglect = arlyRetirementNeglect;
    }

    public Long getArlyRetirementNeglect() 
    {
        return arlyRetirementNeglect;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("timeRuleId", getTimeRuleId())
            .append("deptId", getDeptId())
            .append("workTime", getWorkTime())
            .append("workoutTime", getWorkoutTime())
            .append("lateArrival", getLateArrival())
            .append("lateArrivalNeglect", getLateArrivalNeglect())
            .append("arlyRetirement", getArlyRetirement())
            .append("arlyRetirementNeglect", getArlyRetirementNeglect())
            .toString();
    }
}
