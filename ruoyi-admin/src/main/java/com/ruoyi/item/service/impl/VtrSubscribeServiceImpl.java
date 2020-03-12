package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.VtrSubscribeMapper;
import com.ruoyi.item.domain.VtrSubscribe;
import com.ruoyi.item.service.IVtrSubscribeService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 访客预约Service业务层处理
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Service
public class VtrSubscribeServiceImpl implements IVtrSubscribeService 
{
    @Autowired
    private VtrSubscribeMapper vtrSubscribeMapper;

    /**
     * 查询访客预约
     * 
     * @param subscribeId 访客预约ID
     * @return 访客预约
     */
    @Override
    public VtrSubscribe selectVtrSubscribeById(Long subscribeId)
    {
        return vtrSubscribeMapper.selectVtrSubscribeById(subscribeId);
    }

    /**
     * 查询访客预约列表
     * 
     * @param vtrSubscribe 访客预约
     * @return 访客预约
     */
    @Override
    public List<VtrSubscribe> selectVtrSubscribeList(VtrSubscribe vtrSubscribe)
    {
        return vtrSubscribeMapper.selectVtrSubscribeList(vtrSubscribe);
    }

    /**
     * 新增访客预约
     * 
     * @param vtrSubscribe 访客预约
     * @return 结果
     */
    @Override
    public int insertVtrSubscribe(VtrSubscribe vtrSubscribe)
    {
        return vtrSubscribeMapper.insertVtrSubscribe(vtrSubscribe);
    }

    /**
     * 修改访客预约
     * 
     * @param vtrSubscribe 访客预约
     * @return 结果
     */
    @Override
    public int updateVtrSubscribe(VtrSubscribe vtrSubscribe)
    {
        return vtrSubscribeMapper.updateVtrSubscribe(vtrSubscribe);
    }

    /**
     * 删除访客预约对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVtrSubscribeByIds(String ids)
    {
        return vtrSubscribeMapper.deleteVtrSubscribeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除访客预约信息
     * 
     * @param subscribeId 访客预约ID
     * @return 结果
     */
    @Override
    public int deleteVtrSubscribeById(Long subscribeId)
    {
        return vtrSubscribeMapper.deleteVtrSubscribeById(subscribeId);
    }


         /**~*/ /**~actionBegin*/
}
