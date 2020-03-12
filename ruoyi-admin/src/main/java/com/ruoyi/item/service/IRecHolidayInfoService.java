package com.ruoyi.item.service;

import com.ruoyi.item.domain.RecHolidayInfo;
import java.util.List;

/**
 * 假日设置Service接口
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public interface IRecHolidayInfoService 
{
    /**
     * 查询假日设置
     * 
     * @param holidayInfoId 假日设置ID
     * @return 假日设置
     */
    public RecHolidayInfo selectRecHolidayInfoById(Long holidayInfoId);

    /**
     * 查询假日设置列表
     * 
     * @param recHolidayInfo 假日设置
     * @return 假日设置集合
     */
    public List<RecHolidayInfo> selectRecHolidayInfoList(RecHolidayInfo recHolidayInfo);

    /**
     * 新增假日设置
     * 
     * @param recHolidayInfo 假日设置
     * @return 结果
     */
    public int insertRecHolidayInfo(RecHolidayInfo recHolidayInfo);

    /**
     * 修改假日设置
     * 
     * @param recHolidayInfo 假日设置
     * @return 结果
     */
    public int updateRecHolidayInfo(RecHolidayInfo recHolidayInfo);

    /**
     * 批量删除假日设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecHolidayInfoByIds(String ids);

    /**
     * 删除假日设置信息
     * 
     * @param holidayInfoId 假日设置ID
     * @return 结果
     */
    public int deleteRecHolidayInfoById(Long holidayInfoId);

    /**~*/ /**~actionBegin*/
}
