package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.PerPersonnelinfo;

import java.util.List;

/**
 * 人员信息Mapper接口
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public interface PerPersonnelinfoMapper 
{
    /**
     * 查询人员信息
     * 
     * @param personnelId 人员信息ID
     * @return 人员信息
     */
    public PerPersonnelinfo selectPerPersonnelinfoById(Long personnelId);

    /**
     * 查询人员信息列表
     * 
     * @param perPersonnelinfo 人员信息
     * @return 人员信息集合
     */
    public List<PerPersonnelinfo> selectPerPersonnelinfoList(PerPersonnelinfo perPersonnelinfo);

    /**
     * 新增人员信息
     * 
     * @param perPersonnelinfo 人员信息
     * @return 结果
     */
    public int insertPerPersonnelinfo(PerPersonnelinfo perPersonnelinfo);

    /**
     * 修改人员信息
     * 
     * @param perPersonnelinfo 人员信息
     * @return 结果
     */
    public int updatePerPersonnelinfo(PerPersonnelinfo perPersonnelinfo);

    /**
     * 删除人员信息
     * 
     * @param personnelId 人员信息ID
     * @return 结果
     */
    public int deletePerPersonnelinfoById(Long personnelId);

    /**
     * 批量删除人员信息
     * 
     * @param personnelIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePerPersonnelinfoByIds(String[] personnelIds);
    /**~*/ /**~actionBegin*/
}
