package com.ruoyi.item.service;

import com.ruoyi.item.domain.RecRule;

import java.util.List;

/**
 * 考勤规则Service接口
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public interface IRecRuleService 
{
    /**
     * 查询考勤规则
     * 
     * @param ruleId 考勤规则ID
     * @return 考勤规则
     */
    public RecRule selectRecRuleById(Long ruleId);

    /**
     * 查询考勤规则列表
     * 
     * @param recRule 考勤规则
     * @return 考勤规则集合
     */
    public List<RecRule> selectRecRuleList(RecRule recRule);

    /**
     * 新增考勤规则
     * 
     * @param recRule 考勤规则
     * @return 结果
     */
    public int insertRecRule(RecRule recRule);

    /**
     * 修改考勤规则
     * 
     * @param recRule 考勤规则
     * @return 结果
     */
    public int updateRecRule(RecRule recRule);

    /**
     * 批量删除考勤规则
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecRuleByIds(String ids);

    /**
     * 删除考勤规则信息
     * 
     * @param ruleId 考勤规则ID
     * @return 结果
     */
    public int deleteRecRuleById(Long ruleId);
    /**~*/ /**~actionBegin*/
}
