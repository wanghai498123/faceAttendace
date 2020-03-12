package com.ruoyi.item.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.item.domain.RecDaterecord;
import com.ruoyi.item.mapper.RecDaterecordMapper;
import com.ruoyi.item.service.IRecDaterecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考勤日报Service业务层处理
 * 
 * @author wanghai
 * @date 2019-11-12
 */
@Service
public class RecDaterecordServiceImpl implements IRecDaterecordService
{
    @Autowired
    private RecDaterecordMapper recDaterecordMapper;

    /**
     * 查询考勤日报
     * 
     * @param recordId 考勤日报ID
     * @return 考勤日报
     */
    @Override
    public RecDaterecord selectRecDaterecordById(Long recordId)
    {
        return recDaterecordMapper.selectRecDaterecordById(recordId);
    }

    /**
     * 查询考勤日报列表
     * 
     * @param recDaterecord 考勤日报
     * @return 考勤日报
     */
    @Override
    public List<RecDaterecord> selectRecDaterecordList(RecDaterecord recDaterecord)
    {
        return recDaterecordMapper.selectRecDaterecordList(recDaterecord);
    }

    /**
     * 新增考勤日报
     * 
     * @param recDaterecord 考勤日报
     * @return 结果
     */
    @Override
    public int insertRecDaterecord(RecDaterecord recDaterecord)
    {
        return recDaterecordMapper.insertRecDaterecord(recDaterecord);
    }

    /**
     * 修改考勤日报
     * 
     * @param recDaterecord 考勤日报
     * @return 结果
     */
    @Override
    public int updateRecDaterecord(RecDaterecord recDaterecord)
    {
        return recDaterecordMapper.updateRecDaterecord(recDaterecord);
    }

    /**
     * 删除考勤日报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecDaterecordByIds(String ids)
    {
        return recDaterecordMapper.deleteRecDaterecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤日报信息
     * 
     * @param recordId 考勤日报ID
     * @return 结果
     */
    @Override
    public int deleteRecDaterecordById(Long recordId)
    {
        return recDaterecordMapper.deleteRecDaterecordById(recordId);
    }
    /**~*/ /**~actionBegin*/
}
