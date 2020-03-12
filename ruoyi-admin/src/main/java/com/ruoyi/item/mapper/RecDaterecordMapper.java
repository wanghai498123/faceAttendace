package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.RecDaterecord;

import java.util.List;

/**
 * 考勤日报Mapper接口
 * 
 * @author wanghai
 * @date 2019-11-12
 */
public interface RecDaterecordMapper 
{
    /**
     * 查询考勤日报
     * 
     * @param recordId 考勤日报ID
     * @return 考勤日报
     */
    public RecDaterecord selectRecDaterecordById(Long recordId);

    /**
     * 查询考勤日报列表
     * 
     * @param recDaterecord 考勤日报
     * @return 考勤日报集合
     */
    public List<RecDaterecord> selectRecDaterecordList(RecDaterecord recDaterecord);

    /**
     * 新增考勤日报
     * 
     * @param recDaterecord 考勤日报
     * @return 结果
     */
    public int insertRecDaterecord(RecDaterecord recDaterecord);

    /**
     * 修改考勤日报
     * 
     * @param recDaterecord 考勤日报
     * @return 结果
     */
    public int updateRecDaterecord(RecDaterecord recDaterecord);

    /**
     * 删除考勤日报
     * 
     * @param recordId 考勤日报ID
     * @return 结果
     */
    public int deleteRecDaterecordById(Long recordId);

    /**
     * 批量删除考勤日报
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecDaterecordByIds(String[] recordIds);
    /**~*/ /**~actionBegin*/
}
