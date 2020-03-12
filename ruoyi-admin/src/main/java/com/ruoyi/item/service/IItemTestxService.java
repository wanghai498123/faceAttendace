package com.ruoyi.item.service;

import com.ruoyi.item.domain.ItemTestx;
import java.util.List;

/**
 * 测试Service接口
 * 
 * @author wanghai
 * @date 2020-03-12
 */
public interface IItemTestxService 
{
    /**
     * 查询测试
     * 
     * @param testxId 测试ID
     * @return 测试
     */
    public ItemTestx selectItemTestxById(Long testxId);

    /**
     * 查询测试列表
     * 
     * @param itemTestx 测试
     * @return 测试集合
     */
    public List<ItemTestx> selectItemTestxList(ItemTestx itemTestx);

    /**
     * 查询测试列表
     *
     * @param itemTestx 测试
     * @return 测试集合
     */
    public List<ItemTestx> selectItemTestxAll();

    /**
     * 新增测试
     * 
     * @param itemTestx 测试
     * @return 结果
     */
    public int insertItemTestx(ItemTestx itemTestx);

    /**
     * 修改测试
     * 
     * @param itemTestx 测试
     * @return 结果
     */
    public int updateItemTestx(ItemTestx itemTestx);

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteItemTestxByIds(String ids);

    /**
     * 删除测试信息
     * 
     * @param testxId 测试ID
     * @return 结果
     */
    public int deleteItemTestxById(Long testxId);

    /**~*/ /**~actionBegin*/

}
