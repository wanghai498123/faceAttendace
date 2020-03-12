package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.RecRecordMapper;
import com.ruoyi.item.domain.RecRecord;
import com.ruoyi.item.service.IRecRecordService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 考勤记录Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Service
public class RecRecordServiceImpl implements IRecRecordService 
{
    @Autowired
    private RecRecordMapper recRecordMapper;

    /**
     * 查询考勤记录
     * 
     * @param recordId 考勤记录ID
     * @return 考勤记录
     */
    @Override
    public RecRecord selectRecRecordById(Long recordId)
    {
        return recRecordMapper.selectRecRecordById(recordId);
    }

    /**
     * 查询考勤记录列表
     * 
     * @param recRecord 考勤记录
     * @return 考勤记录
     */
    @Override
    public List<RecRecord> selectRecRecordList(RecRecord recRecord)
    {
        return recRecordMapper.selectRecRecordList(recRecord);
    }

    /**
     * 新增考勤记录
     * 
     * @param recRecord 考勤记录
     * @return 结果
     */
    @Override
    public int insertRecRecord(RecRecord recRecord)
    {
        return recRecordMapper.insertRecRecord(recRecord);
    }

    /**
     * 修改考勤记录
     * 
     * @param recRecord 考勤记录
     * @return 结果
     */
    @Override
    public int updateRecRecord(RecRecord recRecord)
    {
        return recRecordMapper.updateRecRecord(recRecord);
    }

    /**
     * 删除考勤记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecRecordByIds(String ids)
    {
        return recRecordMapper.deleteRecRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤记录信息
     * 
     * @param recordId 考勤记录ID
     * @return 结果
     */
    @Override
    public int deleteRecRecordById(Long recordId)
    {
        return recRecordMapper.deleteRecRecordById(recordId);
    }


         /**~*/ /**~actionBegin*/
}
