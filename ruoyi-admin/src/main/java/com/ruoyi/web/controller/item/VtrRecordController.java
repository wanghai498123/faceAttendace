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
import com.ruoyi.item.domain.VtrRecord;
import com.ruoyi.item.service.IVtrRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 来访记录Controller
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/item/vtrRecord")
public class VtrRecordController extends BaseController
{
    private String prefix = "item/vtrRecord";

    @Autowired
    private IVtrRecordService vtrRecordService;

    @RequiresPermissions("item:vtrRecord:view")
    @GetMapping()
    public String vtrRecord()
    {
        return prefix + "/vtrRecord";
    }

    /**
     * 查询来访记录列表
     */
    @RequiresPermissions("item:vtrRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VtrRecord vtrRecord)
    {
        startPage();
        List<VtrRecord> list = vtrRecordService.selectVtrRecordList(vtrRecord);
        return getDataTable(list);
    }

    /**
     * 导出来访记录列表
     */
    @RequiresPermissions("item:vtrRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VtrRecord vtrRecord)
    {
        List<VtrRecord> list = vtrRecordService.selectVtrRecordList(vtrRecord);
        ExcelUtil<VtrRecord> util = new ExcelUtil<VtrRecord>(VtrRecord.class);
        return util.exportExcel(list, "vtrRecord");
    }

    /**
     * 新增来访记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存来访记录
     */
    @RequiresPermissions("item:vtrRecord:add")
    @Log(title = "来访记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VtrRecord vtrRecord)
    {
        return toAjax(vtrRecordService.insertVtrRecord(vtrRecord));
    }

    /**
     * 修改来访记录
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        VtrRecord vtrRecord = vtrRecordService.selectVtrRecordById(recordId);
        mmap.put("vtrRecord", vtrRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存来访记录
     */
    @RequiresPermissions("item:vtrRecord:edit")
    @Log(title = "来访记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VtrRecord vtrRecord)
    {
        return toAjax(vtrRecordService.updateVtrRecord(vtrRecord));
    }

    /**
     * 删除来访记录
     */
    @RequiresPermissions("item:vtrRecord:remove")
    @Log(title = "来访记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vtrRecordService.deleteVtrRecordByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
