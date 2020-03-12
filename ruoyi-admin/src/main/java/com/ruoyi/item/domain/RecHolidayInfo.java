package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 假日设置对象 rec_holiday_info
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public class RecHolidayInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long holidayInfoId;

    /** 假期 */
    @Excel(name = "假期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date holiday;

    /** 假期名称 */
    @Excel(name = "假期名称")
    private String holidayName;

    /** 假期描叙 */
    @Excel(name = "假期描叙")
    private String holidayScript;

    public void setHolidayInfoId(Long holidayInfoId) 
    {
        this.holidayInfoId = holidayInfoId;
    }

    public Long getHolidayInfoId() 
    {
        return holidayInfoId;
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
            .append("holidayInfoId", getHolidayInfoId())
            .append("holiday", getHoliday())
            .append("holidayName", getHolidayName())
            .append("holidayScript", getHolidayScript())
            .toString();
    }
}
