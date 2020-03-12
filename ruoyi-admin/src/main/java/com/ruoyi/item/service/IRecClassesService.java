package com.ruoyi.item.service;

import com.ruoyi.item.domain.RecClasses;

import java.util.List;

/**
 * 考勤班次Service接口
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public interface IRecClassesService 
{
    /**
     * 查询考勤班次
     * 
     * @param classesId 考勤班次ID
     * @return 考勤班次
     */
    public RecClasses selectRecClassesById(Long classesId);

    /**
     * 查询考勤班次列表
     * 
     * @param recClasses 考勤班次
     * @return 考勤班次集合
     */
    public List<RecClasses> selectRecClassesList(RecClasses recClasses);

    /**
     * 新增考勤班次
     * 
     * @param recClasses 考勤班次
     * @return 结果
     */
    public int insertRecClasses(RecClasses recClasses);

    /**
     * 修改考勤班次
     * 
     * @param recClasses 考勤班次
     * @return 结果
     */
    public int updateRecClasses(RecClasses recClasses);

    /**
     * 批量删除考勤班次
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecClassesByIds(String ids);

    /**
     * 删除考勤班次信息
     * 
     * @param classesId 考勤班次ID
     * @return 结果
     */
    public int deleteRecClassesById(Long classesId);

    /**
     * 查询所有考勤班次
     *
     * @return 考勤班次列表
     */
    List<RecClasses> sselectRecClassesAll();
    /**~*/ /**~actionBegin*/
}
