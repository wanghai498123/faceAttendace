package com.ruoyi.item.service;

import com.ruoyi.item.domain.RecPersonnelLeave;
import java.util.List;

/**
 * 员工请假Service接口
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public interface IRecPersonnelLeaveService 
{
    /**
     * 查询员工请假
     * 
     * @param personnelLeaveId 员工请假ID
     * @return 员工请假
     */
    public RecPersonnelLeave selectRecPersonnelLeaveById(Long personnelLeaveId);

    /**
     * 查询员工请假列表
     * 
     * @param recPersonnelLeave 员工请假
     * @return 员工请假集合
     */
    public List<RecPersonnelLeave> selectRecPersonnelLeaveList(RecPersonnelLeave recPersonnelLeave);

    /**
     * 新增员工请假
     * 
     * @param recPersonnelLeave 员工请假
     * @return 结果
     */
    public int insertRecPersonnelLeave(RecPersonnelLeave recPersonnelLeave);

    /**
     * 修改员工请假
     * 
     * @param recPersonnelLeave 员工请假
     * @return 结果
     */
    public int updateRecPersonnelLeave(RecPersonnelLeave recPersonnelLeave);

    /**
     * 批量删除员工请假
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecPersonnelLeaveByIds(String ids);

    /**
     * 删除员工请假信息
     * 
     * @param personnelLeaveId 员工请假ID
     * @return 结果
     */
    public int deleteRecPersonnelLeaveById(Long personnelLeaveId);

    /**~*/ /**~actionBegin*/
}
