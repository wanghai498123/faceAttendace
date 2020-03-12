package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备分配对象 dev_dept_assignment
 * 
 * @author wanghai
 * @date 2020-03-05
 */
public class DevDeptAssignment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备名 */
    @Excel(name = "设备名")
    private Long deviceId;

    /** 机构名 */
    @Excel(name = "机构名")
    private Long deptId;

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
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
            .append("deviceId", getDeviceId())
            .append("deptId", getDeptId())
            .toString();
    }
}
