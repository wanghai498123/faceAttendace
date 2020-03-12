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
import com.ruoyi.item.domain.ThmDateRecord;
import com.ruoyi.item.service.IThmDateRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 体温检测记录日Controller
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/item/thmDateRecord")
public class ThmDateRecordController extends BaseController
{
    private String prefix = "item/thmDateRecord";

    @Autowired
    private IThmDateRecordService thmDateRecordService;

    @RequiresPermissions("item:thmDateRecord:view")
    @GetMapping()
    public String thmDateRecord()
    {
        return prefix + "/thmDateRecord";
    }

    /**
     * 查询体温检测记录日列表
     */
    @RequiresPermissions("item:thmDateRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThmDateRecord thmDateRecord)
    {
        startPage();
        List<ThmDateRecord> list = thmDateRecordService.selectThmDateRecordList(thmDateRecord);
        return getDataTable(list);
    }

    /**
     * 导出体温检测记录日列表
     */
    @RequiresPermissions("item:thmDateRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThmDateRecord thmDateRecord)
    {
        List<ThmDateRecord> list = thmDateRecordService.selectThmDateRecordList(thmDateRecord);
        ExcelUtil<ThmDateRecord> util = new ExcelUtil<ThmDateRecord>(ThmDateRecord.class);
        return util.exportExcel(list, "thmDateRecord");
    }

    /**
     * 新增体温检测记录日
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存体温检测记录日
     */
    @RequiresPermissions("item:thmDateRecord:add")
    @Log(title = "体温检测记录日", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThmDateRecord thmDateRecord)
    {
        return toAjax(thmDateRecordService.insertThmDateRecord(thmDateRecord));
    }

    /**
     * 修改体温检测记录日
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        ThmDateRecord thmDateRecord = thmDateRecordService.selectThmDateRecordById(recordId);
        mmap.put("thmDateRecord", thmDateRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存体温检测记录日
     */
    @RequiresPermissions("item:thmDateRecord:edit")
    @Log(title = "体温检测记录日", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThmDateRecord thmDateRecord)
    {
        return toAjax(thmDateRecordService.updateThmDateRecord(thmDateRecord));
    }

    /**
     * 删除体温检测记录日
     */
    @RequiresPermissions("item:thmDateRecord:remove")
    @Log(title = "体温检测记录日", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thmDateRecordService.deleteThmDateRecordByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
