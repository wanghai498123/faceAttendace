package com.ruoyi.generator.domain;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.apache.commons.lang3.ArrayUtils;
import com.ruoyi.common.constant.GenConstants;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;

/**
 * 业务表 gen_table
 * 
 * @author ruoyi
 */
public class GenTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long tableId;

    /** 表名称 */
    @NotBlank(message = "表名称不能为空")
    private String tableName;

    /** 表描述 */
    @NotBlank(message = "表描述不能为空")
    private String tableComment;

    /** 实体类名称(首字母大写) */
    @NotBlank(message = "实体类名称不能为空")
    private String className;

    /** 使用的模板（crud单表操作 tree树表操作） */
    private String tplCategory;

    /** 生成包路径 */
    @NotBlank(message = "生成包路径不能为空")
    private String packageName;

    /** 生成模块名 */
    @NotBlank(message = "生成模块名不能为空")
    private String moduleName;

    /** 生成业务名 */
    @NotBlank(message = "生成业务名不能为空")
    private String businessName;

    /** 生成功能名 */
    @NotBlank(message = "生成功能名不能为空")
    private String functionName;

    /** 生成作者 */
    @NotBlank(message = "作者不能为空")
    private String functionAuthor;

    /** 主键信息 */
    private GenTableColumn pkColumn;

    /** 表列信息 */
    @Valid
    private List<GenTableColumn> columns;

    /** 表列信息 */
    @Valid
    private List<GenTableJoinColumn> joinColumns;

    /** 表列信息 */
    @Valid
    private List<GenTableAction> actions;

    /** 其它生成选项 */
    private String options;

    /** 树编码字段 */
    private String treeCode;

    /** 树父编码字段 */
    private String treeParentCode;

    /** 树名称字段 */
    private String treeName;
    /*关联表全局变量*/
    private String jointplTableName;
    private String jointplTableColumnIdName;
    private String jointplTableColumnValueName;
    private String jointplHtmlType;
    private String jointplTableName1;
    private String jointplTableColumnIdName1;
    private String jointplTableColumnValueName1;
    private String jointplHtmlType1;
    private boolean isFlag=false;
    private boolean isTransactional=false;
    private boolean isSelect2=false;
    private boolean isListTree=false;

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public boolean isTransactional() {
        return isTransactional;
    }

    public void setTransactional(boolean transactional) {
        isTransactional = transactional;
    }

    public boolean isSelect2() {
        return isSelect2;
    }

    public void setSelect2(boolean select2) {
        isSelect2 = select2;
    }

    public boolean isListTree() {
        return isListTree;
    }

    public void setListTree(boolean listTree) {
        isListTree = listTree;
    }


    public String getJointplHtmlType() {
        return jointplHtmlType;
    }

    public void setJointplHtmlType(String jointplHtmlType) {
        this.jointplHtmlType = jointplHtmlType;
    }

    public String getJointplHtmlType1() {
        return jointplHtmlType1;
    }

    public void setJointplHtmlType1(String jointplHtmlType1) {
        this.jointplHtmlType1 = jointplHtmlType1;
    }

    public String getJointplTableName() {
        return jointplTableName;
    }

    public void setJointplTableName(String jointplTableName) {
        this.jointplTableName = jointplTableName;
    }

    public String getJointplTableColumnIdName() {
        return jointplTableColumnIdName;
    }

    public void setJointplTableColumnIdName(String jointplTableColumnIdName) {
        this.jointplTableColumnIdName = jointplTableColumnIdName;
    }

    public String getJointplTableColumnValueName() {
        return jointplTableColumnValueName;
    }

    public void setJointplTableColumnValueName(String jointplTableColumnValueName) {
        this.jointplTableColumnValueName = jointplTableColumnValueName;
    }

    public String getJointplTableName1() {
        return jointplTableName1;
    }

    public void setJointplTableName1(String jointplTableName1) {
        this.jointplTableName1 = jointplTableName1;
    }

    public String getJointplTableColumnIdName1() {
        return jointplTableColumnIdName1;
    }

    public void setJointplTableColumnIdName1(String jointplTableColumnIdName1) {
        this.jointplTableColumnIdName1 = jointplTableColumnIdName1;
    }

    public String getJointplTableColumnValueName1() {
        return jointplTableColumnValueName1;
    }

    public void setJointplTableColumnValueName1(String jointplTableColumnValueName1) {
        this.jointplTableColumnValueName1 = jointplTableColumnValueName1;
    }

    public Long getTableId()
    {
        return tableId;
    }

    public void setTableId(Long tableId)
    {
        this.tableId = tableId;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableComment()
    {
        return tableComment;
    }

    public void setTableComment(String tableComment)
    {
        this.tableComment = tableComment;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getTplCategory()
    {
        return tplCategory;
    }

    public void setTplCategory(String tplCategory)
    {
        this.tplCategory = tplCategory;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public String getBusinessName()
    {
        return businessName;
    }

    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    public String getFunctionName()
    {
        return functionName;
    }

    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }

    public String getFunctionAuthor()
    {
        return functionAuthor;
    }

    public void setFunctionAuthor(String functionAuthor)
    {
        this.functionAuthor = functionAuthor;
    }

    public GenTableColumn getPkColumn()
    {
        return pkColumn;
    }

    public void setPkColumn(GenTableColumn pkColumn)
    {
        this.pkColumn = pkColumn;
    }

    public List<GenTableColumn> getColumns()
    {
        return columns;
    }

    public void setColumns(List<GenTableColumn> columns)
    {
        this.columns = columns;
    }


    public List<GenTableAction> getActions() {
        return actions;
    }

    public void setActions(List<GenTableAction> actions) {
        this.actions = actions;
    }

    public String getOptions()
    {
        return options;
    }

    public void setOptions(String options)
    {
        this.options = options;
    }

    public String getTreeCode()
    {
        return treeCode;
    }

    public void setTreeCode(String treeCode)
    {
        this.treeCode = treeCode;
    }

    public String getTreeParentCode()
    {
        return treeParentCode;
    }

    public void setTreeParentCode(String treeParentCode)
    {
        this.treeParentCode = treeParentCode;
    }

    public String getTreeName()
    {
        return treeName;
    }

    public void setTreeName(String treeName)
    {
        this.treeName = treeName;
    }

    public boolean isTree()
    {
        return isTree(this.tplCategory);
    }

    public static boolean isTree(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_TREE, tplCategory);
    }

    public boolean isCrud()
    {
        return isCrud(this.tplCategory);
    }

    public static boolean isCrud(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_CRUD, tplCategory);
    }

    public boolean isSuperColumn(String javaField)
    {
        return isSuperColumn(this.tplCategory, javaField);
    }

    public static boolean isSuperColumn(String tplCategory, String javaField)
    {
        if (isTree(tplCategory))
        {
            return StringUtils.equalsAnyIgnoreCase(javaField,
                    ArrayUtils.addAll(GenConstants.TREE_ENTITY, GenConstants.BASE_ENTITY));
        }
        return StringUtils.equalsAnyIgnoreCase(javaField, GenConstants.BASE_ENTITY);
    }

    public List<GenTableJoinColumn> getJoinColumns() {
        return joinColumns;
    }

    public void setJoinColumns(List<GenTableJoinColumn> joinColumns) {
        this.joinColumns = joinColumns;
    }
}