package com.ruoyi.item.service;

import com.ruoyi.item.domain.RecTimeRule;
import java.util.List;

/**
 * 考勤时间设置Service接口
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public interface IRecTimeRuleService 
{
    /**
     * 查询考勤时间设置
     * 
     * @param timeRuleId 考勤时间设置ID
     * @return 考勤时间设置
     */
    public RecTimeRule selectRecTimeRuleById(Long timeRuleId);

    /**
     * 查询考勤时间设置列表
     * 
     * @param recTimeRule 考勤时间设置
     * @return 考勤时间设置集合
     */
    public List<RecTimeRule> selectRecTimeRuleList(RecTimeRule recTimeRule);

    /**
     * 新增考勤时间设置
     * 
     * @param recTimeRule 考勤时间设置
     * @return 结果
     */
    public int insertRecTimeRule(RecTimeRule recTimeRule);

    /**
     * 修改考勤时间设置
     * 
     * @param recTimeRule 考勤时间设置
     * @return 结果
     */
    public int updateRecTimeRule(RecTimeRule recTimeRule);

    /**
     * 批量删除考勤时间设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecTimeRuleByIds(String ids);

    /**
     * 删除考勤时间设置信息
     * 
     * @param timeRuleId 考勤时间设置ID
     * @return 结果
     */
    public int deleteRecTimeRuleById(Long timeRuleId);

    /**~*/ /**~actionBegin*/
}
