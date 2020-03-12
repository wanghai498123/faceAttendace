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
import com.ruoyi.item.domain.DevOperLog;
import com.ruoyi.item.service.IDevOperLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备操作日志Controller
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/item/devOperLog")
public class DevOperLogController extends BaseController
{
    private String prefix = "item/devOperLog";

    @Autowired
    private IDevOperLogService devOperLogService;

    @RequiresPermissions("item:devOperLog:view")
    @GetMapping()
    public String devOperLog()
    {
        return prefix + "/devOperLog";
    }

    /**
     * 查询设备操作日志列表
     */
    @RequiresPermissions("item:devOperLog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DevOperLog devOperLog)
    {
        startPage();
        List<DevOperLog> list = devOperLogService.selectDevOperLogList(devOperLog);
        return getDataTable(list);
    }

    /**
     * 导出设备操作日志列表
     */
    @RequiresPermissions("item:devOperLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DevOperLog devOperLog)
    {
        List<DevOperLog> list = devOperLogService.selectDevOperLogList(devOperLog);
        ExcelUtil<DevOperLog> util = new ExcelUtil<DevOperLog>(DevOperLog.class);
        return util.exportExcel(list, "devOperLog");
    }

    /**
     * 新增设备操作日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备操作日志
     */
    @RequiresPermissions("item:devOperLog:add")
    @Log(title = "设备操作日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DevOperLog devOperLog)
    {
        return toAjax(devOperLogService.insertDevOperLog(devOperLog));
    }

    /**
     * 修改设备操作日志
     */
    @GetMapping("/edit/{operId}")
    public String edit(@PathVariable("operId") Long operId, ModelMap mmap)
    {
        DevOperLog devOperLog = devOperLogService.selectDevOperLogById(operId);
        mmap.put("devOperLog", devOperLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备操作日志
     */
    @RequiresPermissions("item:devOperLog:edit")
    @Log(title = "设备操作日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DevOperLog devOperLog)
    {
        return toAjax(devOperLogService.updateDevOperLog(devOperLog));
    }

    /**
     * 删除设备操作日志
     */
    @RequiresPermissions("item:devOperLog:remove")
    @Log(title = "设备操作日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(devOperLogService.deleteDevOperLogByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
