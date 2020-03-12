package com.ruoyi.item.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 考勤班次对象 rec_classes
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public class RecClasses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long classesId;


    /** 建筑公司 */
    @Excel(name = "建筑公司")
    private Long deptId;

    /** 设备名称 */
    @Excel(name = "建筑公司")
    private String deptName;

    /** 班次 */
    @Excel(name = "班次")
    private String classesName;

    /** 开始周期1 */
    @Excel(name = "开始周期1", width = 30, dateFormat = "yyyy-MM-dd")
    private Date start1;

    /** 结束周期1 */
    @Excel(name = "结束周期1", width = 30, dateFormat = "yyyy-MM-dd")
    private Date end1;

    /** 开始周期2 */
    @Excel(name = "开始周期2", width = 30, dateFormat = "yyyy-MM-dd")
    private Date start2;

    /** 结束周期2 */
    @Excel(name = "结束周期2", width = 30, dateFormat = "yyyy-MM-dd")
    private Date end2;

    /** 计为工时 */
    @Excel(name = "计为工时")
    private Double workingHours;

    public void setClassesId(Long classesId) 
    {
        this.classesId = classesId;
    }

    public Long getClassesId() 
    {
        return classesId;
    }
    public void setClassesName(String classesName) 
    {
        this.classesName = classesName;
    }

    public String getClassesName() 
    {
        return classesName;
    }
    public void setStart1(Date start1) 
    {
        this.start1 = start1;
    }

    public Date getStart1() 
    {
        return start1;
    }
    public void setEnd1(Date end1) 
    {
        this.end1 = end1;
    }

    public Date getEnd1() 
    {
        return end1;
    }
    public void setStart2(Date start2) 
    {
        this.start2 = start2;
    }

    public Date getStart2() 
    {
        return start2;
    }
    public void setEnd2(Date end2) 
    {
        this.end2 = end2;
    }

    public Date getEnd2() 
    {
        return end2;
    }
    public void setWorkingHours(Double workingHours) 
    {
        this.workingHours = workingHours;
    }

    public Double getWorkingHours() 
    {
        return workingHours;
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
            .append("classesId", getClassesId())
            .append("classesName", getClassesName())
            .append("start1", getStart1())
            .append("end1", getEnd1())
            .append("start2", getStart2())
            .append("end2", getEnd2())
            .append("workingHours", getWorkingHours())
            .toString();
    }
}
