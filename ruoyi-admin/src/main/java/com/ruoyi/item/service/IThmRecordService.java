package com.ruoyi.item.service;

import com.ruoyi.item.domain.ThmRecord;
import java.util.List;

/**
 * 体温检测记录Service接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface IThmRecordService 
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
     * 批量删除体温检测记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThmRecordByIds(String ids);

    /**
     * 删除体温检测记录信息
     * 
     * @param recordId 体温检测记录ID
     * @return 结果
     */
    public int deleteThmRecordById(Long recordId);

    /**~*/ /**~actionBegin*/
}
