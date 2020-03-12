package com.ruoyi.item.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.item.domain.PerPersonnelinfo;
import com.ruoyi.item.mapper.PerPersonnelinfoMapper;
import com.ruoyi.item.service.IPerPersonnelinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员信息Service业务层处理
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Service
public class PerPersonnelinfoServiceImpl implements IPerPersonnelinfoService 
{
    @Autowired
    private PerPersonnelinfoMapper perPersonnelinfoMapper;

    /**
     * 查询人员信息
     * 
     * @param personnelId 人员信息ID
     * @return 人员信息
     */
    @Override
    public PerPersonnelinfo selectPerPersonnelinfoById(Long personnelId)
    {
        return perPersonnelinfoMapper.selectPerPersonnelinfoById(personnelId);
    }

    /**
     * 查询人员信息列表
     * 
     * @param perPersonnelinfo 人员信息
     * @return 人员信息
     */
    @Override
    public List<PerPersonnelinfo> selectPerPersonnelinfoList(PerPersonnelinfo perPersonnelinfo)
    {
        return perPersonnelinfoMapper.selectPerPersonnelinfoList(perPersonnelinfo);
    }

    /**
     * 新增人员信息
     * 
     * @param perPersonnelinfo 人员信息
     * @return 结果
     */
    @Override
    public int insertPerPersonnelinfo(PerPersonnelinfo perPersonnelinfo)
    {
        return perPersonnelinfoMapper.insertPerPersonnelinfo(perPersonnelinfo);
    }

    /**
     * 修改人员信息
     * 
     * @param perPersonnelinfo 人员信息
     * @return 结果
     */
    @Override
    public int updatePerPersonnelinfo(PerPersonnelinfo perPersonnelinfo)
    {
        return perPersonnelinfoMapper.updatePerPersonnelinfo(perPersonnelinfo);
    }

    /**
     * 删除人员信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerPersonnelinfoByIds(String ids)
    {
        return perPersonnelinfoMapper.deletePerPersonnelinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员信息信息
     * 
     * @param personnelId 人员信息ID
     * @return 结果
     */
    @Override
    public int deletePerPersonnelinfoById(Long personnelId)
    {
        return perPersonnelinfoMapper.deletePerPersonnelinfoById(personnelId);
    }
    /**~*/ /**~actionBegin*/
}
