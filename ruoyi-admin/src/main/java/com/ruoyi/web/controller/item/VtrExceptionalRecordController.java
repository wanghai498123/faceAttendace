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
import com.ruoyi.item.domain.VtrExceptionalRecord;
import com.ruoyi.item.service.IVtrExceptionalRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 异常来访Controller
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/item/exceptionalRecord")
public class VtrExceptionalRecordController extends BaseController
{
    private String prefix = "item/exceptionalRecord";

    @Autowired
    private IVtrExceptionalRecordService vtrExceptionalRecordService;

    @RequiresPermissions("item:exceptionalRecord:view")
    @GetMapping()
    public String exceptionalRecord()
    {
        return prefix + "/exceptionalRecord";
    }

    /**
     * 查询异常来访列表
     */
    @RequiresPermissions("item:exceptionalRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VtrExceptionalRecord vtrExceptionalRecord)
    {
        startPage();
        List<VtrExceptionalRecord> list = vtrExceptionalRecordService.selectVtrExceptionalRecordList(vtrExceptionalRecord);
        return getDataTable(list);
    }

    /**
     * 导出异常来访列表
     */
    @RequiresPermissions("item:exceptionalRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VtrExceptionalRecord vtrExceptionalRecord)
    {
        List<VtrExceptionalRecord> list = vtrExceptionalRecordService.selectVtrExceptionalRecordList(vtrExceptionalRecord);
        ExcelUtil<VtrExceptionalRecord> util = new ExcelUtil<VtrExceptionalRecord>(VtrExceptionalRecord.class);
        return util.exportExcel(list, "exceptionalRecord");
    }

    /**
     * 新增异常来访
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存异常来访
     */
    @RequiresPermissions("item:exceptionalRecord:add")
    @Log(title = "异常来访", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VtrExceptionalRecord vtrExceptionalRecord)
    {
        return toAjax(vtrExceptionalRecordService.insertVtrExceptionalRecord(vtrExceptionalRecord));
    }

    /**
     * 修改异常来访
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        VtrExceptionalRecord vtrExceptionalRecord = vtrExceptionalRecordService.selectVtrExceptionalRecordById(recordId);
        mmap.put("vtrExceptionalRecord", vtrExceptionalRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存异常来访
     */
    @RequiresPermissions("item:exceptionalRecord:edit")
    @Log(title = "异常来访", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VtrExceptionalRecord vtrExceptionalRecord)
    {
        return toAjax(vtrExceptionalRecordService.updateVtrExceptionalRecord(vtrExceptionalRecord));
    }

    /**
     * 删除异常来访
     */
    @RequiresPermissions("item:exceptionalRecord:remove")
    @Log(title = "异常来访", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vtrExceptionalRecordService.deleteVtrExceptionalRecordByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
