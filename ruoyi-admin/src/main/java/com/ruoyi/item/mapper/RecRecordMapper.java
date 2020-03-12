package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.RecRecord;
import java.util.List;

/**
 * 考勤记录Mapper接口
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public interface RecRecordMapper 
{
    /**
     * 查询考勤记录
     * 
     * @param recordId 考勤记录ID
     * @return 考勤记录
     */
    public RecRecord selectRecRecordById(Long recordId);

    /**
     * 查询考勤记录列表
     * 
     * @param recRecord 考勤记录
     * @return 考勤记录集合
     */
    public List<RecRecord> selectRecRecordList(RecRecord recRecord);

    /**
     * 新增考勤记录
     * 
     * @param recRecord 考勤记录
     * @return 结果
     */
    public int insertRecRecord(RecRecord recRecord);

    /**
     * 修改考勤记录
     * 
     * @param recRecord 考勤记录
     * @return 结果
     */
    public int updateRecRecord(RecRecord recRecord);

    /**
     * 删除考勤记录
     * 
     * @param recordId 考勤记录ID
     * @return 结果
     */
    public int deleteRecRecordById(Long recordId);

    /**
     * 批量删除考勤记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecRecordByIds(String[] recordIds);

    /**~*/ /**~actionBegin*/
}
