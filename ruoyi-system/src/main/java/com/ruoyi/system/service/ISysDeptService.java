package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;

/**
 * 机构管理 服务层
 * 
 * @author ruoyi
 */
public interface ISysDeptService
{
    /**
     * 查询机构管理数据
     * 
     * @param dept 机构信息
     * @return 机构信息集合
     */
    public List<SysDept> selectSysDeptList(SysDept dept);

    /**
     * 查询机构管理树
     * 
     * @param dept 机构信息
     * @return 所有机构信息
     */
    public List<Ztree> selectDeptTree(SysDept dept);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDeptTreeData(SysRole role);

    /**
     * 查询机构人数
     * 
     * @param parentId 父机构ID
     * @return 结果
     */
    public int selectDeptCount(Long parentId);

    /**
     * 查询机构是否存在用户
     * 
     * @param deptId 机构ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 删除机构管理信息
     * 
     * @param deptId 机构ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增保存机构信息
     * 
     * @param dept 机构信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改保存机构信息
     * 
     * @param dept 机构信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 根据机构ID查询信息
     * 
     * @param deptId 机构ID
     * @return 机构信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 校验机构名称是否唯一
     * 
     * @param dept 机构信息
     * @return 结果
     */
    public String checkDeptNameUnique(SysDept dept);
}
