package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.DevOperLogMapper;
import com.ruoyi.item.domain.DevOperLog;
import com.ruoyi.item.service.IDevOperLogService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 设备操作日志Service业务层处理
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Service
public class DevOperLogServiceImpl implements IDevOperLogService 
{
    @Autowired
    private DevOperLogMapper devOperLogMapper;

    /**
     * 查询设备操作日志
     * 
     * @param operId 设备操作日志ID
     * @return 设备操作日志
     */
    @Override
    public DevOperLog selectDevOperLogById(Long operId)
    {
        return devOperLogMapper.selectDevOperLogById(operId);
    }

    /**
     * 查询设备操作日志列表
     * 
     * @param devOperLog 设备操作日志
     * @return 设备操作日志
     */
    @Override
    public List<DevOperLog> selectDevOperLogList(DevOperLog devOperLog)
    {
        return devOperLogMapper.selectDevOperLogList(devOperLog);
    }

    /**
     * 新增设备操作日志
     * 
     * @param devOperLog 设备操作日志
     * @return 结果
     */
    @Override
    public int insertDevOperLog(DevOperLog devOperLog)
    {
        return devOperLogMapper.insertDevOperLog(devOperLog);
    }

    /**
     * 修改设备操作日志
     * 
     * @param devOperLog 设备操作日志
     * @return 结果
     */
    @Override
    public int updateDevOperLog(DevOperLog devOperLog)
    {
        return devOperLogMapper.updateDevOperLog(devOperLog);
    }

    /**
     * 删除设备操作日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDevOperLogByIds(String ids)
    {
        return devOperLogMapper.deleteDevOperLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备操作日志信息
     * 
     * @param operId 设备操作日志ID
     * @return 结果
     */
    @Override
    public int deleteDevOperLogById(Long operId)
    {
        return devOperLogMapper.deleteDevOperLogById(operId);
    }


         /**~*/ /**~actionBegin*/
}
