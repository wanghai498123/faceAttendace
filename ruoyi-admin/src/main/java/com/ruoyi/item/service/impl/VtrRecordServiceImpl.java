package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.VtrRecordMapper;
import com.ruoyi.item.domain.VtrRecord;
import com.ruoyi.item.service.IVtrRecordService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 来访记录Service业务层处理
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Service
public class VtrRecordServiceImpl implements IVtrRecordService 
{
    @Autowired
    private VtrRecordMapper vtrRecordMapper;

    /**
     * 查询来访记录
     * 
     * @param recordId 来访记录ID
     * @return 来访记录
     */
    @Override
    public VtrRecord selectVtrRecordById(Long recordId)
    {
        return vtrRecordMapper.selectVtrRecordById(recordId);
    }

    /**
     * 查询来访记录列表
     * 
     * @param vtrRecord 来访记录
     * @return 来访记录
     */
    @Override
    public List<VtrRecord> selectVtrRecordList(VtrRecord vtrRecord)
    {
        return vtrRecordMapper.selectVtrRecordList(vtrRecord);
    }

    /**
     * 新增来访记录
     * 
     * @param vtrRecord 来访记录
     * @return 结果
     */
    @Override
    public int insertVtrRecord(VtrRecord vtrRecord)
    {
        return vtrRecordMapper.insertVtrRecord(vtrRecord);
    }

    /**
     * 修改来访记录
     * 
     * @param vtrRecord 来访记录
     * @return 结果
     */
    @Override
    public int updateVtrRecord(VtrRecord vtrRecord)
    {
        return vtrRecordMapper.updateVtrRecord(vtrRecord);
    }

    /**
     * 删除来访记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVtrRecordByIds(String ids)
    {
        return vtrRecordMapper.deleteVtrRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除来访记录信息
     * 
     * @param recordId 来访记录ID
     * @return 结果
     */
    @Override
    public int deleteVtrRecordById(Long recordId)
    {
        return vtrRecordMapper.deleteVtrRecordById(recordId);
    }


         /**~*/ /**~actionBegin*/
}
