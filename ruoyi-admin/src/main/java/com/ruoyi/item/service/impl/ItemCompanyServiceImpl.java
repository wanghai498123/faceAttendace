package com.ruoyi.item.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.item.domain.ItemCompany;
import com.ruoyi.item.mapper.ItemCompanyMapper;
import com.ruoyi.item.service.IItemCompanyService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 建筑公司Service业务层处理
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Service
public class ItemCompanyServiceImpl implements IItemCompanyService
{
    @Autowired
    private ItemCompanyMapper itemCompanyMapper;

    @Autowired
    private SysDeptMapper deptMapper;

    /**
     * 查询建筑公司
     * 
     * @param companyId 建筑公司ID
     * @return 建筑公司
     */
    @Override
    public ItemCompany selectItemCompanyById(Long companyId)
    {
        return itemCompanyMapper.selectItemCompanyById(companyId);
    }

    /**
     * 查询建筑公司列表
     * 
     * @param itemCompany 建筑公司
     * @return 建筑公司
     */
    @Override
    public List<ItemCompany> selectItemCompanyList(ItemCompany itemCompany)
    {
        return itemCompanyMapper.selectItemCompanyList(itemCompany);
    }

    /**
     * 新增建筑公司
     * 
     * @param itemCompany 建筑公司
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertItemCompany(ItemCompany itemCompany)
    {
        //先保存机构到树。再保存数据
        SysDept info = deptMapper.selectDeptById(itemCompany.getDeptId());
        SysDept dept=new SysDept();
        dept.setAncestors(info.getAncestors() + "," + itemCompany.getDeptId());
        dept.setDeptName(itemCompany.getCompanyName());
        dept.setOrderNum(String.valueOf(deptMapper.selectMaxOrderNum(itemCompany.getDeptId())));
        dept.setParentId(itemCompany.getDeptId());
        if(deptMapper.insertDept(dept)!=0) {
            itemCompany.setCompanyId(dept.getDeptId());//使用机构id就可以了
            return itemCompanyMapper.insertItemCompany(itemCompany);
        }
        else
        {
            return 0;
        }
    }

    /**
     * 修改建筑公司
     * 
     * @param itemCompany 建筑公司
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateItemCompany(ItemCompany itemCompany)
    {
        SysDept dept = deptMapper.selectDeptById(itemCompany.getCompanyId());
        dept.setDeptName(itemCompany.getCompanyName());

        if(deptMapper.updateDept(dept)!=0) {
            return itemCompanyMapper.updateItemCompany(itemCompany);
        }
        else
        {
            return 0;
        }
    }

    /**
     * 删除建筑公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteItemCompanyByIds(String ids)
    {
        if(deptMapper.deleteDeptByIds(Convert.toStrArray(ids))!=0) {
            return itemCompanyMapper.deleteItemCompanyByIds(Convert.toStrArray(ids));
        }
        else
        {
            return 0;
        }
    }

    /**
     * 删除建筑公司信息
     * 
     * @param companyId 建筑公司ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteItemCompanyById(Long companyId)
    {
        if(deptMapper.deleteDeptById(companyId)!=0) {
            return itemCompanyMapper.deleteItemCompanyById(companyId);
        }
        else
        {
            return 0;
        }
    }
    /**~*/ /**~actionBegin*/
}
