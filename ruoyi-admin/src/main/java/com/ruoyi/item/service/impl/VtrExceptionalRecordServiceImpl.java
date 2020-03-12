package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.VtrExceptionalRecordMapper;
import com.ruoyi.item.domain.VtrExceptionalRecord;
import com.ruoyi.item.service.IVtrExceptionalRecordService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 异常来访Service业务层处理
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Service
public class VtrExceptionalRecordServiceImpl implements IVtrExceptionalRecordService 
{
    @Autowired
    private VtrExceptionalRecordMapper vtrExceptionalRecordMapper;

    /**
     * 查询异常来访
     * 
     * @param recordId 异常来访ID
     * @return 异常来访
     */
    @Override
    public VtrExceptionalRecord selectVtrExceptionalRecordById(Long recordId)
    {
        return vtrExceptionalRecordMapper.selectVtrExceptionalRecordById(recordId);
    }

    /**
     * 查询异常来访列表
     * 
     * @param vtrExceptionalRecord 异常来访
     * @return 异常来访
     */
    @Override
    public List<VtrExceptionalRecord> selectVtrExceptionalRecordList(VtrExceptionalRecord vtrExceptionalRecord)
    {
        return vtrExceptionalRecordMapper.selectVtrExceptionalRecordList(vtrExceptionalRecord);
    }

    /**
     * 新增异常来访
     * 
     * @param vtrExceptionalRecord 异常来访
     * @return 结果
     */
    @Override
    public int insertVtrExceptionalRecord(VtrExceptionalRecord vtrExceptionalRecord)
    {
        return vtrExceptionalRecordMapper.insertVtrExceptionalRecord(vtrExceptionalRecord);
    }

    /**
     * 修改异常来访
     * 
     * @param vtrExceptionalRecord 异常来访
     * @return 结果
     */
    @Override
    public int updateVtrExceptionalRecord(VtrExceptionalRecord vtrExceptionalRecord)
    {
        return vtrExceptionalRecordMapper.updateVtrExceptionalRecord(vtrExceptionalRecord);
    }

    /**
     * 删除异常来访对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVtrExceptionalRecordByIds(String ids)
    {
        return vtrExceptionalRecordMapper.deleteVtrExceptionalRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除异常来访信息
     * 
     * @param recordId 异常来访ID
     * @return 结果
     */
    @Override
    public int deleteVtrExceptionalRecordById(Long recordId)
    {
        return vtrExceptionalRecordMapper.deleteVtrExceptionalRecordById(recordId);
    }


         /**~*/ /**~actionBegin*/
}
