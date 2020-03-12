package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.system.domain.SysDept;

/**
 * 机构管理 数据层
 * 
 * @author ruoyi
 */
public interface SysDeptMapper
{
    /**
     * 查询机构人数
     * 
     * @param dept 机构信息
     * @return 结果
     */
    public int selectDeptCount(SysDept dept);

    /**
     * 查询最大序号
     *
     * @param dept 机构信息
     * @return 结果
     */
    public int selectMaxOrderNum(Long parentId);

    /**
     * 查询机构是否存在用户
     * 
     * @param deptId 机构ID
     * @return 结果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 查询机构管理数据
     * 
     * @param dept 机构信息
     * @return 机构信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 删除机构管理信息
     * 
     * @param deptId 机构ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 批量删除机构管理信息
     *
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeptByIds(String[] deptIds);

    /**
     * 新增机构信息
     * 
     * @param dept 机构信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改机构信息
     * 
     * @param dept 机构信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 修改子元素关系
     * 
     * @param depts 子元素
     * @return 结果
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

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
     * @param deptName 机构名称
     * @param parentId 父机构ID
     * @return 结果
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

    /**
     * 根据角色ID查询机构
     *
     * @param roleId 角色ID
     * @return 机构列表
     */
    public List<String> selectRoleDeptTree(Long roleId);

    /**
     * 修改所在机构的父级机构状态
     * 
     * @param dept 机构
     */
    public void updateDeptStatus(SysDept dept);

    /**
     * 根据ID查询所有子机构
     * @param deptId 机构ID
     * @return 机构列表
     */
    public List<SysDept> selectChildrenDeptById(Long deptId);
}
