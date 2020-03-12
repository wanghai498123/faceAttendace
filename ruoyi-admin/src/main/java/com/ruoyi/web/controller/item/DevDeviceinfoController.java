package com.ruoyi.web.controller.item;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.item.domain.DevDeviceinfo;
import com.ruoyi.item.service.IDevDeviceinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备信息Controller
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Controller
@RequestMapping("/item/deviceinfo")
public class DevDeviceinfoController extends BaseController
{
    private String prefix = "item/deviceinfo";

    @Autowired
    private IDevDeviceinfoService devDeviceinfoService;

    @RequiresPermissions("item:deviceinfo:view")
    @GetMapping()
    public String deviceinfo()
    {
        return prefix + "/deviceinfo";
    }

    /**
     * 查询设备信息列表
     */
    @RequiresPermissions("item:deviceinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DevDeviceinfo devDeviceinfo)
    {
        startPage();
        List<DevDeviceinfo> list = devDeviceinfoService.selectDevDeviceinfoList(devDeviceinfo);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @RequiresPermissions("item:deviceinfo:export")
    @PostMapping("/export")
    @ResponseBody
        public AjaxResult export(DevDeviceinfo devDeviceinfo)
    {
        List<DevDeviceinfo> list = devDeviceinfoService.selectDevDeviceinfoList(devDeviceinfo);
        ExcelUtil<DevDeviceinfo> util = new ExcelUtil<DevDeviceinfo>(DevDeviceinfo.class);
        return util.exportExcel(list, "deviceinfo");
    }

    /**
     * 新增设备信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息
     */
    @RequiresPermissions("item:deviceinfo:add")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DevDeviceinfo devDeviceinfo)
    {
        return toAjax(devDeviceinfoService.insertDevDeviceinfo(devDeviceinfo));
    }

    /**
     * 修改设备信息
     */
    @GetMapping("/edit/{deviceId}")
    public String edit(@PathVariable("deviceId") Long deviceId, ModelMap mmap)
    {
        DevDeviceinfo devDeviceinfo = devDeviceinfoService.selectDevDeviceinfoById(deviceId);
        mmap.put("devDeviceinfo", devDeviceinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息
     */
    @RequiresPermissions("item:deviceinfo:edit")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DevDeviceinfo devDeviceinfo)
    {
        return toAjax(devDeviceinfoService.updateDevDeviceinfo(devDeviceinfo));
    }

    /**
     * 删除设备信息
     */
    @RequiresPermissions("item:deviceinfo:remove")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(devDeviceinfoService.deleteDevDeviceinfoByIds(ids));
    }
    /**~*/ /**~actionBegin*/
}
