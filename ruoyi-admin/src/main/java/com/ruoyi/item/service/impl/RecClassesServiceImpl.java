package com.ruoyi.item.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.item.domain.RecClasses;
import com.ruoyi.item.mapper.RecClassesMapper;
import com.ruoyi.item.service.IRecClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考勤班次Service业务层处理
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Service
public class RecClassesServiceImpl implements IRecClassesService
{
    @Autowired
    private RecClassesMapper recClassesMapper;

    /**
     * 查询考勤班次
     * 
     * @param classesId 考勤班次ID
     * @return 考勤班次
     */
    @Override
    public RecClasses selectRecClassesById(Long classesId)
    {
        return recClassesMapper.selectRecClassesById(classesId);
    }

    /**
     * 查询考勤班次列表
     * 
     * @param recClasses 考勤班次
     * @return 考勤班次
     */
    @Override
    public List<RecClasses> selectRecClassesList(RecClasses recClasses)
    {
        return recClassesMapper.selectRecClassesList(recClasses);
    }

    /**
     * 新增考勤班次
     * 
     * @param recClasses 考勤班次
     * @return 结果
     */
    @Override
    public int insertRecClasses(RecClasses recClasses)
    {
        return recClassesMapper.insertRecClasses(recClasses);
    }

    /**
     * 修改考勤班次
     * 
     * @param recClasses 考勤班次
     * @return 结果
     */
    @Override
    public int updateRecClasses(RecClasses recClasses)
    {
        return recClassesMapper.updateRecClasses(recClasses);
    }

    /**
     * 删除考勤班次对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecClassesByIds(String ids)
    {
        return recClassesMapper.deleteRecClassesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤班次信息
     * 
     * @param classesId 考勤班次ID
     * @return 结果
     */
    @Override
    public int deleteRecClassesById(Long classesId)
    {
        return recClassesMapper.deleteRecClassesById(classesId);
    }

    @Override
    public List<RecClasses> sselectRecClassesAll() {
        return recClassesMapper.sselectRecClassesAll();
    }
    /**~*/ /**~actionBegin*/
}
