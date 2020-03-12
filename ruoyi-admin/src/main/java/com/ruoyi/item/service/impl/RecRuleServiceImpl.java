package com.ruoyi.item.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.item.domain.RecRule;
import com.ruoyi.item.mapper.RecRuleMapper;
import com.ruoyi.item.service.IRecRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考勤规则Service业务层处理
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Service
public class RecRuleServiceImpl implements IRecRuleService 
{
    @Autowired
    private RecRuleMapper recRuleMapper;

    /**
     * 查询考勤规则
     * 
     * @param ruleId 考勤规则ID
     * @return 考勤规则
     */
    @Override
    public RecRule selectRecRuleById(Long ruleId)
    {
        return recRuleMapper.selectRecRuleById(ruleId);
    }

    /**
     * 查询考勤规则列表
     * 
     * @param recRule 考勤规则
     * @return 考勤规则
     */
    @Override
    public List<RecRule> selectRecRuleList(RecRule recRule)
    {
        return recRuleMapper.selectRecRuleList(recRule);
    }

    /**
     * 新增考勤规则
     * 
     * @param recRule 考勤规则
     * @return 结果
     */
    @Override
    public int insertRecRule(RecRule recRule)
    {
        return recRuleMapper.insertRecRule(recRule);
    }

    /**
     * 修改考勤规则
     * 
     * @param recRule 考勤规则
     * @return 结果
     */
    @Override
    public int updateRecRule(RecRule recRule)
    {
        return recRuleMapper.updateRecRule(recRule);
    }

    /**
     * 删除考勤规则对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecRuleByIds(String ids)
    {
        return recRuleMapper.deleteRecRuleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤规则信息
     * 
     * @param ruleId 考勤规则ID
     * @return 结果
     */
    @Override
    public int deleteRecRuleById(Long ruleId)
    {
        return recRuleMapper.deleteRecRuleById(ruleId);
    }
    /**~*/ /**~actionBegin*/
}
