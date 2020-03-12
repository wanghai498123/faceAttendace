package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员设备分配对象 dev_personnel_assignment
 * 
 * @author wanghai
 * @date 2020-03-05
 */
public class DevPersonnelAssignment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备名 */
    @Excel(name = "设备名")
    private Long deviceId;

    /** 员工 */
    @Excel(name = "员工")
    private Long personnelId;

    /** 是否同步数据 */
    @Excel(name = "是否同步数据")
    private String syndate;

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setPersonnelId(Long personnelId) 
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId() 
    {
        return personnelId;
    }
    public void setSyndate(String syndate) 
    {
        this.syndate = syndate;
    }

    public String getSyndate() 
    {
        return syndate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getDeviceId())
            .append("personnelId", getPersonnelId())
            .append("syndate", getSyndate())
            .toString();
    }
}
