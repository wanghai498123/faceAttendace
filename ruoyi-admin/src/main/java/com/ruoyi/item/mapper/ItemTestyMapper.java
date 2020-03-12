package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.ItemTesty;
import java.util.List;

/**
 * 部门Mapper接口
 * 
 * @author wanghai
 * @date 2020-03-11
 */
public interface ItemTestyMapper 
{
    /**
     * 查询部门
     * 
     * @param testyId 部门ID
     * @return 部门
     */
    public ItemTesty selectItemTestyById(Long testyId);

    /**
     * 查询部门列表
     *
     * @param itemTesty 部门
     * @return 部门集合
     */
    public List<ItemTesty> selectItemTestyList(ItemTesty itemTesty);

    /**
     * 查询部门列表
     *
     * @param itemTesty 部门
     * @return 部门集合
     */
    public List<ItemTesty> selectItemTestyAll();

    /**
     * 新增部门
     * 
     * @param itemTesty 部门
     * @return 结果
     */
    public int insertItemTesty(ItemTesty itemTesty);

    /**
     * 修改部门
     * 
     * @param itemTesty 部门
     * @return 结果
     */
    public int updateItemTesty(ItemTesty itemTesty);

    /**
     * 删除部门
     * 
     * @param testyId 部门ID
     * @return 结果
     */
    public int deleteItemTestyById(Long testyId);

    /**
     * 批量删除部门
     * 
     * @param testyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteItemTestyByIds(String[] testyIds);

    /**~*/ /**~actionBegin*/

}
