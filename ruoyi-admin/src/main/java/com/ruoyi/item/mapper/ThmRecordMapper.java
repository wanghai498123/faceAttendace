package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.ThmRecord;
import java.util.List;

/**
 * 体温检测记录Mapper接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface ThmRecordMapper 
{
    /**
     * 查询体温检测记录
     * 
     * @param recordId 体温检测记录ID
     * @return 体温检测记录
     */
    public ThmRecord selectThmRecordById(Long recordId);

    /**
     * 查询体温检测记录列表
     * 
     * @param thmRecord 体温检测记录
     * @return 体温检测记录集合
     */
    public List<ThmRecord> selectThmRecordList(ThmRecord thmRecord);

    /**
     * 新增体温检测记录
     * 
     * @param thmRecord 体温检测记录
     * @return 结果
     */
    public int insertThmRecord(ThmRecord thmRecord);

    /**
     * 修改体温检测记录
     * 
     * @param thmRecord 体温检测记录
     * @return 结果
     */
    public int updateThmRecord(ThmRecord thmRecord);

    /**
     * 删除体温检测记录
     * 
     * @param recordId 体温检测记录ID
     * @return 结果
     */
    public int deleteThmRecordById(Long recordId);

    /**
     * 批量删除体温检测记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteThmRecordByIds(String[] recordIds);

    /**~*/ /**~actionBegin*/
}
