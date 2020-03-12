package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 体温检测规则对象 thm_rule
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public class ThmRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long ruleId;

    /** 机构 */
    @Excel(name = "机构")
    private Long deptId;

    /** 警告温度 */
    @Excel(name = "警告温度")
    private Double temperature;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /** 设备名称 */
    @Excel(name = "机构名称")
    private String deptName;

    public void setRuleId(Long ruleId) 
    {
        this.ruleId = ruleId;
    }

    public Long getRuleId() 
    {
        return ruleId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setTemperature(Double temperature) 
    {
        this.temperature = temperature;
    }

    public Double getTemperature() 
    {
        return temperature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ruleId", getRuleId())
            .append("deptId", getDeptId())
            .append("temperature", getTemperature())
            .toString();
    }
}
