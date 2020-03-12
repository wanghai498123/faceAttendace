package com.ruoyi.item.service;

import com.ruoyi.item.domain.VtrSubscribe;
import java.util.List;

/**
 * 访客预约Service接口
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public interface IVtrSubscribeService 
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
     * 批量删除访客预约
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVtrSubscribeByIds(String ids);

    /**
     * 删除访客预约信息
     * 
     * @param subscribeId 访客预约ID
     * @return 结果
     */
    public int deleteVtrSubscribeById(Long subscribeId);

    /**~*/ /**~actionBegin*/
}
