package com.ruoyi.web.controller.item;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.item.domain.RecClasses;
import com.ruoyi.item.service.IRecClassesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考勤班次Controller
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Controller
@RequestMapping("/item/classes")
public class RecClassesController extends BaseController
{
    private String prefix = "item/classes";

    @Autowired
    private IRecClassesService recClassesService;

    @RequiresPermissions("item:classes:view")
    @GetMapping()
    public String classes()
    {
        return prefix + "/classes";
    }

    /**
     * 查询考勤班次列表
     */
    @RequiresPermissions("item:classes:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecClasses recClasses)
    {
        startPage();
        List<RecClasses> list = recClassesService.selectRecClassesList(recClasses);
        return getDataTable(list);
    }

    /**
     * 导出考勤班次列表
     */
    @RequiresPermissions("item:classes:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecClasses recClasses)
    {
        List<RecClasses> list = recClassesService.selectRecClassesList(recClasses);
        ExcelUtil<RecClasses> util = new ExcelUtil<RecClasses>(RecClasses.class);
        return util.exportExcel(list, "classes");
    }

    /**
     * 新增考勤班次
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤班次
     */
    @RequiresPermissions("item:classes:add")
    @Log(title = "考勤班次", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecClasses recClasses)
    {
        return toAjax(recClassesService.insertRecClasses(recClasses));
    }

    /**
     * 修改考勤班次
     */
    @GetMapping("/edit/{classesId}")
    public String edit(@PathVariable("classesId") Long classesId, ModelMap mmap)
    {
        RecClasses recClasses = recClassesService.selectRecClassesById(classesId);
        mmap.put("recClasses", recClasses);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤班次
     */
    @RequiresPermissions("item:classes:edit")
    @Log(title = "考勤班次", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecClasses recClasses)
    {
        return toAjax(recClassesService.updateRecClasses(recClasses));
    }

    /**
     * 删除考勤班次
     */
    @RequiresPermissions("item:classes:remove")
    @Log(title = "考勤班次", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recClassesService.deleteRecClassesByIds(ids));
    }
    /**~*/ /**~actionBegin*/
}
