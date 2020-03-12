package com.ruoyi.item.service;

import com.ruoyi.item.domain.DevDeviceinfo;

import java.util.List;

/**
 * 设备信息Service接口
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public interface IDevDeviceinfoService 
{
    /**
     * 查询设备信息
     * 
     * @param deviceId 设备信息ID
     * @return 设备信息
     */
    public DevDeviceinfo selectDevDeviceinfoById(Long deviceId);

    /**
     * 查询设备信息列表
     * 
     * @param devDeviceinfo 设备信息
     * @return 设备信息集合
     */
    public List<DevDeviceinfo> selectDevDeviceinfoList(DevDeviceinfo devDeviceinfo);


    /**
     * 新增设备信息
     * 
     * @param devDeviceinfo 设备信息
     * @return 结果
     */
    public int insertDevDeviceinfo(DevDeviceinfo devDeviceinfo);

    /**
     * 修改设备信息
     * 
     * @param devDeviceinfo 设备信息
     * @return 结果
     */
    public int updateDevDeviceinfo(DevDeviceinfo devDeviceinfo);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDevDeviceinfoByIds(String ids);

    /**
     * 删除设备信息信息
     * 
     * @param deviceId 设备信息ID
     * @return 结果
     */
    public int deleteDevDeviceinfoById(Long deviceId);
    /**~*/ /**~actionBegin*/
}
