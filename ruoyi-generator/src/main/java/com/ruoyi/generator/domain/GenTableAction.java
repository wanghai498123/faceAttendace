package com.ruoyi.generator.domain;

import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 代码生成业务字段对象 gen_table_action
 *
 * @author wanghai
 * @date 2020-02-24
 */
public class GenTableAction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long actionId;

    /** 归属表编号 */
    @Excel(name = "归属表编号")
    private String tableId;

    /** 功能名称 */
    @Excel(name = "功能名称")
    private String actionName;

    /** 功能描述 */
    @Excel(name = "功能描述")
    private String actionComment;

    /** 模板名称 */
    @Excel(name = "模板名称")
    private String mouldName;

    /** 模板描述 */
    @Excel(name = "模板描述")
    private String mouldComment;

    /** 是否有控制层（1是） */
    @Excel(name = "是否有控制层", readConverterExp = "1=是")
    private String isController;

    /** 是否有视图（1是） */
    @Excel(name = "是否有视图", readConverterExp = "1=是")
    private String isView;
    public boolean isView()
    {
        return isView(this.isView);
    }

    public boolean isView(String isView)
    {
        return isView != null && StringUtils.equals("1", isView);
    }

    /** 是否有服务层（1是） */
    @Excel(name = "是否有服务层", readConverterExp = "1=是")
    private String isService;

    /** 是否有数据层（1是） */
    @Excel(name = "是否有数据层", readConverterExp = "1=是")
    private String isDao;

    /** 是否需要授权（1是） */
    @Excel(name = "是否需要授权", readConverterExp = "1=是")
    private String isPermissions;
    public boolean isPermissions()
    {
        return isPermissions(this.isPermissions);
    }

    public boolean isPermissions(String isPermissions)
    {
        return isPermissions != null && StringUtils.equals("1", isPermissions);
    }

    /** 是否记录日志（1是） */
    @Excel(name = "是否记录日志", readConverterExp = "1=是")
    private String isLog;
    public boolean isLog()
    {
        return isLog(this.isLog);
    }

    public boolean isLog(String isLog)
    {
        return isLog != null && StringUtils.equals("1", isLog);
    }

    /** 是否生成字段（1是） */
    @Excel(name = "是否生成字段", readConverterExp = "1=是")
    private String isGen;

    public void setActionId(Long actionId)
    {
        this.actionId = actionId;
    }

    public Long getActionId()
    {
        return actionId;
    }
    public void setTableId(String tableId)
    {
        this.tableId = tableId;
    }

    public String getTableId()
    {
        return tableId;
    }
    public void setActionName(String actionName)
    {
        this.actionName = actionName;
    }

    public String getActionName()
    {
        return actionName;
    }
    public void setActionComment(String actionComment)
    {
        this.actionComment = actionComment;
    }

    public String getActionComment()
    {
        return actionComment;
    }
    public void setMouldName(String mouldName)
    {
        this.mouldName = mouldName;
    }

    public String getMouldName()
    {
        return mouldName;
    }
    public void setMouldComment(String mouldComment)
    {
        this.mouldComment = mouldComment;
    }

    public String getMouldComment()
    {
        return mouldComment;
    }
    public void setColumnIndex(int columnIndex)
    {
        this.columnIndex = columnIndex;
    }

    public int getColumnIndex()
    {
        return columnIndex;
    }
    public void setIsView(String isView)
    {
        this.isView = isView;
    }

    public String getIsView()
    {
        return isView;
    }

    public void setIsService(String isService)
    {
        this.isService = isService;
    }

    public String getIsService()
    {
        return isService;
    }
    public void setIsDao(String isDao)
    {
        this.isDao = isDao;
    }

    public String getIsDao()
    {
        return isDao;
    }

    public String getIsController() {
        return isController;
    }

    public void setIsController(String isController) {
        this.isController = isController;
    }

    public void setIsPermissions(String isPermissions)
    {
        this.isPermissions = isPermissions;
    }

    public String getIsPermissions()
    {
        return isPermissions;
    }
    public void setIsLog(String isLog)
    {
        this.isLog = isLog;
    }

    public String getIsLog()
    {
        return isLog;
    }
    public void setIsGen(String isGen)
    {
        this.isGen = isGen;
    }

    public String getIsGen()
    {
        return isGen;
    }


    /** 对应列序号 */
    @Excel(name = "对应列序号")
    private int columnIndex;

    public GenTableColumn getOperateColumn() {
        return operateColumn;
    }

    public void setOperateColumn(GenTableColumn operateColumn) {
        this.operateColumn = operateColumn;
        setColumnName(operateColumn.getColumnName());
        setColumnComment(operateColumn.getColumnComment());
        setColumnType(operateColumn.getColumnType());
        setJavaType(operateColumn.getJavaType());
        setJavaField(operateColumn.getJavaField());
    }

    private GenTableColumn operateColumn;

    /** 列名称 */
    private String columnName;

    /** 列描述 */
    private String columnComment;

    /** 列类型 */
    private String columnType;

    /** JAVA类型 */
    private String javaType;

    /** JAVA字段名 */
    private String javaField;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaField() {
        return javaField;
    }

    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("actionId", getActionId())
                .append("tableId", getTableId())
                .append("actionName", getActionName())
                .append("actionComment", getActionComment())
                .append("mouldName", getMouldName())
                .append("mouldComment", getMouldComment())
                .append("columnIndex", getColumnIndex())
                .append("isView", getIsView())
                .append("isPermissions", getIsPermissions())
                .append("isLog", getIsLog())
                .append("isGen", getIsGen())
                .toString();
    }
}
