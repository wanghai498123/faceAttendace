package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.VtrSubscribe;
import java.util.List;

/**
 * 访客预约Mapper接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface VtrSubscribeMapper 
{
    /**
     * 查询访客预约
     * 
     * @param subscribeId 访客预约ID
     * @return 访客预约
     */
    public VtrSubscribe selectVtrSubscribeById(Long subscribeId);

    /**
     * 查询访客预约列表
     * 
     * @param vtrSubscribe 访客预约
     * @return 访客预约集合
     */
    public List<VtrSubscribe> selectVtrSubscribeList(VtrSubscribe vtrSubscribe);

    /**
     * 新增访客预约
     * 
     * @param vtrSubscribe 访客预约
     * @return 结果
     */
    public int insertVtrSubscribe(VtrSubscribe vtrSubscribe);

    /**
     * 修改访客预约
     * 
     * @param vtrSubscribe 访客预约
     * @return 结果
     */
    public int updateVtrSubscribe(VtrSubscribe vtrSubscribe);

    /**
     * 删除访客预约
     * 
     * @param subscribeId 访客预约ID
     * @return 结果
     */
    public int deleteVtrSubscribeById(Long subscribeId);

    /**
     * 批量删除访客预约
     * 
     * @param subscribeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteVtrSubscribeByIds(String[] subscribeIds);

    /**~*/ /**~actionBegin*/
}
