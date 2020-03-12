package com.ruoyi.item.service;

import com.ruoyi.item.domain.DevOperLog;
import java.util.List;

/**
 * 设备操作日志Service接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface IDevOperLogService 
{
    /**
     * 查询设备操作日志
     * 
     * @param operId 设备操作日志ID
     * @return 设备操作日志
     */
    public DevOperLog selectDevOperLogById(Long operId);

    /**
     * 查询设备操作日志列表
     * 
     * @param devOperLog 设备操作日志
     * @return 设备操作日志集合
     */
    public List<DevOperLog> selectDevOperLogList(DevOperLog devOperLog);

    /**
     * 新增设备操作日志
     * 
     * @param devOperLog 设备操作日志
     * @return 结果
     */
    public int insertDevOperLog(DevOperLog devOperLog);

    /**
     * 修改设备操作日志
     * 
     * @param devOperLog 设备操作日志
     * @return 结果
     */
    public int updateDevOperLog(DevOperLog devOperLog);

    /**
     * 批量删除设备操作日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDevOperLogByIds(String ids);

    /**
     * 删除设备操作日志信息
     * 
     * @param operId 设备操作日志ID
     * @return 结果
     */
    public int deleteDevOperLogById(Long operId);

    /**~*/ /**~actionBegin*/
}
