package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.RecTimeRuleMapper;
import com.ruoyi.item.domain.RecTimeRule;
import com.ruoyi.item.service.IRecTimeRuleService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 考勤时间设置Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Service
public class RecTimeRuleServiceImpl implements IRecTimeRuleService 
{
    @Autowired
    private RecTimeRuleMapper recTimeRuleMapper;

    /**
     * 查询考勤时间设置
     * 
     * @param timeRuleId 考勤时间设置ID
     * @return 考勤时间设置
     */
    @Override
    public RecTimeRule selectRecTimeRuleById(Long timeRuleId)
    {
        return recTimeRuleMapper.selectRecTimeRuleById(timeRuleId);
    }

    /**
     * 查询考勤时间设置列表
     * 
     * @param recTimeRule 考勤时间设置
     * @return 考勤时间设置
     */
    @Override
    public List<RecTimeRule> selectRecTimeRuleList(RecTimeRule recTimeRule)
    {
        return recTimeRuleMapper.selectRecTimeRuleList(recTimeRule);
    }

    /**
     * 新增考勤时间设置
     * 
     * @param recTimeRule 考勤时间设置
     * @return 结果
     */
    @Override
    public int insertRecTimeRule(RecTimeRule recTimeRule)
    {
        return recTimeRuleMapper.insertRecTimeRule(recTimeRule);
    }

    /**
     * 修改考勤时间设置
     * 
     * @param recTimeRule 考勤时间设置
     * @return 结果
     */
    @Override
    public int updateRecTimeRule(RecTimeRule recTimeRule)
    {
        return recTimeRuleMapper.updateRecTimeRule(recTimeRule);
    }

    /**
     * 删除考勤时间设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecTimeRuleByIds(String ids)
    {
        return recTimeRuleMapper.deleteRecTimeRuleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤时间设置信息
     * 
     * @param timeRuleId 考勤时间设置ID
     * @return 结果
     */
    @Override
    public int deleteRecTimeRuleById(Long timeRuleId)
    {
        return recTimeRuleMapper.deleteRecTimeRuleById(timeRuleId);
    }


         /**~*/ /**~actionBegin*/
}
