package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.RecHolidayInfoMapper;
import com.ruoyi.item.domain.RecHolidayInfo;
import com.ruoyi.item.service.IRecHolidayInfoService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 假日设置Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Service
public class RecHolidayInfoServiceImpl implements IRecHolidayInfoService 
{
    @Autowired
    private RecHolidayInfoMapper recHolidayInfoMapper;

    /**
     * 查询假日设置
     * 
     * @param holidayInfoId 假日设置ID
     * @return 假日设置
     */
    @Override
    public RecHolidayInfo selectRecHolidayInfoById(Long holidayInfoId)
    {
        return recHolidayInfoMapper.selectRecHolidayInfoById(holidayInfoId);
    }

    /**
     * 查询假日设置列表
     * 
     * @param recHolidayInfo 假日设置
     * @return 假日设置
     */
    @Override
    public List<RecHolidayInfo> selectRecHolidayInfoList(RecHolidayInfo recHolidayInfo)
    {
        return recHolidayInfoMapper.selectRecHolidayInfoList(recHolidayInfo);
    }

    /**
     * 新增假日设置
     * 
     * @param recHolidayInfo 假日设置
     * @return 结果
     */
    @Override
    public int insertRecHolidayInfo(RecHolidayInfo recHolidayInfo)
    {
        return recHolidayInfoMapper.insertRecHolidayInfo(recHolidayInfo);
    }

    /**
     * 修改假日设置
     * 
     * @param recHolidayInfo 假日设置
     * @return 结果
     */
    @Override
    public int updateRecHolidayInfo(RecHolidayInfo recHolidayInfo)
    {
        return recHolidayInfoMapper.updateRecHolidayInfo(recHolidayInfo);
    }

    /**
     * 删除假日设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecHolidayInfoByIds(String ids)
    {
        return recHolidayInfoMapper.deleteRecHolidayInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除假日设置信息
     * 
     * @param holidayInfoId 假日设置ID
     * @return 结果
     */
    @Override
    public int deleteRecHolidayInfoById(Long holidayInfoId)
    {
        return recHolidayInfoMapper.deleteRecHolidayInfoById(holidayInfoId);
    }


         /**~*/ /**~actionBegin*/
}
