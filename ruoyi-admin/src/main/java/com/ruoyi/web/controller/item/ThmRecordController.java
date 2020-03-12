package com.ruoyi.web.controller.item;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.item.domain.ThmRecord;
import com.ruoyi.item.service.IThmRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 体温检测记录Controller
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/item/thmRecord")
public class ThmRecordController extends BaseController
{
    private String prefix = "item/thmRecord";

    @Autowired
    private IThmRecordService thmRecordService;

    @RequiresPermissions("item:thmRecord:view")
    @GetMapping()
    public String thmRecord()
    {
        return prefix + "/thmRecord";
    }

    /**
     * 查询体温检测记录列表
     */
    @RequiresPermissions("item:thmRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThmRecord thmRecord)
    {
        startPage();
        List<ThmRecord> list = thmRecordService.selectThmRecordList(thmRecord);
        return getDataTable(list);
    }

    /**
     * 导出体温检测记录列表
     */
    @RequiresPermissions("item:thmRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThmRecord thmRecord)
    {
        List<ThmRecord> list = thmRecordService.selectThmRecordList(thmRecord);
        ExcelUtil<ThmRecord> util = new ExcelUtil<ThmRecord>(ThmRecord.class);
        return util.exportExcel(list, "thmRecord");
    }

    /**
     * 新增体温检测记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存体温检测记录
     */
    @RequiresPermissions("item:thmRecord:add")
    @Log(title = "体温检测记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThmRecord thmRecord)
    {
        return toAjax(thmRecordService.insertThmRecord(thmRecord));
    }

    /**
     * 修改体温检测记录
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        ThmRecord thmRecord = thmRecordService.selectThmRecordById(recordId);
        mmap.put("thmRecord", thmRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存体温检测记录
     */
    @RequiresPermissions("item:thmRecord:edit")
    @Log(title = "体温检测记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThmRecord thmRecord)
    {
        return toAjax(thmRecordService.updateThmRecord(thmRecord));
    }

    /**
     * 删除体温检测记录
     */
    @RequiresPermissions("item:thmRecord:remove")
    @Log(title = "体温检测记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thmRecordService.deleteThmRecordByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
