package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.ThmRuleMapper;
import com.ruoyi.item.domain.ThmRule;
import com.ruoyi.item.service.IThmRuleService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 体温检测规则Service业务层处理
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Service
public class ThmRuleServiceImpl implements IThmRuleService 
{
    @Autowired
    private ThmRuleMapper thmRuleMapper;

    /**
     * 查询体温检测规则
     * 
     * @param ruleId 体温检测规则ID
     * @return 体温检测规则
     */
    @Override
    public ThmRule selectThmRuleById(Long ruleId)
    {
        return thmRuleMapper.selectThmRuleById(ruleId);
    }

    /**
     * 查询体温检测规则列表
     * 
     * @param thmRule 体温检测规则
     * @return 体温检测规则
     */
    @Override
    public List<ThmRule> selectThmRuleList(ThmRule thmRule)
    {
        return thmRuleMapper.selectThmRuleList(thmRule);
    }

    /**
     * 新增体温检测规则
     * 
     * @param thmRule 体温检测规则
     * @return 结果
     */
    @Override
    public int insertThmRule(ThmRule thmRule)
    {
        return thmRuleMapper.insertThmRule(thmRule);
    }

    /**
     * 修改体温检测规则
     * 
     * @param thmRule 体温检测规则
     * @return 结果
     */
    @Override
    public int updateThmRule(ThmRule thmRule)
    {
        return thmRuleMapper.updateThmRule(thmRule);
    }

    /**
     * 删除体温检测规则对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThmRuleByIds(String ids)
    {
        return thmRuleMapper.deleteThmRuleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除体温检测规则信息
     * 
     * @param ruleId 体温检测规则ID
     * @return 结果
     */
    @Override
    public int deleteThmRuleById(Long ruleId)
    {
        return thmRuleMapper.deleteThmRuleById(ruleId);
    }


         /**~*/ /**~actionBegin*/
}
