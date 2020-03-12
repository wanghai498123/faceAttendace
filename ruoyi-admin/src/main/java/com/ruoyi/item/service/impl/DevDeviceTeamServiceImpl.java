package com.ruoyi.item.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.DevDeviceTeamMapper;
import com.ruoyi.item.domain.DevDeviceTeam;
import com.ruoyi.item.service.IDevDeviceTeamService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 设备分组Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Service
public class DevDeviceTeamServiceImpl implements IDevDeviceTeamService 
{
    @Autowired
    private DevDeviceTeamMapper devDeviceTeamMapper;

    /**
     * 查询设备分组
     * 
     * @param deviceTeamId 设备分组ID
     * @return 设备分组
     */
    @Override
    public DevDeviceTeam selectDevDeviceTeamById(Long deviceTeamId)
    {
        return devDeviceTeamMapper.selectDevDeviceTeamById(deviceTeamId);
    }

    /**
     * 查询设备分组列表
     * 
     * @param devDeviceTeam 设备分组
     * @return 设备分组
     */
    @Override
    public List<DevDeviceTeam> selectDevDeviceTeamList(DevDeviceTeam devDeviceTeam)
    {
        return devDeviceTeamMapper.selectDevDeviceTeamList(devDeviceTeam);
    }

    /**
     * 新增设备分组
     * 
     * @param devDeviceTeam 设备分组
     * @return 结果
     */
    @Override
    public int insertDevDeviceTeam(DevDeviceTeam devDeviceTeam)
    {
        return devDeviceTeamMapper.insertDevDeviceTeam(devDeviceTeam);
    }

    /**
     * 修改设备分组
     * 
     * @param devDeviceTeam 设备分组
     * @return 结果
     */
    @Override
    public int updateDevDeviceTeam(DevDeviceTeam devDeviceTeam)
    {
        return devDeviceTeamMapper.updateDevDeviceTeam(devDeviceTeam);
    }

    /**
     * 删除设备分组对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDevDeviceTeamByIds(String ids)
    {
        return devDeviceTeamMapper.deleteDevDeviceTeamByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备分组信息
     * 
     * @param deviceTeamId 设备分组ID
     * @return 结果
     */
    @Override
    public int deleteDevDeviceTeamById(Long deviceTeamId)
    {
        return devDeviceTeamMapper.deleteDevDeviceTeamById(deviceTeamId);
    }

    /**
     * 查询设备分组树列表
     * 
     * @return 所有设备分组信息
     */
    @Override
    public List<Ztree> selectDevDeviceTeamTree()
    {
        List<DevDeviceTeam> devDeviceTeamList = devDeviceTeamMapper.selectDevDeviceTeamList(new DevDeviceTeam());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (DevDeviceTeam devDeviceTeam : devDeviceTeamList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(devDeviceTeam.getDeviceTeamId());
            ztree.setpId(devDeviceTeam.getParentId());
            ztree.setName(devDeviceTeam.getTeamName());
            ztree.setTitle(devDeviceTeam.getTeamName());
            ztrees.add(ztree);
        }
        return ztrees;
    }


         /**~*/ /**~actionBegin*/
}
