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
import com.ruoyi.item.domain.RecRecord;
import com.ruoyi.item.service.IRecRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考勤记录Controller
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/item/recRecord")
public class RecRecordController extends BaseController
{
    private String prefix = "item/recRecord";

    @Autowired
    private IRecRecordService recRecordService;

    @RequiresPermissions("item:recRecord:view")
    @GetMapping()
    public String recRecord()
    {
        return prefix + "/recRecord";
    }

    /**
     * 查询考勤记录列表
     */
    @RequiresPermissions("item:recRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecRecord recRecord)
    {
        startPage();
        List<RecRecord> list = recRecordService.selectRecRecordList(recRecord);
        return getDataTable(list);
    }

    /**
     * 导出考勤记录列表
     */
    @RequiresPermissions("item:recRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecRecord recRecord)
    {
        List<RecRecord> list = recRecordService.selectRecRecordList(recRecord);
        ExcelUtil<RecRecord> util = new ExcelUtil<RecRecord>(RecRecord.class);
        return util.exportExcel(list, "recRecord");
    }

    /**
     * 新增考勤记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤记录
     */
    @RequiresPermissions("item:recRecord:add")
    @Log(title = "考勤记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecRecord recRecord)
    {
        return toAjax(recRecordService.insertRecRecord(recRecord));
    }

    /**
     * 修改考勤记录
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        RecRecord recRecord = recRecordService.selectRecRecordById(recordId);
        mmap.put("recRecord", recRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤记录
     */
    @RequiresPermissions("item:recRecord:edit")
    @Log(title = "考勤记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecRecord recRecord)
    {
        return toAjax(recRecordService.updateRecRecord(recRecord));
    }

    /**
     * 删除考勤记录
     */
    @RequiresPermissions("item:recRecord:remove")
    @Log(title = "考勤记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recRecordService.deleteRecRecordByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
