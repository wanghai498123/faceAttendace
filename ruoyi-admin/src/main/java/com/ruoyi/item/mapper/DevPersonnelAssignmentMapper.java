package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.DevPersonnelAssignment;
import java.util.List;

/**
 * 人员设备分配Mapper接口
 * 
 * @author wanghai
 * @date 2020-03-05
 */
public interface DevPersonnelAssignmentMapper 
{
    /**
     * 查询人员设备分配
     * 
     * @param deviceId 人员设备分配ID
     * @return 人员设备分配
     */
    public DevPersonnelAssignment selectDevPersonnelAssignmentById(Long deviceId);

    /**
     * 查询人员设备分配列表
     * 
     * @param devPersonnelAssignment 人员设备分配
     * @return 人员设备分配集合
     */
    public List<DevPersonnelAssignment> selectDevPersonnelAssignmentList(DevPersonnelAssignment devPersonnelAssignment);

    /**
     * 新增人员设备分配
     * 
     * @param devPersonnelAssignment 人员设备分配
     * @return 结果
     */
    public int insertDevPersonnelAssignment(DevPersonnelAssignment devPersonnelAssignment);

    /**
     * 修改人员设备分配
     * 
     * @param devPersonnelAssignment 人员设备分配
     * @return 结果
     */
    public int updateDevPersonnelAssignment(DevPersonnelAssignment devPersonnelAssignment);

    /**
     * 删除人员设备分配
     * 
     * @param deviceId 人员设备分配ID
     * @return 结果
     */
    public int deleteDevPersonnelAssignmentById(Long deviceId);

    /**
     * 批量删除人员设备分配
     * 
     * @param deviceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDevPersonnelAssignmentByIds(String[] deviceIds);

    /**~*/ /**~actionBegin*/
}
