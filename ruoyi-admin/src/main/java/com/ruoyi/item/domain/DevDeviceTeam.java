package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 设备分组对象 dev_device_team
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public class DevDeviceTeam extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long deviceTeamId;

    /** 分组名称 */
    @Excel(name = "分组名称")
    private String teamName;

    /** 分组描叙 */
    @Excel(name = "分组描叙")
    private String teamScript;

    public void setDeviceTeamId(Long deviceTeamId) 
    {
        this.deviceTeamId = deviceTeamId;
    }

    public Long getDeviceTeamId() 
    {
        return deviceTeamId;
    }
    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    public void setTeamScript(String teamScript) 
    {
        this.teamScript = teamScript;
    }

    public String getTeamScript() 
    {
        return teamScript;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceTeamId", getDeviceTeamId())
            .append("parentId", getParentId())
            .append("orderNum", getOrderNum())
            .append("teamName", getTeamName())
            .append("teamScript", getTeamScript())
            .toString();
    }
}
