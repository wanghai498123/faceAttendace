package com.ruoyi.item.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 考勤规则对象 rec_rule
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public class RecRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long ruleId;

    /** 建筑公司 */
    @Excel(name = "建筑公司")
    private Long deptId;

    /** 设备名称 */
    @Excel(name = "建筑公司")
    private String deptName;

    /** 上班超时 */
    @Excel(name = "上班超时")
    private Integer overtimeWork;

    /** 下班提前 */
    @Excel(name = "下班提前")
    private Integer advanceFromWork;

    /** 迟到超过 */
    @Excel(name = "迟到超过")
    private Integer lateForOver;

    /** 早退超过 */
    @Excel(name = "早退超过")
    private Integer earlyRetirement;

    /** 进场后 */
    @Excel(name = "进场后")
    private Integer afterEnteringArena;

    /** 出场后 */
    @Excel(name = "出场后")
    private Integer afterAppearance;

    public void setRuleId(Long ruleId) 
    {
        this.ruleId = ruleId;
    }

    public Long getRuleId() 
    {
        return ruleId;
    }
    public void setOvertimeWork(Integer overtimeWork) 
    {
        this.overtimeWork = overtimeWork;
    }

    public Integer getOvertimeWork() 
    {
        return overtimeWork;
    }
    public void setAdvanceFromWork(Integer advanceFromWork) 
    {
        this.advanceFromWork = advanceFromWork;
    }

    public Integer getAdvanceFromWork() 
    {
        return advanceFromWork;
    }
    public void setLateForOver(Integer lateForOver) 
    {
        this.lateForOver = lateForOver;
    }

    public Integer getLateForOver() 
    {
        return lateForOver;
    }
    public void setEarlyRetirement(Integer earlyRetirement) 
    {
        this.earlyRetirement = earlyRetirement;
    }

    public Integer getEarlyRetirement() 
    {
        return earlyRetirement;
    }
    public void setAfterEnteringArena(Integer afterEnteringArena) 
    {
        this.afterEnteringArena = afterEnteringArena;
    }

    public Integer getAfterEnteringArena() 
    {
        return afterEnteringArena;
    }
    public void setAfterAppearance(Integer afterAppearance) 
    {
        this.afterAppearance = afterAppearance;
    }

    public Integer getAfterAppearance() 
    {
        return afterAppearance;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ruleId", getRuleId())
            .append("overtimeWork", getOvertimeWork())
            .append("advanceFromWork", getAdvanceFromWork())
            .append("lateForOver", getLateForOver())
            .append("earlyRetirement", getEarlyRetirement())
            .append("afterEnteringArena", getAfterEnteringArena())
            .append("afterAppearance", getAfterAppearance())
            .toString();
    }
}
