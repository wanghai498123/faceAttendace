package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.GenTableAction;
import java.util.List;

/**
 * 代码生成业务字段Mapper接口
 *
 * @author wanghai
 * @date 2020-02-24
 */
public interface GenTableActionMapper
{
    /**
     * 查询代码生成业务字段
     *
     * @param actionId 代码生成业务字段ID
     * @return 代码生成业务字段
     */
    public GenTableAction selectGenTableActionById(Long actionId);

    /**
     * 查询代码生成业务字段列表
     *
     * @param genTableAction 代码生成业务字段
     * @return 代码生成业务字段集合
     */
    public List<GenTableAction> selectGenTableActionList(GenTableAction genTableAction);

    /**
     * 新增代码生成业务字段
     *
     * @param genTableAction 代码生成业务字段
     * @return 结果
     */
    public int insertGenTableAction(GenTableAction genTableAction);

    /**
     * 修改代码生成业务字段
     *
     * @param genTableAction 代码生成业务字段
     * @return 结果
     */
    public int updateGenTableAction(GenTableAction genTableAction);

    /**
     * 删除代码生成业务字段
     *
     * @param actionId 代码生成业务字段ID
     * @return 结果
     */
    public int deleteGenTableActionById(Long actionId);

    /**
     * 批量删除代码生成业务字段
     *
     * @param actionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGenTableActionByIds(Long[] actionIds);

    List<GenTableAction> selectGenTableColumnListByTableId(long tableId);

    GenTableAction selectDbTableActionById(long editActionID);
}
