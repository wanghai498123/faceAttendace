package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.ItemTestxMapper;
import com.ruoyi.item.domain.ItemTestx;
import com.ruoyi.item.service.IItemTestxService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-12
 */
@Service
public class ItemTestxServiceImpl implements IItemTestxService 
{
    @Autowired
    private ItemTestxMapper itemTestxMapper;

    /**
     * 查询测试
     * 
     * @param testxId 测试ID
     * @return 测试
     */
    @Override
    public ItemTestx selectItemTestxById(Long testxId)
    {
        return itemTestxMapper.selectItemTestxById(testxId);
    }

    /**
     * 查询测试列表
     *
     * @param itemTestx 测试
     * @return 测试
     */
    @Override
    public List<ItemTestx> selectItemTestxList(ItemTestx itemTestx)
    {
        return itemTestxMapper.selectItemTestxList(itemTestx);
    }
    /**
     * 查询测试列表
     *
     * @param itemTestx 测试
     * @return 测试
     */
    @Override
    public List<ItemTestx> selectItemTestxAll()
    {
        return itemTestxMapper.selectItemTestxAll();
    }

    /**
     * 新增测试
     * 
     * @param itemTestx 测试
     * @return 结果
     */
    @Override
    @Transactional
    public int insertItemTestx(ItemTestx itemTestx)
    {
        int rows =itemTestxMapper.insertItemTestx(itemTestx);
        return rows;
    }

    /**
     * 修改测试
     * 
     * @param itemTestx 测试
     * @return 结果
     */
    @Override
    @Transactional
    public int updateItemTestx(ItemTestx itemTestx)
    {

        return itemTestxMapper.updateItemTestx(itemTestx);
    }

    /**
     * 删除测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteItemTestxByIds(String ids)
    {
        return itemTestxMapper.deleteItemTestxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试信息
     * 
     * @param testxId 测试ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteItemTestxById(Long testxId)
    {
        return itemTestxMapper.deleteItemTestxById(testxId);
    }


         /**~*/ /**~actionBegin*/

}
