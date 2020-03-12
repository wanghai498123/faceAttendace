package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.DevDeptAssignment;
import java.util.List;

/**
 * 设备分配Mapper接口
 * 
 * @author wanghai
 * @date 2020-03-05
 */
public interface DevDeptAssignmentMapper 
{
    /**
     * 查询设备分配
     * 
     * @param deviceId 设备分配ID
     * @return 设备分配
     */
    public DevDeptAssignment selectDevDeptAssignmentById(Long deviceId);

    /**
     * 查询设备分配列表
     * 
     * @param devDeptAssignment 设备分配
     * @return 设备分配集合
     */
    public List<DevDeptAssignment> selectDevDeptAssignmentList(DevDeptAssignment devDeptAssignment);

    /**
     * 新增设备分配
     * 
     * @param devDeptAssignment 设备分配
     * @return 结果
     */
    public int insertDevDeptAssignment(DevDeptAssignment devDeptAssignment);

    /**
     * 修改设备分配
     * 
     * @param devDeptAssignment 设备分配
     * @return 结果
     */
    public int updateDevDeptAssignment(DevDeptAssignment devDeptAssignment);

    /**
     * 删除设备分配
     * 
     * @param deviceId 设备分配ID
     * @return 结果
     */
    public int deleteDevDeptAssignmentById(Long deviceId);

    /**
     * 批量删除设备分配
     * 
     * @param deviceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDevDeptAssignmentByIds(String[] deviceIds);

    /**~*/ /**~actionBegin*/
}
