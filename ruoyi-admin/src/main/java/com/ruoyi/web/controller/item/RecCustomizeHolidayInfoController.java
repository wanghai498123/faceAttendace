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
import com.ruoyi.item.domain.RecCustomizeHolidayInfo;
import com.ruoyi.item.service.IRecCustomizeHolidayInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 自定义假日设置Controller
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/item/customizeHolidayInfo")
public class RecCustomizeHolidayInfoController extends BaseController
{
    private String prefix = "item/customizeHolidayInfo";

    @Autowired
    private IRecCustomizeHolidayInfoService recCustomizeHolidayInfoService;

    @RequiresPermissions("item:customizeHolidayInfo:view")
    @GetMapping()
    public String customizeHolidayInfo()
    {
        return prefix + "/customizeHolidayInfo";
    }

    /**
     * 查询自定义假日设置列表
     */
    @RequiresPermissions("item:customizeHolidayInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecCustomizeHolidayInfo recCustomizeHolidayInfo)
    {
        startPage();
        List<RecCustomizeHolidayInfo> list = recCustomizeHolidayInfoService.selectRecCustomizeHolidayInfoList(recCustomizeHolidayInfo);
        return getDataTable(list);
    }

    /**
     * 导出自定义假日设置列表
     */
    @RequiresPermissions("item:customizeHolidayInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecCustomizeHolidayInfo recCustomizeHolidayInfo)
    {
        List<RecCustomizeHolidayInfo> list = recCustomizeHolidayInfoService.selectRecCustomizeHolidayInfoList(recCustomizeHolidayInfo);
        ExcelUtil<RecCustomizeHolidayInfo> util = new ExcelUtil<RecCustomizeHolidayInfo>(RecCustomizeHolidayInfo.class);
        return util.exportExcel(list, "customizeHolidayInfo");
    }

    /**
     * 新增自定义假日设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存自定义假日设置
     */
    @RequiresPermissions("item:customizeHolidayInfo:add")
    @Log(title = "自定义假日设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecCustomizeHolidayInfo recCustomizeHolidayInfo)
    {
        return toAjax(recCustomizeHolidayInfoService.insertRecCustomizeHolidayInfo(recCustomizeHolidayInfo));
    }

    /**
     * 修改自定义假日设置
     */
    @GetMapping("/edit/{customizeHolidayInfoId}")
    public String edit(@PathVariable("customizeHolidayInfoId") Long customizeHolidayInfoId, ModelMap mmap)
    {
        RecCustomizeHolidayInfo recCustomizeHolidayInfo = recCustomizeHolidayInfoService.selectRecCustomizeHolidayInfoById(customizeHolidayInfoId);
        mmap.put("recCustomizeHolidayInfo", recCustomizeHolidayInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存自定义假日设置
     */
    @RequiresPermissions("item:customizeHolidayInfo:edit")
    @Log(title = "自定义假日设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecCustomizeHolidayInfo recCustomizeHolidayInfo)
    {
        return toAjax(recCustomizeHolidayInfoService.updateRecCustomizeHolidayInfo(recCustomizeHolidayInfo));
    }

    /**
     * 删除自定义假日设置
     */
    @RequiresPermissions("item:customizeHolidayInfo:remove")
    @Log(title = "自定义假日设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recCustomizeHolidayInfoService.deleteRecCustomizeHolidayInfoByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
