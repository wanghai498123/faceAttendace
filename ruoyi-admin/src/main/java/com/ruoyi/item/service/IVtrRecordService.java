package com.ruoyi.item.service;

import com.ruoyi.item.domain.VtrRecord;
import java.util.List;

/**
 * 来访记录Service接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface IVtrRecordService 
{
    /**
     * 查询来访记录
     * 
     * @param recordId 来访记录ID
     * @return 来访记录
     */
    public VtrRecord selectVtrRecordById(Long recordId);

    /**
     * 查询来访记录列表
     * 
     * @param vtrRecord 来访记录
     * @return 来访记录集合
     */
    public List<VtrRecord> selectVtrRecordList(VtrRecord vtrRecord);

    /**
     * 新增来访记录
     * 
     * @param vtrRecord 来访记录
     * @return 结果
     */
    public int insertVtrRecord(VtrRecord vtrRecord);

    /**
     * 修改来访记录
     * 
     * @param vtrRecord 来访记录
     * @return 结果
     */
    public int updateVtrRecord(VtrRecord vtrRecord);

    /**
     * 批量删除来访记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVtrRecordByIds(String ids);

    /**
     * 删除来访记录信息
     * 
     * @param recordId 来访记录ID
     * @return 结果
     */
    public int deleteVtrRecordById(Long recordId);

    /**~*/ /**~actionBegin*/
}
