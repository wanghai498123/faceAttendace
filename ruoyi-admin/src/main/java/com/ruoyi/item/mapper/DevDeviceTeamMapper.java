package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.DevDeviceTeam;
import java.util.List;

/**
 * 设备分组Mapper接口
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public interface DevDeviceTeamMapper 
{
    /**
     * 查询设备分组
     * 
     * @param deviceTeamId 设备分组ID
     * @return 设备分组
     */
    public DevDeviceTeam selectDevDeviceTeamById(Long deviceTeamId);

    /**
     * 查询设备分组列表
     * 
     * @param devDeviceTeam 设备分组
     * @return 设备分组集合
     */
    public List<DevDeviceTeam> selectDevDeviceTeamList(DevDeviceTeam devDeviceTeam);

    /**
     * 新增设备分组
     * 
     * @param devDeviceTeam 设备分组
     * @return 结果
     */
    public int insertDevDeviceTeam(DevDeviceTeam devDeviceTeam);

    /**
     * 修改设备分组
     * 
     * @param devDeviceTeam 设备分组
     * @return 结果
     */
    public int updateDevDeviceTeam(DevDeviceTeam devDeviceTeam);

    /**
     * 删除设备分组
     * 
     * @param deviceTeamId 设备分组ID
     * @return 结果
     */
    public int deleteDevDeviceTeamById(Long deviceTeamId);

    /**
     * 批量删除设备分组
     * 
     * @param deviceTeamIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDevDeviceTeamByIds(String[] deviceTeamIds);

    /**~*/ /**~actionBegin*/
}
