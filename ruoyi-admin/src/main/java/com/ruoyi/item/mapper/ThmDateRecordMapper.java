package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.ThmDateRecord;
import java.util.List;

/**
 * 体温检测记录日Mapper接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface ThmDateRecordMapper 
{
    /**
     * 查询体温检测记录日
     * 
     * @param recordId 体温检测记录日ID
     * @return 体温检测记录日
     */
    public ThmDateRecord selectThmDateRecordById(Long recordId);

    /**
     * 查询体温检测记录日列表
     * 
     * @param thmDateRecord 体温检测记录日
     * @return 体温检测记录日集合
     */
    public List<ThmDateRecord> selectThmDateRecordList(ThmDateRecord thmDateRecord);

    /**
     * 新增体温检测记录日
     * 
     * @param thmDateRecord 体温检测记录日
     * @return 结果
     */
    public int insertThmDateRecord(ThmDateRecord thmDateRecord);

    /**
     * 修改体温检测记录日
     * 
     * @param thmDateRecord 体温检测记录日
     * @return 结果
     */
    public int updateThmDateRecord(ThmDateRecord thmDateRecord);

    /**
     * 删除体温检测记录日
     * 
     * @param recordId 体温检测记录日ID
     * @return 结果
     */
    public int deleteThmDateRecordById(Long recordId);

    /**
     * 批量删除体温检测记录日
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteThmDateRecordByIds(String[] recordIds);

    /**~*/ /**~actionBegin*/
}
