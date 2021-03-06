package com.ruoyi.item.service;

import com.ruoyi.item.domain.VtrExceptionalRecord;
import java.util.List;

/**
 * 异常来访Service接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface IVtrExceptionalRecordService 
{
    /**
     * 查询异常来访
     * 
     * @param recordId 异常来访ID
     * @return 异常来访
     */
    public VtrExceptionalRecord selectVtrExceptionalRecordById(Long recordId);

    /**
     * 查询异常来访列表
     * 
     * @param vtrExceptionalRecord 异常来访
     * @return 异常来访集合
     */
    public List<VtrExceptionalRecord> selectVtrExceptionalRecordList(VtrExceptionalRecord vtrExceptionalRecord);

    /**
     * 新增异常来访
     * 
     * @param vtrExceptionalRecord 异常来访
     * @return 结果
     */
    public int insertVtrExceptionalRecord(VtrExceptionalRecord vtrExceptionalRecord);

    /**
     * 修改异常来访
     * 
     * @param vtrExceptionalRecord 异常来访
     * @return 结果
     */
    public int updateVtrExceptionalRecord(VtrExceptionalRecord vtrExceptionalRecord);

    /**
     * 批量删除异常来访
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVtrExceptionalRecordByIds(String ids);

    /**
     * 删除异常来访信息
     * 
     * @param recordId 异常来访ID
     * @return 结果
     */
    public int deleteVtrExceptionalRecordById(Long recordId);

    /**~*/ /**~actionBegin*/
}
