package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.DevPersonnelAssignmentMapper;
import com.ruoyi.item.domain.DevPersonnelAssignment;
import com.ruoyi.item.service.IDevPersonnelAssignmentService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 人员设备分配Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-05
 */
@Service
public class DevPersonnelAssignmentServiceImpl implements IDevPersonnelAssignmentService 
{
    @Autowired
    private DevPersonnelAssignmentMapper devPersonnelAssignmentMapper;

    /**
     * 查询人员设备分配
     * 
     * @param deviceId 人员设备分配ID
     * @return 人员设备分配
     */
    @Override
    public DevPersonnelAssignment selectDevPersonnelAssignmentById(Long deviceId)
    {
        return devPersonnelAssignmentMapper.selectDevPersonnelAssignmentById(deviceId);
    }

    /**
     * 查询人员设备分配列表
     * 
     * @param devPersonnelAssignment 人员设备分配
     * @return 人员设备分配
     */
    @Override
    public List<DevPersonnelAssignment> selectDevPersonnelAssignmentList(DevPersonnelAssignment devPersonnelAssignment)
    {
        return devPersonnelAssignmentMapper.selectDevPersonnelAssignmentList(devPersonnelAssignment);
    }

    /**
     * 新增人员设备分配
     * 
     * @param devPersonnelAssignment 人员设备分配
     * @return 结果
     */
    @Override
    public int insertDevPersonnelAssignment(DevPersonnelAssignment devPersonnelAssignment)
    {
        return devPersonnelAssignmentMapper.insertDevPersonnelAssignment(devPersonnelAssignment);
    }

    /**
     * 修改人员设备分配
     * 
     * @param devPersonnelAssignment 人员设备分配
     * @return 结果
     */
    @Override
    public int updateDevPersonnelAssignment(DevPersonnelAssignment devPersonnelAssignment)
    {
        return devPersonnelAssignmentMapper.updateDevPersonnelAssignment(devPersonnelAssignment);
    }

    /**
     * 删除人员设备分配对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDevPersonnelAssignmentByIds(String ids)
    {
        return devPersonnelAssignmentMapper.deleteDevPersonnelAssignmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员设备分配信息
     * 
     * @param deviceId 人员设备分配ID
     * @return 结果
     */
    @Override
    public int deleteDevPersonnelAssignmentById(Long deviceId)
    {
        return devPersonnelAssignmentMapper.deleteDevPersonnelAssignmentById(deviceId);
    }


         /**~*/ /**~actionBegin*/
}
