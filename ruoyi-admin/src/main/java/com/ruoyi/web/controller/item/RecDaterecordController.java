package com.ruoyi.web.controller.item;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.item.domain.RecDaterecord;
import com.ruoyi.item.service.IRecDaterecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考勤日报Controller
 * 
 * @author wanghai
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/item/daterecord")
public class RecDaterecordController extends BaseController
{
    private String prefix = "item/daterecord";

    @Autowired
    private IRecDaterecordService recDaterecordService;

    @RequiresPermissions("item:daterecord:view")
    @GetMapping()
    public String daterecord()
    {
        return prefix + "/daterecord";
    }

    /**
     * 查询考勤日报列表
     */
    @RequiresPermissions("item:daterecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecDaterecord recDaterecord)
    {
        startPage();
        List<RecDaterecord> list = recDaterecordService.selectRecDaterecordList(recDaterecord);
        return getDataTable(list);
    }

    /**
     * 导出考勤日报列表
     */
    @RequiresPermissions("item:daterecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecDaterecord recDaterecord)
    {
        List<RecDaterecord> list = recDaterecordService.selectRecDaterecordList(recDaterecord);
        ExcelUtil<RecDaterecord> util = new ExcelUtil<RecDaterecord>(RecDaterecord.class);
        return util.exportExcel(list, "daterecord");
    }

    /**
     * 新增考勤日报
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤日报
     */
    @RequiresPermissions("item:daterecord:add")
    @Log(title = "考勤日报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecDaterecord recDaterecord)
    {
        return toAjax(recDaterecordService.insertRecDaterecord(recDaterecord));
    }

    /**
     * 修改考勤日报
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        RecDaterecord recDaterecord = recDaterecordService.selectRecDaterecordById(recordId);
        mmap.put("recDaterecord", recDaterecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤日报
     */
    @RequiresPermissions("item:daterecord:edit")
    @Log(title = "考勤日报", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecDaterecord recDaterecord)
    {
        return toAjax(recDaterecordService.updateRecDaterecord(recDaterecord));
    }

    /**
     * 删除考勤日报
     */
    @RequiresPermissions("item:daterecord:remove")
    @Log(title = "考勤日报", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recDaterecordService.deleteRecDaterecordByIds(ids));
    }
    /**~*/ /**~actionBegin*/
}
