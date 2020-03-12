package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.RecCustomizeHolidayInfoMapper;
import com.ruoyi.item.domain.RecCustomizeHolidayInfo;
import com.ruoyi.item.service.IRecCustomizeHolidayInfoService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 自定义假日设置Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Service
public class RecCustomizeHolidayInfoServiceImpl implements IRecCustomizeHolidayInfoService 
{
    @Autowired
    private RecCustomizeHolidayInfoMapper recCustomizeHolidayInfoMapper;

    /**
     * 查询自定义假日设置
     * 
     * @param customizeHolidayInfoId 自定义假日设置ID
     * @return 自定义假日设置
     */
    @Override
    public RecCustomizeHolidayInfo selectRecCustomizeHolidayInfoById(Long customizeHolidayInfoId)
    {
        return recCustomizeHolidayInfoMapper.selectRecCustomizeHolidayInfoById(customizeHolidayInfoId);
    }

    /**
     * 查询自定义假日设置列表
     * 
     * @param recCustomizeHolidayInfo 自定义假日设置
     * @return 自定义假日设置
     */
    @Override
    public List<RecCustomizeHolidayInfo> selectRecCustomizeHolidayInfoList(RecCustomizeHolidayInfo recCustomizeHolidayInfo)
    {
        return recCustomizeHolidayInfoMapper.selectRecCustomizeHolidayInfoList(recCustomizeHolidayInfo);
    }

    /**
     * 新增自定义假日设置
     * 
     * @param recCustomizeHolidayInfo 自定义假日设置
     * @return 结果
     */
    @Override
    public int insertRecCustomizeHolidayInfo(RecCustomizeHolidayInfo recCustomizeHolidayInfo)
    {
        return recCustomizeHolidayInfoMapper.insertRecCustomizeHolidayInfo(recCustomizeHolidayInfo);
    }

    /**
     * 修改自定义假日设置
     * 
     * @param recCustomizeHolidayInfo 自定义假日设置
     * @return 结果
     */
    @Override
    public int updateRecCustomizeHolidayInfo(RecCustomizeHolidayInfo recCustomizeHolidayInfo)
    {
        return recCustomizeHolidayInfoMapper.updateRecCustomizeHolidayInfo(recCustomizeHolidayInfo);
    }

    /**
     * 删除自定义假日设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecCustomizeHolidayInfoByIds(String ids)
    {
        return recCustomizeHolidayInfoMapper.deleteRecCustomizeHolidayInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除自定义假日设置信息
     * 
     * @param customizeHolidayInfoId 自定义假日设置ID
     * @return 结果
     */
    @Override
    public int deleteRecCustomizeHolidayInfoById(Long customizeHolidayInfoId)
    {
        return recCustomizeHolidayInfoMapper.deleteRecCustomizeHolidayInfoById(customizeHolidayInfoId);
    }


         /**~*/ /**~actionBegin*/
}
