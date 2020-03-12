package com.ruoyi.item.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.item.domain.DevDeviceinfo;
import com.ruoyi.item.mapper.DevDeviceinfoMapper;
import com.ruoyi.item.service.IDevDeviceinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备信息Service业务层处理
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Service
public class DevDeviceinfoServiceImpl implements IDevDeviceinfoService
{
    @Autowired
    private DevDeviceinfoMapper devDeviceinfoMapper;

    /**
     * 查询设备信息
     * 
     * @param deviceId 设备信息ID
     * @return 设备信息
     */
    @Override
    public DevDeviceinfo selectDevDeviceinfoById(Long deviceId)
    {
        return devDeviceinfoMapper.selectDevDeviceinfoById(deviceId);
    }

    /**
     * 查询设备信息列表
     * 
     * @param devDeviceinfo 设备信息
     * @return 设备信息
     */
    @Override
    public List<DevDeviceinfo> selectDevDeviceinfoList(DevDeviceinfo devDeviceinfo)
    {
        return devDeviceinfoMapper.selectDevDeviceinfoList(devDeviceinfo);
    }


    /**
     * 新增设备信息
     * 
     * @param devDeviceinfo 设备信息
     * @return 结果
     */
    @Override
    public int insertDevDeviceinfo(DevDeviceinfo devDeviceinfo)
    {
        return devDeviceinfoMapper.insertDevDeviceinfo(devDeviceinfo);
    }

    /**
     * 修改设备信息
     * 
     * @param devDeviceinfo 设备信息
     * @return 结果
     */
    @Override
    public int updateDevDeviceinfo(DevDeviceinfo devDeviceinfo)
    {
        return devDeviceinfoMapper.updateDevDeviceinfo(devDeviceinfo);
    }

    /**
     * 删除设备信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDevDeviceinfoByIds(String ids)
    {
        return devDeviceinfoMapper.deleteDevDeviceinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备信息信息
     * 
     * @param deviceId 设备信息ID
     * @return 结果
     */
    @Override
    public int deleteDevDeviceinfoById(Long deviceId)
    {
        return devDeviceinfoMapper.deleteDevDeviceinfoById(deviceId);
    }
    /**~*/ /**~actionBegin*/
}
