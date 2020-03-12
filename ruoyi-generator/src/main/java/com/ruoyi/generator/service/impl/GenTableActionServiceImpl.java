package  com.ruoyi.generator.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.generator.domain.GenTable;
import com.ruoyi.generator.domain.GenTableColumn;
import com.ruoyi.generator.mapper.GenTableColumnMapper;
import com.ruoyi.generator.service.IGenTableActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.generator.mapper.GenTableActionMapper;
import com.ruoyi.generator.domain.GenTableAction;
import com.ruoyi.common.core.text.Convert;

/**
 * 代码生成业务字段Service业务层处理
 *
 * @author wanghai
 * @date 2020-02-24
 */
@Service
public class GenTableActionServiceImpl implements IGenTableActionService
{
    @Autowired
    private GenTableActionMapper genTableActionMapper;

    @Autowired
    private GenTableColumnMapper genTableColumnMapper;
    /**
     * 查询代码生成业务字段
     *
     * @param actionId 代码生成业务字段ID
     * @return 代码生成业务字段
     */
    @Override
    public GenTableAction selectGenTableActionById(Long actionId)
    {
        return genTableActionMapper.selectGenTableActionById(actionId);
    }

    /**
     * 查询代码生成业务字段列表
     *
     * @param genTableAction 代码生成业务字段
     * @return 代码生成业务字段
     */
    @Override
    public List<GenTableAction> selectGenTableActionList(GenTableAction genTableAction)
    {
        return genTableActionMapper.selectGenTableActionList(genTableAction);
    }

    /**
     * 新增代码生成业务字段
     *
     * @param genTableAction 代码生成业务字段
     * @return 结果
     */
    @Override
    public int insertGenTableAction(GenTableAction genTableAction)
    {
        genTableAction.setCreateTime(DateUtils.getNowDate());
        return genTableActionMapper.insertGenTableAction(genTableAction);
    }

    /**
     * 修改代码生成业务字段
     *
     * @param genTableAction 代码生成业务字段
     * @return 结果
     */
    @Override
    public int updateGenTableAction(GenTableAction genTableAction)
    {
        genTableAction.setUpdateTime(DateUtils.getNowDate());
        return genTableActionMapper.updateGenTableAction(genTableAction);
    }

    /**
     * 删除代码生成业务字段对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGenTableActionByIds(String ids)
    {
        return genTableActionMapper.deleteGenTableActionByIds(Convert.toLongArray(ids));
    }

    /**
     * 删除代码生成业务字段信息
     *
     * @param actionId 代码生成业务字段ID
     * @return 结果
     */
    @Override
    public int deleteGenTableActionById(Long actionId)
    {
        return genTableActionMapper.deleteGenTableActionById(actionId);
    }

    @Override
    public List<GenTableAction> selectGenTableActionListByTableId(GenTable genTable) {
            List<GenTableAction> genTableActions=genTableActionMapper.selectGenTableColumnListByTableId(genTable.getTableId());
        for (GenTableAction genTableAction1: genTableActions) {
            if(genTable.getColumns()!=null&&genTableAction1.getColumnIndex()>0)
                genTableAction1.setOperateColumn(genTable.getColumns().get(genTableAction1.getColumnIndex()));
        }
        return genTableActions;
    }
}
