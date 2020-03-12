package com.ruoyi.item.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.item.mapper.RecPersonnelLeaveMapper;
import com.ruoyi.item.domain.RecPersonnelLeave;
import com.ruoyi.item.service.IRecPersonnelLeaveService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 员工请假Service业务层处理
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Service
public class RecPersonnelLeaveServiceImpl implements IRecPersonnelLeaveService 
{
    @Autowired
    private RecPersonnelLeaveMapper recPersonnelLeaveMapper;

    /**
     * 查询员工请假
     * 
     * @param personnelLeaveId 员工请假ID
     * @return 员工请假
     */
    @Override
    public RecPersonnelLeave selectRecPersonnelLeaveById(Long personnelLeaveId)
    {
        return recPersonnelLeaveMapper.selectRecPersonnelLeaveById(personnelLeaveId);
    }

    /**
     * 查询员工请假列表
     * 
     * @param recPersonnelLeave 员工请假
     * @return 员工请假
     */
    @Override
    public List<RecPersonnelLeave> selectRecPersonnelLeaveList(RecPersonnelLeave recPersonnelLeave)
    {
        return recPersonnelLeaveMapper.selectRecPersonnelLeaveList(recPersonnelLeave);
    }

    /**
     * 新增员工请假
     * 
     * @param recPersonnelLeave 员工请假
     * @return 结果
     */
    @Override
    public int insertRecPersonnelLeave(RecPersonnelLeave recPersonnelLeave)
    {
        return recPersonnelLeaveMapper.insertRecPersonnelLeave(recPersonnelLeave);
    }

    /**
     * 修改员工请假
     * 
     * @param recPersonnelLeave 员工请假
     * @return 结果
     */
    @Override
    public int updateRecPersonnelLeave(RecPersonnelLeave recPersonnelLeave)
    {
        return recPersonnelLeaveMapper.updateRecPersonnelLeave(recPersonnelLeave);
    }

    /**
     * 删除员工请假对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecPersonnelLeaveByIds(String ids)
    {
        return recPersonnelLeaveMapper.deleteRecPersonnelLeaveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工请假信息
     * 
     * @param personnelLeaveId 员工请假ID
     * @return 结果
     */
    @Override
    public int deleteRecPersonnelLeaveById(Long personnelLeaveId)
    {
        return recPersonnelLeaveMapper.deleteRecPersonnelLeaveById(personnelLeaveId);
    }


         /**~*/ /**~actionBegin*/
}
