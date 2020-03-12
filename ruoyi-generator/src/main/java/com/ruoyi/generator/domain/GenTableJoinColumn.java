package com.ruoyi.generator.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;

import javax.validation.constraints.NotBlank;

/**
 * 代码生成业务字段表 gen_table_column
 * 
 * @author ruoyi
 */
public class GenTableJoinColumn extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    //1一对一映射的展示方 2多对多映射的展示方 3多对多映射的非展示方 4多对多映射的中间关联方
    private int joinType=1;
    //自身数据
    private String columnName;
    private String javaField;
    private String javaType;
    private String htmlType="";
    //中间关联表属性
    private String joinTableName;
    private String joinClassName;
    private String joinModuleName;
    private String joinBusinessName;
    private String joinPackageName;
    /** 目标实体 */
    private String targetTableName;
    private String targetFunctionName;
    private String targetClassName;
    private String targetModuleName;
    private String targetBusinessName;
    private String targetPackageName;
    /** 目标实体关联列 */
    private String targetColumnName;
    private String targetJavaField;
    private String targetJavaType;
    /** 目标实体关联值 */
    private String targetValueColumnName;
    private String targetValueJavaField;
    private String targetValueJavaType;

    public String getTargetJavaType() {
        return targetJavaType;
    }

    public void setTargetJavaType(String targetJavaType) {
        this.targetJavaType = targetJavaType;
    }

    public String getTargetValueJavaType() {
        return targetValueJavaType;
    }

    public void setTargetValueJavaType(String targetValueJavaType) {
        this.targetValueJavaType = targetValueJavaType;
    }

    public int getJoinType() {
        return joinType;
    }

    public void setJoinType(int joinType) {
        this.joinType = joinType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getJavaField() {
        return javaField;
    }

    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
    public String getTargetFunctionName() {
        return targetFunctionName;
    }

    public void setTargetFunctionName(String targetFunctionName) {
        this.targetFunctionName = targetFunctionName;
    }

    public String getHtmlType() {
        return htmlType;
    }

    public void setHtmlType(String htmlType) {
        this.htmlType = htmlType;
    }

    public String getTargetTableName() {
        return targetTableName;
    }

    public void setTargetTableName(String targetTableName) {
        this.targetTableName = targetTableName;
    }

    public String getTargetClassName() {
        return targetClassName;
    }

    public void setTargetClassName(String targetClassName) {
        this.targetClassName = targetClassName;
    }

    public String getTargetModuleName() {
        return targetModuleName;
    }

    public void setTargetModuleName(String targetModuleName) {
        this.targetModuleName = targetModuleName;
    }

    public String getTargetBusinessName() {
        return targetBusinessName;
    }

    public void setTargetBusinessName(String targetBusinessName) {
        this.targetBusinessName = targetBusinessName;
    }

    public String getTargetPackageName() {
        return targetPackageName;
    }

    public void setTargetPackageName(String targetPackageName) {
        this.targetPackageName = targetPackageName;
    }

    public String getTargetColumnName() {
        return targetColumnName;
    }

    public void setTargetColumnName(String targetColumnName) {
        this.targetColumnName = targetColumnName;
    }

    public String getTargetJavaField() {
        return targetJavaField;
    }

    public void setTargetJavaField(String targetJavaField) {
        this.targetJavaField = targetJavaField;
    }

    public String getTargetValueColumnName() {
        return targetValueColumnName;
    }

    public void setTargetValueColumnName(String targetValueColumnName) {
        this.targetValueColumnName = targetValueColumnName;
    }

    public String getTargetValueJavaField() {
        return targetValueJavaField;
    }

    public void setTargetValueJavaField(String targetValueJavaField) {
        this.targetValueJavaField = targetValueJavaField;
    }



    public String getJoinTableName() {
        return joinTableName;
    }

    public void setJoinTableName(String joinTableName) {
        this.joinTableName = joinTableName;
    }

    public String getJoinClassName() {
        return joinClassName;
    }

    public void setJoinClassName(String joinClassName) {
        this.joinClassName = joinClassName;
    }

    public String getJoinModuleName() {
        return joinModuleName;
    }

    public void setJoinModuleName(String joinModuleName) {
        this.joinModuleName = joinModuleName;
    }

    public String getJoinBusinessName() {
        return joinBusinessName;
    }

    public void setJoinBusinessName(String joinBusinessName) {
        this.joinBusinessName = joinBusinessName;
    }

    public String getJoinPackageName() {
        return joinPackageName;
    }

    public void setJoinPackageName(String joinPackageName) {
        this.joinPackageName = joinPackageName;
    }
}