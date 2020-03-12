package com.ruoyi.item.service;

import com.ruoyi.item.domain.ItemCompany;

import java.util.List;

/**
 * 建筑公司Service接口
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public interface IItemCompanyService 
{
    /**
     * 查询建筑公司
     * 
     * @param companyId 建筑公司ID
     * @return 建筑公司
     */
    public ItemCompany selectItemCompanyById(Long companyId);

    /**
     * 查询建筑公司列表
     * 
     * @param itemCompany 建筑公司
     * @return 建筑公司集合
     */
    public List<ItemCompany> selectItemCompanyList(ItemCompany itemCompany);

    /**
     * 新增建筑公司
     * 
     * @param itemCompany 建筑公司
     * @return 结果
     */
    public int insertItemCompany(ItemCompany itemCompany);

    /**
     * 修改建筑公司
     * 
     * @param itemCompany 建筑公司
     * @return 结果
     */
    public int updateItemCompany(ItemCompany itemCompany);

    /**
     * 批量删除建筑公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteItemCompanyByIds(String ids);

    /**
     * 删除建筑公司信息
     * 
     * @param companyId 建筑公司ID
     * @return 结果
     */
    public int deleteItemCompanyById(Long companyId);
    /**~*/ /**~actionBegin*/
}
