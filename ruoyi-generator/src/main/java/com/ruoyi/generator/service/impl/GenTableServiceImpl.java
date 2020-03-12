package com.ruoyi.generator.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.generator.domain.GenTableAction;
import com.ruoyi.generator.domain.GenTableJoinColumn;
import com.ruoyi.generator.mapper.GenTableActionMapper;
import com.ruoyi.generator.service.IGenTableActionService;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.directive.Foreach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.GenConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.generator.domain.GenTable;
import com.ruoyi.generator.domain.GenTableColumn;
import com.ruoyi.generator.mapper.GenTableColumnMapper;
import com.ruoyi.generator.mapper.GenTableMapper;
import com.ruoyi.generator.service.IGenTableService;
import com.ruoyi.generator.util.GenUtils;
import com.ruoyi.generator.util.VelocityInitializer;
import com.ruoyi.generator.util.VelocityUtils;

/**
 * 业务 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class GenTableServiceImpl implements IGenTableService
{
    private static final Logger log = LoggerFactory.getLogger(GenTableServiceImpl.class);

    @Autowired
    private GenTableMapper genTableMapper;

    @Autowired
    private GenTableColumnMapper genTableColumnMapper;

    @Autowired
    private GenTableActionMapper genTableActionMapper;

    @Autowired
    private IGenTableActionService genTableActionService;

    /**
     * 查询业务信息
     * 
     * @param id 业务ID
     * @return 业务信息
     */
    @Override
    public GenTable selectGenTableById(Long id)
    {
        GenTable genTable = genTableMapper.selectGenTableById(id);
        //转换要关联的表格

        GenTableAction genTableAction=new GenTableAction();
        genTableAction.setTableId(String.valueOf(genTable.getTableId()));
        genTable.setActions(genTableActionService.selectGenTableActionListByTableId(genTable));
        setTableFromOptions(genTable);
        return genTable;
    }

    /**
     * 查询业务列表
     * 
     * @param genTable 业务信息
     * @return 业务集合
     */
    @Override
    public List<GenTable> selectGenTableList(GenTable genTable)
    {
        return genTableMapper.selectGenTableList(genTable);
    }

    /**
     * 查询据库列表
     * 
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    public List<GenTable> selectDbTableList(GenTable genTable)
    {
        return genTableMapper.selectDbTableList(genTable);
    }

    /**
     * 查询据库列表
     * 
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    public List<GenTable> selectDbTableListByNames(String[] tableNames)
    {
        return genTableMapper.selectDbTableListByNames(tableNames);
    }

    /**
     * 修改业务
     * 
     * @param genTable 业务信息
     * @return 结果
     */
    @Override
    @Transactional
    public void updateGenTable(GenTable genTable)
    {
        genTable.getParams().put("jointplTableName",genTable.getJointplTableName());
        genTable.getParams().put("jointplTableColumnIdName",genTable.getJointplTableColumnIdName());
        genTable.getParams().put("jointplTableColumnValueName",genTable.getJointplTableColumnValueName());
        genTable.getParams().put("jointplHtmlType",genTable.getJointplHtmlType());

        genTable.getParams().put("jointplTableName1",genTable.getJointplTableName1());
        genTable.getParams().put("jointplTableColumnIdName1",genTable.getJointplTableColumnIdName1());
        genTable.getParams().put("jointplTableColumnValueName1",genTable.getJointplTableColumnValueName1());
        genTable.getParams().put("jointplHtmlType1",genTable.getJointplHtmlType1());
        String options = JSON.toJSONString(genTable.getParams());
        genTable.setOptions(options);
        int row = genTableMapper.updateGenTable(genTable);
        if (row > 0)
        {
            GenTableColumn ttt=new GenTableColumn();
            ttt.setTableId(genTable.getTableId());
            List<GenTableColumn> ogenTableColumn=genTableColumnMapper.selectGenTableColumnListByTableId(ttt);
            List<GenTableAction> ogenTableActions=genTableActionMapper.selectGenTableColumnListByTableId(genTable.getTableId());
            //保存列信息
            for (GenTableColumn cenTableColumn : genTable.getColumns())
            {
                genTableColumnMapper.updateGenTableColumn(cenTableColumn);

                //更新检查唯一方法
                for (GenTableColumn o: ogenTableColumn){
                    if(o.getColumnId().longValue()==cenTableColumn.getColumnId().longValue()) {
                        if(o.isUnique()!=cenTableColumn.isUnique())
                        {
                            if(cenTableColumn.isUnique())//添加方法
                            {
                                GenTableAction genTableAction=parserGenTableAction(genTable.getTableId(),"check"+StringUtils.capitalize(cenTableColumn.getJavaField())+"Unique","检查是否唯一","Unique","检查",cenTableColumn.getSort()-1);
                                genTableActionMapper.insertGenTableAction(genTableAction);
                            }
                            else//删除方法
                            {
                                for (GenTableAction a: ogenTableActions){
                                    if(a.getColumnIndex()==cenTableColumn.getSort()-1)
                                    {
                                        genTableActionMapper.deleteGenTableActionById(a.getActionId());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
            //保存方法信息
            if(genTable.getActions()!=null&&genTable.getActions().size()>0) {
                for (GenTableAction genTableAction : genTable.getActions()) {
                    if (genTableAction.getActionId() != -1)
                        genTableActionService.updateGenTableAction(genTableAction);
                    else {
                        genTableAction.setIsGen("0");
                        genTableAction.setTableId(String.valueOf(genTable.getTableId()));
                        genTableActionService.insertGenTableAction(genTableAction);
                    }
                }
            }

        }
    }

    public GenTableAction parserGenTableAction(Long tableId,String actionName,String actionComment,String mouldName,String mouldComment,int columnIndex) {
        GenTableAction genTableAction=new GenTableAction();
        genTableAction.setTableId(String.valueOf(tableId));
        genTableAction.setActionName(actionName);
        genTableAction.setActionComment(actionComment);
        genTableAction.setMouldComment(mouldComment);
        genTableAction.setMouldName(mouldName);
        genTableAction.setColumnIndex(columnIndex);
        return genTableAction;
    }

    /**
     * 删除业务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public void deleteGenTableByIds(String ids)
    {
        for (long id : Convert.toLongArray(ids))
        {
            GenTable table = genTableMapper.selectGenTableById(id);
            List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
            for (String template : templates)
            {
                if (!template.contains("sql.vm")) {
                    FileUtils.deleteFile(VelocityUtils.getFileName(template, table));
                }
            }
        }
        genTableMapper.deleteGenTableByIds(Convert.toLongArray(ids));
        genTableColumnMapper.deleteGenTableColumnByIds(Convert.toLongArray(ids));
        genTableActionMapper.deleteGenTableActionByIds(Convert.toLongArray(ids));
    }

    /**
     * 导入表结构,如果不存在就保存，如果存在就插入不存在的列
     *
     * @param tableList 导入表列表
     * @param operName 操作人员
     */
    @Override
    @Transactional
    public void importGenTable(List<GenTable> tableList, String operName)
    {
        for (GenTable table : tableList)
        {
            try
            {
                int row=1;
                List<GenTableColumn> genTableColumns=new ArrayList<GenTableColumn>();
                String tableName = table.getTableName();
                GenTable genTable=  genTableMapper.selectGenTableByName(tableName);
                List<GenTableColumn> genDbTableColumns = genTableColumnMapper.selectDbTableColumnsByName(tableName);
                if(genTable==null) {//插入表格信息
                    GenUtils.initTable(table, operName);
                    //插入多对多关联，
                    initTableJion(genDbTableColumns,table);
                    row = genTableMapper.insertGenTable(table);
                    //插入基础的方法信息
                }
                else
                {//已经有数据了，对比列数据是否修改了。
                    table=genTable;
                    GenTableColumn genTableColumn = new GenTableColumn();
                    genTableColumn.setTableId(table.getTableId());
                    genTableColumns=genTableColumnMapper.selectGenTableColumnListByTableId(genTableColumn);
                }
                if (row > 0)// 保存列信息
                {
                    for (GenTableColumn dbColumn : genDbTableColumns)
                    {
                        //过滤已经存在的列
                        for (GenTableColumn column : genTableColumns)
                        {
                            if(dbColumn.getColumnName().equals(column.getColumnName()))
                            {
                                row=0;
                                break;
                            }
                        }
                        if(row>0) {
                            GenUtils.initColumnField(dbColumn, table);
                            genTableColumnMapper.insertGenTableColumn(dbColumn);
                        }
                        row=1;
                    }
                }
            }
            catch (Exception e)
            {
                log.error("表名 " + table.getTableName() + " 导入失败：", e);
            }
        }
    }

    public boolean  initTableJion(List<GenTableColumn> genDbTableColumns,GenTable genTable) {
        //插入树模板
        String myId = "";
        //插入join模板
        String[] tables = genTable.getTableName().split("_");
        String[] joinTableNames = {genTable.getTableName().replace("_" + tables[tables.length - 1], ""), tables[0] + "_" + tables[tables.length - 1]};
        List<GenTable> joinTables = selectDbTableListByNames(joinTableNames);
        boolean isTree = false;
        if (joinTables.size() == 2) {
            genTable.setTplCategory("join");
            for (int i = 0; i < joinTableNames.length; i++) {
                List<GenTableColumn> dbTableColumns = genTableColumnMapper.selectDbTableColumnsByName(joinTableNames[i]);
                for (GenTableColumn genTableColumn : dbTableColumns) {
                    if (genTableColumn.isPk())
                        myId = genTableColumn.getColumnName();

                    if (genTableColumn.getColumnName().equals("parent_id")) {
                        isTree = true;
                    }
                }
                genTable.getParams().put((i == 0 ? "jointplTableName" : "jointplTableName1"), joinTableNames[i]);
                genTable.getParams().put((i == 0 ? "jointplTableColumnIdName" : "jointplTableColumnIdName1"), myId);
                genTable.getParams().put((i == 0 ? "jointplTableColumnValueName" : "jointplTableColumnValueName1"), myId.replace("_id", "_name"));
            }
            genTable.getParams().put("jointplHtmlType1", "");
            if (isTree) {
                genTable.getParams().put("jointplHtmlType", "checktree");
            } else {
                genTable.getParams().put("jointplHtmlType", "checkbox");
            }
            String options = JSON.toJSONString(genTable.getParams());
            genTable.setOptions(options);
            return true;
        }
        //插入一对一模板
        for (GenTableColumn genTableColumn : genDbTableColumns) {
            if (genTableColumn.isPk()) {
                myId = genTableColumn.getColumnName();
                continue;
            }

            if (genTableColumn.getColumnName().equals("parent_id")) {
                genTable.setTplCategory("tree");
                genTable.getParams().put("treeName", myId.replace("_id", "_name"));
                genTable.getParams().put("treeParentCode", "parent_id");
                genTable.getParams().put("treeCode", myId);
                String options = JSON.toJSONString(genTable.getParams());
                genTable.setOptions(options);
            } else if (genTableColumn.getColumnName().endsWith("_id")) {
                GenTable gt = new GenTable();
                gt.setTableName(genTableColumn.getColumnName().substring(0, genTableColumn.getColumnName().length() - 3));
                joinTables = selectDbTableList(gt);
                if (joinTables.size() > 0) {
                    for (GenTable genTable1 : joinTables) {
                        List<GenTableColumn> dbTableColumns = genTableColumnMapper.selectDbTableColumnsByName(genTable1.getTableName());
                        for (GenTableColumn tc : dbTableColumns) {
                            if (tc.isPk()&&tc.getColumnName().equals(genTableColumn.getColumnName())) {
                                genTableColumn.setHtmlType("select");
                                genTableColumn.setDictType(genTable1.getTableName()+","+tc.getColumnName()+","+tc.getColumnName().replace("_id", "_name"));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }




    /**
     * 预览代码
     * 
     * @param tableId 表编号
     * @return 预览数据列表
     */
    public Map<String, String> previewCode(Long tableId)
    {
        Map<String, String> dataMap = new LinkedHashMap<>();
        // 查询表信息
        GenTable table = selectGenTableById(tableId);
        // 查询列信息
        List<GenTableColumn> columns = table.getColumns();
        setPkColumn(table, columns);
        setJoinTableColumn(table, columns);
        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates)
        {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            dataMap.put(template, sw.toString());
        }
        return dataMap;
    }

    /**
     * 生成代码
     *
     * @param tableName 表名称
     * @return 数据
     */
    @Override
    public Map<String, String> generatorCode(String tableName)
    {
        return generatorCode(tableName, null);
    }

    /**
     * 批量生成代码
     *
     * @param tableNames 表数组
     * @return 数据
     */
    @Override
    public Map<String, String> generatorCode(String[] tableNames)
    {
        Map<String, String> dataMap = new LinkedHashMap<>();
        for (String tableName : tableNames)
        {
            dataMap.putAll(generatorCode(tableName, null));
        }
        return dataMap;
    }

    /**
     * 查询表信息并生成代码
     */
    private Map<String, String> generatorCode(String tableName, ZipOutputStream zip)
    {
        Map<String, String> dataMap = new LinkedHashMap<>();
        // 查询表信息
        GenTable table = genTableMapper.selectGenTableByName(tableName);
        GenTableAction genTableAction=new GenTableAction();
        genTableAction.setTableId(String.valueOf(table.getTableId()));
        table.setActions(genTableActionService.selectGenTableActionListByTableId(table));
        // 查询列信息
        List<GenTableColumn> columns = table.getColumns();
        setPkColumn(table, columns);
        setJoinTableColumn(table, columns);

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates)
        {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            try
            {
                // 添加到zip
//                zip.putNextEntry(new ZipEntry(VelocityUtils.getFileName(template, table)));
//                IOUtils.write(sw.toString(), zip, Constants.UTF8);
//                IOUtils.closeQuietly(sw);
//                zip.closeEntry();
                if (!template.contains("sql.vm"))
                {
                    //保存文件到项目的对应位置
                    FileUtils.write(VelocityUtils.getFileName(template, table),sw.toString());
                }
                else
                {
                    dataMap.put(VelocityUtils.getFileName(template, table),sw.toString());
                }

            }
            catch (Exception e)
            {
                log.error("渲染模板失败，表名：" + table.getTableName(), e);
                return null;
            }
        }
        //修改生成状态
        for (GenTableColumn c:columns) {
            c.setIsGen("1");
            genTableColumnMapper.updateIsGen(c);
        }

        List<GenTableAction> actions = table.getActions();
        for (GenTableAction a:actions) {
            a.setIsGen("1");
            genTableActionService.updateGenTableAction(a);
        }
        return dataMap;
    }


    /**
     * 查询表信息并生成代码
     */
    public Map<String, String> editTableColumnCode(long editColumnID,boolean isDelete)
    {
        Map<String, String> dataMap = new LinkedHashMap<>();
        GenTableColumn editColumn=genTableColumnMapper.selectDbTableColumnById(editColumnID);
        // 查询表信息
        GenTable table = selectGenTableById(editColumn.getTableId());
        // 查询列信息
        List<GenTableColumn> columns = table.getColumns();
        setPkColumn(table, columns);
        setJoinTableColumn(table, columns);

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);
        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        //Collections.reverse(columns);反序没有意义，还导致不一致
        for (String template : templates)
        {
            String src="";
            String replace="";
            try
            {
                if(!isDelete) {
                    // 渲染模板
                    StringWriter sw = new StringWriter();
                    Template tpl = Velocity.getTemplate(template, Constants.UTF8);
                    tpl.merge(context, sw);
                    replace = sw.toString();
                }

                if (template.contains("vm/java/domain.java.vm"))
                {
                    src=FileUtils.read(VelocityUtils.getFileName(template, table));
                    src=replaceFirst(columns,editColumn,1,src,replace,"[^;]*private.*%s[^;]*;");
                    src=replaceFirst(columns,editColumn,1,src,replace,"[^};]*return.*%s[^}]*}");
                    src=replaceFirst(columns,editColumn,1,src,replace,"[^};]*this.%s[^}]*}");
                    src=replaceFirst(columns,editColumn,1,src,replace,"[^.]*\"%s\"[^.]*.");
                    FileUtils.write(VelocityUtils.getFileName(template, table),src);
                }
                else if(template.contains("vm/xml/mapper.xml.vm"))
                {
                    src=FileUtils.read(VelocityUtils.getFileName(template, table));
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s-->",editColumn.getColumnName(),"columnBegin");
                    src=replaceFirst(columns,editColumn,0,src,replace,", %s");
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s_select-->",editColumn.getColumnName(),"columnBegin");
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s_insert1-->",editColumn.getColumnName(),"columnBegin");
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s_insert2-->",editColumn.getColumnName(),"columnBegin");
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s_update-->",editColumn.getColumnName(),"columnBegin");
                    FileUtils.write(VelocityUtils.getFileName(template, table),src);
                }
                else if(template.contains("vm/html/list.html.vm")||template.contains("vm/html/list-tree.html.vm"))
                {
                    src=FileUtils.read(VelocityUtils.getFileName(template, table));
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s-->",editColumn.getJavaField(),"columnBegin");
                    src=replaceFirst(src,replace,"\\*/[^~]*/\\*\\*~%s\\*/",editColumn.getJavaField(),"columnBegin");
                    src=replaceFirst(src,replace,"\\*/[^~]*/\\*\\*~%s\\*/","dictInit","");
                    FileUtils.write(VelocityUtils.getFileName(template, table),src);
                }
                else if(template.contains("vm/html/add.html.vm"))
                {
                    src=FileUtils.read(VelocityUtils.getFileName(template, table));
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s-->",editColumn.getJavaField(),"columnBegin");
                    src=replaceFirst(src,replace,"\\*/[^~]*/\\*\\*~%s\\*/","validate","");
                    FileUtils.write(VelocityUtils.getFileName(template, table),src);
                }
                else if(template.contains("vm/html/edit.html.vm"))
                {
                    src=FileUtils.read(VelocityUtils.getFileName(template, table));
                    src=replaceFirst(src,replace,"-->[^~]*<!--~%s-->",editColumn.getJavaField(),"columnBegin");
                    src=replaceFirst(src,replace,"\\*/[^~]*/\\*\\*~%s\\*/","validate","");
                    FileUtils.write(VelocityUtils.getFileName(template, table),src);
                }

                if(!isDelete)
                    editColumn.setIsGen("1");
                else
                    editColumn.setIsGen("0");

                genTableColumnMapper.updateGenTableColumn(editColumn);
            }
            catch (Exception e)
            {
                log.error("渲染模板失败，表名：" + table.getTableName(), e);
                throw e;
            }
        }

        return dataMap;
    }

    public Map<String, String> editTableActionCode(long editActionID,boolean isDelete) {
        Map<String, String> dataMap = new LinkedHashMap<>();
        GenTableAction editAction = genTableActionMapper.selectDbTableActionById(editActionID);
        // 查询表信息
        GenTable table = selectGenTableById(Long.valueOf(editAction.getTableId()));
        // 查询列信息
        List<GenTableColumn> columns = table.getColumns();
        setPkColumn(table, columns);
        setJoinTableColumn(table, columns);
        table.setActions(genTableActionService.selectGenTableActionListByTableId(table));

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);
        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());

        //生成视图
        for (String template : templates) {
            String src = "";
            String replace = "";
            try {
                if (!isDelete) {
                    // 渲染模板
                    StringWriter sw = new StringWriter();
                    Template tpl = Velocity.getTemplate(template, Constants.UTF8);
                    tpl.merge(context, sw);
                    replace = sw.toString();
                }

                if (template.contains("vm/java/controller.java.vm")) {
                    src = FileUtils.read(VelocityUtils.getFileName(template, table));
                    src = replaceFirst(src, replace, "\\*/[^~]*/\\*\\*~%s\\*/", editAction.getActionName(), "actionBegin");
                    FileUtils.write(VelocityUtils.getFileName(template, table), src);
                } else if (template.contains("vm/java/service.java.vm")) {
                    src = FileUtils.read(VelocityUtils.getFileName(template, table));
                    src = replaceFirst(src, replace, "\\*/[^~]*/\\*\\*~%s\\*/", editAction.getActionName(), "actionBegin");
                    FileUtils.write(VelocityUtils.getFileName(template, table), src);
                } else if (template.contains("vm/java/serviceImpl.java.vm")) {
                    src = FileUtils.read(VelocityUtils.getFileName(template, table));
                    src = replaceFirst(src, replace, "\\*/[^~]*/\\*\\*~%s\\*/", editAction.getActionName(), "actionBegin");
                    FileUtils.write(VelocityUtils.getFileName(template, table), src);
                } else if (template.contains("vm/java/mapper.java.vm")) {
                    src = FileUtils.read(VelocityUtils.getFileName(template, table));
                    src = replaceFirst(src, replace, "\\*/[^~]*/\\*\\*~%s\\*/", editAction.getActionName(), "actionBegin");
                    FileUtils.write(VelocityUtils.getFileName(template, table), src);
                } else if (template.contains("vm/xml/mapper.xml.vm")) {
                    src = FileUtils.read(VelocityUtils.getFileName(template, table));
                    src = replaceFirst(src, replace, "\\*/[^~]*/\\*\\*~%s\\*/", editAction.getActionName(), "actionBegin");
                    FileUtils.write(VelocityUtils.getFileName(template, table), src);
                } else if (template.contains("vm/html/list.html.vm")) {
                    String filePath=VelocityUtils.getFileName(template, table);
                    filePath=filePath.replace(table.getBusinessName()+".html","to"+StringUtils.capitalize(editAction.getActionName())+".html");
                    if(editAction.getIsView()!=null&&editAction.getIsView().equals("1"))
                    {
                        if(!isDelete) {
                            FileUtils.write(filePath, replace);
                        }
                    } else
                    {
                        FileUtils.deleteFile(filePath);
                    }
                }

                if (!isDelete)
                    editAction.setIsGen("1");
                else
                    editAction.setIsGen("0");

                genTableActionService.updateGenTableAction(editAction);

            } catch (Exception e) {
                log.error("渲染模板失败，表名：" + table.getTableName(), e);
                throw e;
            }
        }
        return dataMap;
    }


    private String replaceFirst(String src,String replace,String patternFormat,String pName,String bName)
    {
        Pattern ep=null;
        Matcher nm=null;
        StringBuilder sb = new StringBuilder(src);
        Pattern p=Pattern.compile(String.format(patternFormat,pName));
        Matcher sm=p.matcher(src);
        int offer=patternFormat.indexOf("~")-2;

        if(sm.find()){
            if(!replace.equals(""))//修改
            {
                nm=p.matcher(replace);
                if(nm.find())
                {
                    sb.replace(sm.start(),sm.end(),nm.group().toString());
                }
                else//新文件中没有删除
                {
                   sb.replace(sm.start()+offer,sm.end(),"");
                }
            }
            else//删除
            {
                if(!bName.equals(""))
                    sb.replace(sm.start()+offer,sm.end(),"");
            }
        }
        else
        {
            if(!replace.equals(""))//插入
            {
                    ep = Pattern.compile(String.format(patternFormat, bName));//在原来的文件中找存在的列找到一个可以用插入的地方
                    sm = ep.matcher(src);
                    if (sm.find()) {//在原来的文件中找到一个存在的列
                        nm = p.matcher(replace);
                        if (nm.find()) {//在新文件中找到这个列对应的内容，用原来的列加上新的列替换原来的列
                            sb.replace(sm.start(),sm.end(),sm.group()+nm.group().substring(offer));
                        }
                    }
            }
        }
        return sb.toString();
    }
    private String replaceFirst(List<GenTableColumn> columns,GenTableColumn editColumn,int columnType,String src,String replace,String patternFormat)
    {
        Pattern ep=null;
        Matcher nm=null;
        Pattern p=null;
        StringBuilder sb = new StringBuilder(src);
        String pName=editColumn.getColumnName();
        if(columnType==1) {
            pName = editColumn.getJavaField();
        }
        p = Pattern.compile(String.format(patternFormat, pName));
        Matcher sm=p.matcher(src);

        if(sm.find()){
            if(!replace.equals(""))//修改
            {
                nm=p.matcher(replace);
                if(nm.find())
                {
                    sb.replace(sm.start(),sm.end(),nm.group().toString());
                }
                else//新文件中没有删除
                {
                     sb.replace(sm.start(),sm.end(),"");
                }
            }
            else//删除
            {
                 sb.replace(sm.start(),sm.end(),"");
            }
        }
        else
        {
            if(!replace.equals(""))//插入
            {
                for(int i=editColumn.getSort()-2;i>-1;i--)//在原来的文件中循环找存在的列找到一个可以用插入的地方
                {
                    GenTableColumn genTableColumn=  columns.get(i);
                    String eName=genTableColumn.getColumnName();
                    if(columnType==1) {
                        eName = genTableColumn.getJavaField();
                    }
                    ep = Pattern.compile(String.format(patternFormat, eName));
                    sm = ep.matcher(src);

                    if (sm.find()) {//在原来的文件中找到一个存在的列
                        nm = p.matcher(replace);
                        if (nm.find()) {//在新文件中找到这个列对应的内容，用原来的列加上新的列替换原来的列
                                sb.replace(sm.start(),sm.end(),sm.group() + nm.group());
                        }
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 修改保存参数校验
     * 
     * @param genTable 业务信息
     */
    public void validateEdit(GenTable genTable)
    {
        if (GenConstants.TPL_TREE.equals(genTable.getTplCategory()))
        {
            String options = JSON.toJSONString(genTable.getParams());
            JSONObject paramsObj = JSONObject.parseObject(options);
            if (StringUtils.isEmpty(paramsObj.getString(GenConstants.TREE_CODE)))
            {
                throw new BusinessException("树编码字段不能为空");
            }
            else if (StringUtils.isEmpty(paramsObj.getString(GenConstants.TREE_PARENT_CODE)))
            {
                throw new BusinessException("树父编码字段不能为空");
            }
            else if (StringUtils.isEmpty(paramsObj.getString(GenConstants.TREE_NAME)))
            {
                throw new BusinessException("树名称字段不能为空");
            }
        }
    }

    /**
     * 设置主键列信息
     *
     * @param columns 业务字段列表
     */
    public void setPkColumn(GenTable table, List<GenTableColumn> columns)
    {
        for (GenTableColumn column : columns)
        {
            if (column.isPk())
            {
                table.setPkColumn(column);
                break;
            }
        }
        if (StringUtils.isNull(table.getPkColumn()))
        {
            table.setPkColumn(columns.get(0));
        }
    }

    /**
     * 设置主键列信息
     *
     * @param columns 业务字段列表
     */
    public void setJoinTableColumn(GenTable table, List<GenTableColumn> columns)
    {
        GenTableJoinColumn genTableJoinColumn = null;
        List<GenTableJoinColumn> joinColumns = new ArrayList<>();
        for (GenTableColumn column : columns)
        {
            if(column.getDictType().indexOf(",")!=-1)
            {
                String[] temp=column.getDictType().split(",");
                //设置目标对象属性
                genTableJoinColumn=getTargetGenTableJoinColumnByName(temp[0],temp.length>1?temp[1]:"",temp.length>2?temp[2]:"");
                genTableJoinColumn.setColumnName(column.getColumnName());
                genTableJoinColumn.setJavaField(column.getJavaField());
                genTableJoinColumn.setJavaType(column.getJavaType());
                genTableJoinColumn.setJoinType(1);
                genTableJoinColumn.setHtmlType(column.getHtmlType());
                column.setIsList("0");
                column.setIsInsert("0");
                column.setIsEdit("0");
                joinColumns.add(genTableJoinColumn);
//                GenTable targettable=genTableMapper.selectGenTableByName(temp[0]);
//                setPkColumn(targettable,targettable.getColumns());
//
//                column.setTargetBusinessName(targettable.getBusinessName());
//                column.setTargetClassName(targettable.getClassName());
//                column.setTargetPackageName(targettable.getPackageName());
//                column.setTargetModuleName(targettable.getModuleName());
//                if(temp.length==1)//不指定列设置默认值，目标对象对应的id列和名称列，在有中间映射表中这个设置是没有用的
//                {
//                    column.setTargetColumnName(targettable.getPkColumn().getColumnName());
//                    column.setTargetValueColumnName(targettable.getPkColumn().getColumnName().replace("_id","_name"));
//                }
//                else {
//                    column.setTargetColumnName(temp[1]);
//                    column.setTargetValueColumnName(temp[2]);
//                }
//
//                //查找列对应的其他属性
//                for (GenTableColumn tcolumn : targettable.getColumns())
//                {
//                    if(tcolumn.getColumnName().equals(column.getTargetColumnName()))
//                    {
//                        column.setTargetJavaField(tcolumn.getJavaField());
//                        break;
//                    }
//                }
//                for (GenTableColumn tcolumn : targettable.getColumns())
//                {
//                    if(tcolumn.getColumnName().equals(column.getTargetValueColumnName()))
//                    {
//                        column.setTargetValueJavaField(tcolumn.getJavaField());
//                        column.setColumnComment(tcolumn.getColumnComment());
//                        break;
//                    }
//                }

            }
        }
        table.setJoinColumns(joinColumns);
        setJoinTable(table,columns);
    }

    public void setJoinTable(GenTable table, List<GenTableColumn> columns) {
        GenTableJoinColumn genTableJoinColumn = null;
        if (table.getTplCategory().equals("join"))//中间关联表
        {
            setTableFromOptions(table);
            genTableJoinColumn=getTargetGenTableJoinColumnByName(table.getJointplTableName(), table.getJointplTableColumnIdName(), table.getJointplTableColumnValueName());
            changeJoinGenTableJoinColumn(genTableJoinColumn,table.getJointplTableName1(), table.getJointplTableColumnIdName1(), table.getJointplTableColumnValueName1());
            table.getJoinColumns().add(genTableJoinColumn);
            genTableJoinColumn=getTargetGenTableJoinColumnByName(table.getJointplTableName1(), table.getJointplTableColumnIdName1(), table.getJointplTableColumnValueName1());
            changeJoinGenTableJoinColumn(genTableJoinColumn,table.getJointplTableName(), table.getJointplTableColumnIdName(), table.getJointplTableColumnValueName());
            table.getJoinColumns().add(genTableJoinColumn);
        } else {
            List<GenTable> genTables = genTableMapper.selectGenTableAll();
            for (GenTable joinTable : genTables) {
                if (joinTable.getTplCategory().equals("join")) {
                    setTableFromOptions(joinTable);
                    if (joinTable.getJointplTableName().equals(table.getTableName())) {
                        genTableJoinColumn = getTargetGenTableJoinColumnByName(joinTable.getJointplTableName1(), joinTable.getJointplTableColumnIdName1(), joinTable.getJointplTableColumnValueName1());
                        genTableJoinColumn =changeGenTableJoinColumn(genTableJoinColumn,table,joinTable,joinTable.getJointplTableColumnIdName(),joinTable.getJointplHtmlType());
                    } else if (joinTable.getJointplTableName1().equals(table.getTableName())) {
                        genTableJoinColumn = getTargetGenTableJoinColumnByName(joinTable.getJointplTableName(), joinTable.getJointplTableColumnIdName(), joinTable.getJointplTableColumnValueName());
                        genTableJoinColumn =changeGenTableJoinColumn(genTableJoinColumn,table,joinTable,joinTable.getJointplTableColumnIdName1(),joinTable.getJointplHtmlType1());
                    }
                    if(genTableJoinColumn!=null)
                        table.getJoinColumns().add(genTableJoinColumn);
                }
            }
        }
    }

    public GenTableJoinColumn getTargetGenTableJoinColumnByName(String targetTableName,String columnIdName,String columnValueName)
    {
        GenTable targettable=genTableMapper.selectGenTableByName(targetTableName);
        setPkColumn(targettable,targettable.getColumns());
        GenTableJoinColumn genTableJoinColumn=new GenTableJoinColumn();
        genTableJoinColumn.setJoinType(4);
        genTableJoinColumn.setTargetBusinessName(targettable.getBusinessName());
        genTableJoinColumn.setTargetClassName(targettable.getClassName());
        genTableJoinColumn.setTargetModuleName(targettable.getModuleName());
        genTableJoinColumn.setTargetPackageName(targettable.getPackageName());
        genTableJoinColumn.setTargetTableName(targettable.getTableName());
        genTableJoinColumn.setTargetFunctionName(targettable.getFunctionName());
        if(columnIdName.equals(""))
        {
            genTableJoinColumn.setTargetColumnName(targettable.getPkColumn().getColumnName());
            genTableJoinColumn.setTargetJavaField(targettable.getPkColumn().getJavaField());
            genTableJoinColumn.setTargetJavaType(targettable.getPkColumn().getJavaType());
            genTableJoinColumn.setColumnName(targettable.getPkColumn().getColumnName());
        }else{
            for (GenTableColumn tcolumn : targettable.getColumns())
            {
                if(tcolumn.getColumnName().equals(columnIdName))
                {
                    genTableJoinColumn.setTargetColumnName(tcolumn.getColumnName());
                    genTableJoinColumn.setTargetJavaField(tcolumn.getJavaField());
                    genTableJoinColumn.setTargetJavaType(tcolumn.getJavaType());
                    genTableJoinColumn.setColumnName(tcolumn.getColumnName());
                }
            }
        }
        if(columnValueName.equals(""))
        {
            columnValueName=targettable.getPkColumn().getColumnName().replace("_id","_name");
        }
        for (GenTableColumn tcolumn : targettable.getColumns())
        {
            if(tcolumn.getColumnName().equals(columnValueName))
            {
                genTableJoinColumn.setTargetValueColumnName(tcolumn.getColumnName());
                genTableJoinColumn.setTargetValueJavaField(tcolumn.getJavaField());
                genTableJoinColumn.setTargetValueJavaType(tcolumn.getJavaType());
            }
        }
        return genTableJoinColumn;
    }

    public GenTableJoinColumn changeGenTableJoinColumn(GenTableJoinColumn genTableJoinColumn,GenTable table,GenTable joinTable,String columnIdName,String jointplHtmlType)
    {
        if(jointplHtmlType.equals("")) {
            genTableJoinColumn.setJoinType(3);
        }else{
            genTableJoinColumn.setJoinType(2);
            genTableJoinColumn.setHtmlType(jointplHtmlType);
            if(jointplHtmlType.equals("select2"))
                table.setSelect2(true);
        }

        if(columnIdName.equals(""))
        {
            genTableJoinColumn.setColumnName(table.getPkColumn().getColumnName());
            genTableJoinColumn.setJavaField(table.getPkColumn().getJavaField());
            genTableJoinColumn.setJavaType(table.getPkColumn().getJavaType());
        }else{
            for (GenTableColumn tcolumn : table.getColumns())
            {
                if(tcolumn.getColumnName().equals(columnIdName))
                {
                    genTableJoinColumn.setTargetColumnName(tcolumn.getColumnName());
                    genTableJoinColumn.setJavaField(tcolumn.getJavaField());
                    genTableJoinColumn.setJavaType(tcolumn.getJavaType());
                }
            }
        }
        genTableJoinColumn.setJoinBusinessName(joinTable.getBusinessName());
        genTableJoinColumn.setJoinClassName(joinTable.getClassName());
        genTableJoinColumn.setJoinModuleName(joinTable.getModuleName());
        genTableJoinColumn.setJoinPackageName(joinTable.getPackageName());
        genTableJoinColumn.setJoinTableName(joinTable.getTableName());
        genTableJoinColumn.setTargetFunctionName(joinTable.getFunctionName());
        return genTableJoinColumn;
    }

    public GenTableJoinColumn changeJoinGenTableJoinColumn(GenTableJoinColumn genTableJoinColumn,String targetTableName,String columnIdName,String columnValueName)
    {
        GenTable targettable=genTableMapper.selectGenTableByName(targetTableName);
        if(columnIdName.equals(""))
        {
            genTableJoinColumn.setColumnName(targettable.getPkColumn().getColumnName());
            genTableJoinColumn.setJavaField(targettable.getPkColumn().getJavaField());
            genTableJoinColumn.setJavaType(targettable.getPkColumn().getJavaType());
        }else{
            for (GenTableColumn tcolumn : targettable.getColumns())
            {
                if(tcolumn.getColumnName().equals(columnIdName))
                {
                    genTableJoinColumn.setColumnName(tcolumn.getColumnName());
                    genTableJoinColumn.setJavaField(tcolumn.getJavaField());
                    genTableJoinColumn.setJavaType(tcolumn.getJavaType());
                }
            }
        }
        return genTableJoinColumn;
    }

    /**
     * 设置代码生成其他选项值
     * 
     * @param genTable 设置后的生成对象
     */
    public void setTableFromOptions(GenTable genTable)
    {
        JSONObject paramsObj = JSONObject.parseObject(genTable.getOptions());
        if (StringUtils.isNotNull(paramsObj))
        {
            String treeCode = paramsObj.getString(GenConstants.TREE_CODE);
            String treeParentCode = paramsObj.getString(GenConstants.TREE_PARENT_CODE);
            String treeName = paramsObj.getString(GenConstants.TREE_NAME);
            genTable.setTreeCode(treeCode);
            genTable.setTreeParentCode(treeParentCode);
            genTable.setTreeName(treeName);

            if(paramsObj.getString("jointplTableName")!=null) {
                String jointplTableName = paramsObj.getString("jointplTableName");
                genTable.setJointplTableName(jointplTableName);
                String jointplTableColumnIdName = paramsObj.getString("jointplTableColumnIdName");
                genTable.setJointplTableColumnIdName(jointplTableColumnIdName);
                String jointplTableColumnValueName = paramsObj.getString("jointplTableColumnValueName");
                genTable.setJointplTableColumnValueName(jointplTableColumnValueName);
                String jointplHtmlType = paramsObj.getString("jointplHtmlType");
                genTable.setJointplHtmlType(jointplHtmlType);
                String jointplTableName1 = paramsObj.getString("jointplTableName1");
                genTable.setJointplTableName1(jointplTableName1);
                String jointplTableColumnIdName1 = paramsObj.getString("jointplTableColumnIdName1");
                genTable.setJointplTableColumnIdName1(jointplTableColumnIdName1);
                String jointplTableColumnValueName1 = paramsObj.getString("jointplTableColumnValueName1");
                genTable.setJointplTableColumnValueName1(jointplTableColumnValueName1);
                String jointplHtmlType1 = paramsObj.getString("jointplHtmlType1");
                genTable.setJointplHtmlType1(jointplHtmlType1);
            }
        }
    }
//    /**
//     * 生成代码
//     *
//     * @param tableName 表名称
//     * @return 数据
//     */
//    @Override
//    public byte[] generatorCode(String tableName)
//    {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ZipOutputStream zip = new ZipOutputStream(outputStream);
//        generatorCode(tableName, zip);
//        IOUtils.closeQuietly(zip);
//        return outputStream.toByteArray();
//    }
//
//    /**
//     * 批量生成代码
//     *
//     * @param tableNames 表数组
//     * @return 数据
//     */
//    @Override
//    public byte[] generatorCode(String[] tableNames)
//    {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ZipOutputStream zip = new ZipOutputStream(outputStream);
//        for (String tableName : tableNames)
//        {
//            generatorCode(tableName, zip);
//        }
//        IOUtils.closeQuietly(zip);
//        return outputStream.toByteArray();
//    }
}