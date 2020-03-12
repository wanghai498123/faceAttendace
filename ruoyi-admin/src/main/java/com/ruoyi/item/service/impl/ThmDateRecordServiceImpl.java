package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.ThmDateRecordMapper;
import com.ruoyi.item.domain.ThmDateRecord;
import com.ruoyi.item.service.IThmDateRecordService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 体温检测记录日Service业务层处理
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Service
public class ThmDateRecordServiceImpl implements IThmDateRecordService 
{
    @Autowired
    private ThmDateRecordMapper thmDateRecordMapper;

    /**
     * 查询体温检测记录日
     * 
     * @param recordId 体温检测记录日ID
     * @return 体温检测记录日
     */
    @Override
    public ThmDateRecord selectThmDateRecordById(Long recordId)
    {
        return thmDateRecordMapper.selectThmDateRecordById(recordId);
    }

    /**
     * 查询体温检测记录日列表
     * 
     * @param thmDateRecord 体温检测记录日
     * @return 体温检测记录日
     */
    @Override
    public List<ThmDateRecord> selectThmDateRecordList(ThmDateRecord thmDateRecord)
    {
        return thmDateRecordMapper.selectThmDateRecordList(thmDateRecord);
    }

    /**
     * 新增体温检测记录日
     * 
     * @param thmDateRecord 体温检测记录日
     * @return 结果
     */
    @Override
    public int insertThmDateRecord(ThmDateRecord thmDateRecord)
    {
        return thmDateRecordMapper.insertThmDateRecord(thmDateRecord);
    }

    /**
     * 修改体温检测记录日
     * 
     * @param thmDateRecord 体温检测记录日
     * @return 结果
     */
    @Override
    public int updateThmDateRecord(ThmDateRecord thmDateRecord)
    {
        return thmDateRecordMapper.updateThmDateRecord(thmDateRecord);
    }

    /**
     * 删除体温检测记录日对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThmDateRecordByIds(String ids)
    {
        return thmDateRecordMapper.deleteThmDateRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除体温检测记录日信息
     * 
     * @param recordId 体温检测记录日ID
     * @return 结果
     */
    @Override
    public int deleteThmDateRecordById(Long recordId)
    {
        return thmDateRecordMapper.deleteThmDateRecordById(recordId);
    }


         /**~*/ /**~actionBegin*/
}
