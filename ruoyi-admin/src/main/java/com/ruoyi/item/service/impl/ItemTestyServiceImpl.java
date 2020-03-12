package com.ruoyi.item.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.ItemTestyMapper;
import com.ruoyi.item.domain.ItemTesty;
import com.ruoyi.item.service.IItemTestyService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 部门Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-11
 */
@Service
public class ItemTestyServiceImpl implements IItemTestyService 
{
    @Autowired
    private ItemTestyMapper itemTestyMapper;

    /**
     * 查询部门
     * 
     * @param testyId 部门ID
     * @return 部门
     */
    @Override
    public ItemTesty selectItemTestyById(Long testyId)
    {
        return itemTestyMapper.selectItemTestyById(testyId);
    }

    /**
     * 查询部门列表
     *
     * @param itemTesty 部门
     * @return 部门
     */
    @Override
    public List<ItemTesty> selectItemTestyList(ItemTesty itemTesty)
    {
        return itemTestyMapper.selectItemTestyList(itemTesty);
    }
    /**
     * 查询部门列表
     *
     * @param itemTesty 部门
     * @return 部门
     */
    @Override
    public List<ItemTesty> selectItemTestyAll()
    {
        return itemTestyMapper.selectItemTestyAll();
    }

    /**
     * 新增部门
     * 
     * @param itemTesty 部门
     * @return 结果
     */
    @Override
    public int insertItemTesty(ItemTesty itemTesty)
    {
        itemTesty.setCreateTime(DateUtils.getNowDate());
        int rows =itemTestyMapper.insertItemTesty(itemTesty);
        return rows;
    }

    /**
     * 修改部门
     * 
     * @param itemTesty 部门
     * @return 结果
     */
    @Override
    public int updateItemTesty(ItemTesty itemTesty)
    {
        itemTesty.setUpdateTime(DateUtils.getNowDate());

        return itemTestyMapper.updateItemTesty(itemTesty);
    }

    /**
     * 删除部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteItemTestyByIds(String ids)
    {
        return itemTestyMapper.deleteItemTestyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除部门信息
     * 
     * @param testyId 部门ID
     * @return 结果
     */
    @Override
    public int deleteItemTestyById(Long testyId)
    {
        return itemTestyMapper.deleteItemTestyById(testyId);
    }
    /**
     * 查询部门树列表
     *
     * @return 所有部门信息
     */
    @Override
    public List<Ztree> generateItemTestyTreeDate(List<ItemTesty> itemTestyList,boolean isCheck)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ItemTesty itemTesty : itemTestyList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(itemTesty.getTestyId());
            ztree.setpId(itemTesty.getParentId());
            ztree.setName(itemTesty.getTestyName());
            ztree.setTitle(itemTesty.getTestyName());
            if (isCheck)
            {
                ztree.setChecked(itemTesty.isFlag());
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }


         /**~*/ /**~actionBegin*/

}
