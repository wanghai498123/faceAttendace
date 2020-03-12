package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 自定义假日设置对象 rec_customize_holiday_info
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public class RecCustomizeHolidayInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long customizeHolidayInfoId;

    /** 机构 */
    @Excel(name = "机构")
    private Long deptId;

    /** 自定义假期 */
    @Excel(name = "自定义假期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date holiday;

    /** 假期名称 */
    @Excel(name = "假期名称")
    private String holidayName;

    /** 假期描叙 */
    @Excel(name = "假期描叙")
    private String holidayScript;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /** 设备名称 */
    @Excel(name = "机构名称")
    private String deptName;

    public void setCustomizeHolidayInfoId(Long customizeHolidayInfoId) 
    {
        this.customizeHolidayInfoId = customizeHolidayInfoId;
    }

    public Long getCustomizeHolidayInfoId() 
    {
        return customizeHolidayInfoId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setHoliday(Date holiday) 
    {
        this.holiday = holiday;
    }

    public Date getHoliday() 
    {
        return holiday;
    }
    public void setHolidayName(String holidayName) 
    {
        this.holidayName = holidayName;
    }

    public String getHolidayName() 
    {
        return holidayName;
    }
    public void setHolidayScript(String holidayScript) 
    {
        this.holidayScript = holidayScript;
    }

    public String getHolidayScript() 
    {
        return holidayScript;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customizeHolidayInfoId", getCustomizeHolidayInfoId())
            .append("deptId", getDeptId())
            .append("holiday", getHoliday())
            .append("holidayName", getHolidayName())
            .append("holidayScript", getHolidayScript())
            .toString();
    }
}
