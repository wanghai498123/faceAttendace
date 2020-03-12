package com.ruoyi.item.mapper;

import com.ruoyi.item.domain.RecPersonnelLeave;
import java.util.List;

/**
 * 员工请假Mapper接口
 * 
 * @author wanghai
 * @date 2020-03-03
 */
public interface RecPersonnelLeaveMapper 
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
     * 删除员工请假
     * 
     * @param personnelLeaveId 员工请假ID
     * @return 结果
     */
    public int deleteRecPersonnelLeaveById(Long personnelLeaveId);

    /**
     * 批量删除员工请假
     * 
     * @param personnelLeaveIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecPersonnelLeaveByIds(String[] personnelLeaveIds);

    /**~*/ /**~actionBegin*/
}
