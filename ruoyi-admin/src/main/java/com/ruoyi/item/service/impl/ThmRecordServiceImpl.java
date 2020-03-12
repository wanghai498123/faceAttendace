package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.ThmRecordMapper;
import com.ruoyi.item.domain.ThmRecord;
import com.ruoyi.item.service.IThmRecordService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 体温检测记录Service业务层处理
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Service
public class ThmRecordServiceImpl implements IThmRecordService 
{
    @Autowired
    private ThmRecordMapper thmRecordMapper;

    /**
     * 查询体温检测记录
     * 
     * @param recordId 体温检测记录ID
     * @return 体温检测记录
     */
    @Override
    public ThmRecord selectThmRecordById(Long recordId)
    {
        return thmRecordMapper.selectThmRecordById(recordId);
    }

    /**
     * 查询体温检测记录列表
     * 
     * @param thmRecord 体温检测记录
     * @return 体温检测记录
     */
    @Override
    public List<ThmRecord> selectThmRecordList(ThmRecord thmRecord)
    {
        return thmRecordMapper.selectThmRecordList(thmRecord);
    }

    /**
     * 新增体温检测记录
     * 
     * @param thmRecord 体温检测记录
     * @return 结果
     */
    @Override
    public int insertThmRecord(ThmRecord thmRecord)
    {
        return thmRecordMapper.insertThmRecord(thmRecord);
    }

    /**
     * 修改体温检测记录
     * 
     * @param thmRecord 体温检测记录
     * @return 结果
     */
    @Override
    public int updateThmRecord(ThmRecord thmRecord)
    {
        return thmRecordMapper.updateThmRecord(thmRecord);
    }

    /**
     * 删除体温检测记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThmRecordByIds(String ids)
    {
        return thmRecordMapper.deleteThmRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除体温检测记录信息
     * 
     * @param recordId 体温检测记录ID
     * @return 结果
     */
    @Override
    public int deleteThmRecordById(Long recordId)
    {
        return thmRecordMapper.deleteThmRecordById(recordId);
    }


         /**~*/ /**~actionBegin*/
}
