package com.ruoyi.item.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备信息对象 dev_deviceinfo
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public class DevDeviceinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long deviceId;

    /** 机构名称 */
    @Excel(name = "机构名称")
    private Long deptId;

    /** 分组名 */
    @Excel(name = "分组名")
    private Long teamId;

    /** 机构名称 */
    @Excel(name = "机构名称")
    private String deptName;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceCategory;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String  manufacturer;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ipAddress;

    /** 端口号 */
    @Excel(name = "端口号")
    private Long port;

    /** 通道类别 */
    @Excel(name = "通道类别")
    private String channelType;

    /** 开闸模式 */
    @Excel(name = "开闸模式")
    private String openingMode;

    /** 在线状态 */
    @Excel(name = "在线状态")
    private String onlineState;

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
    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }
    public void setDeviceCategory(String deviceCategory) 
    {
        this.deviceCategory = deviceCategory;
    }

    public String getDeviceCategory() 
    {
        return deviceCategory;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setIpAddress(String ipAddress) 
    {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() 
    {
        return ipAddress;
    }
    public void setPort(Long port) 
    {
        this.port = port;
    }

    public Long getPort() 
    {
        return port;
    }
    public void setChannelType(String channelType) 
    {
        this.channelType = channelType;
    }

    public String getChannelType() 
    {
        return channelType;
    }
    public void setOpeningMode(String openingMode) 
    {
        this.openingMode = openingMode;
    }

    public String getOpeningMode() 
    {
        return openingMode;
    }
    public void setOnlineState(String onlineState) 
    {
        this.onlineState = onlineState;
    }

    public String getOnlineState() 
    {
        return onlineState;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getDeviceId())
            .append("deptId", getDeptId())
            .append("teamId", getTeamId())
            .append("deviceCategory", getDeviceCategory())
            .append("deviceName", getDeviceName())
            .append("ipAddress", getIpAddress())
            .append("port", getPort())
            .append("channelType", getChannelType())
            .append("openingMode", getOpeningMode())
            .append("onlineState", getOnlineState())
            .toString();
    }
}
