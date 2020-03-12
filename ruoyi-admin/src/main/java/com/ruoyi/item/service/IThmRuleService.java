package com.ruoyi.item.service;

import com.ruoyi.item.domain.ThmRule;
import java.util.List;

/**
 * 体温检测规则Service接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface IThmRuleService 
{
    /**
     * 查询体温检测规则
     * 
     * @param ruleId 体温检测规则ID
     * @return 体温检测规则
     */
    public ThmRule selectThmRuleById(Long ruleId);

    /**
     * 查询体温检测规则列表
     * 
     * @param thmRule 体温检测规则
     * @return 体温检测规则集合
     */
    public List<ThmRule> selectThmRuleList(ThmRule thmRule);

    /**
     * 新增体温检测规则
     * 
     * @param thmRule 体温检测规则
     * @return 结果
     */
    public int insertThmRule(ThmRule thmRule);

    /**
     * 修改体温检测规则
     * 
     * @param thmRule 体温检测规则
     * @return 结果
     */
    public int updateThmRule(ThmRule thmRule);

    /**
     * 批量删除体温检测规则
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThmRuleByIds(String ids);

    /**
     * 删除体温检测规则信息
     * 
     * @param ruleId 体温检测规则ID
     * @return 结果
     */
    public int deleteThmRuleById(Long ruleId);

    /**~*/ /**~actionBegin*/
}
