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
import com.ruoyi.item.domain.RecHolidayInfo;
import com.ruoyi.item.service.IRecHolidayInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 假日设置Controller
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/item/holidayInfo")
public class RecHolidayInfoController extends BaseController
{
    private String prefix = "item/holidayInfo";

    @Autowired
    private IRecHolidayInfoService recHolidayInfoService;

    @RequiresPermissions("item:holidayInfo:view")
    @GetMapping()
    public String holidayInfo()
    {
        return prefix + "/holidayInfo";
    }

    /**
     * 查询假日设置列表
     */
    @RequiresPermissions("item:holidayInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecHolidayInfo recHolidayInfo)
    {
        startPage();
        List<RecHolidayInfo> list = recHolidayInfoService.selectRecHolidayInfoList(recHolidayInfo);
        return getDataTable(list);
    }

    /**
     * 导出假日设置列表
     */
    @RequiresPermissions("item:holidayInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecHolidayInfo recHolidayInfo)
    {
        List<RecHolidayInfo> list = recHolidayInfoService.selectRecHolidayInfoList(recHolidayInfo);
        ExcelUtil<RecHolidayInfo> util = new ExcelUtil<RecHolidayInfo>(RecHolidayInfo.class);
        return util.exportExcel(list, "holidayInfo");
    }

    /**
     * 新增假日设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存假日设置
     */
    @RequiresPermissions("item:holidayInfo:add")
    @Log(title = "假日设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecHolidayInfo recHolidayInfo)
    {
        return toAjax(recHolidayInfoService.insertRecHolidayInfo(recHolidayInfo));
    }

    /**
     * 修改假日设置
     */
    @GetMapping("/edit/{holidayInfoId}")
    public String edit(@PathVariable("holidayInfoId") Long holidayInfoId, ModelMap mmap)
    {
        RecHolidayInfo recHolidayInfo = recHolidayInfoService.selectRecHolidayInfoById(holidayInfoId);
        mmap.put("recHolidayInfo", recHolidayInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存假日设置
     */
    @RequiresPermissions("item:holidayInfo:edit")
    @Log(title = "假日设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecHolidayInfo recHolidayInfo)
    {
        return toAjax(recHolidayInfoService.updateRecHolidayInfo(recHolidayInfo));
    }

    /**
     * 删除假日设置
     */
    @RequiresPermissions("item:holidayInfo:remove")
    @Log(title = "假日设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recHolidayInfoService.deleteRecHolidayInfoByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
