package com.ruoyi.item.service;

import com.ruoyi.item.domain.RecCustomizeHolidayInfo;
import java.util.List;

/**
 * 自定义假日设置Service接口
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public interface IRecCustomizeHolidayInfoService 
{
    /**
     * 查询自定义假日设置
     * 
     * @param customizeHolidayInfoId 自定义假日设置ID
     * @return 自定义假日设置
     */
    public RecCustomizeHolidayInfo selectRecCustomizeHolidayInfoById(Long customizeHolidayInfoId);

    /**
     * 查询自定义假日设置列表
     * 
     * @param recCustomizeHolidayInfo 自定义假日设置
     * @return 自定义假日设置集合
     */
    public List<RecCustomizeHolidayInfo> selectRecCustomizeHolidayInfoList(RecCustomizeHolidayInfo recCustomizeHolidayInfo);

    /**
     * 新增自定义假日设置
     * 
     * @param recCustomizeHolidayInfo 自定义假日设置
     * @return 结果
     */
    public int insertRecCustomizeHolidayInfo(RecCustomizeHolidayInfo recCustomizeHolidayInfo);

    /**
     * 修改自定义假日设置
     * 
     * @param recCustomizeHolidayInfo 自定义假日设置
     * @return 结果
     */
    public int updateRecCustomizeHolidayInfo(RecCustomizeHolidayInfo recCustomizeHolidayInfo);

    /**
     * 批量删除自定义假日设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecCustomizeHolidayInfoByIds(String ids);

    /**
     * 删除自定义假日设置信息
     * 
     * @param customizeHolidayInfoId 自定义假日设置ID
     * @return 结果
     */
    public int deleteRecCustomizeHolidayInfoById(Long customizeHolidayInfoId);

    /**~*/ /**~actionBegin*/
}
