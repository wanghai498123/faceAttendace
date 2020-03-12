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
import com.ruoyi.item.domain.DevPersonnelAssignment;
import com.ruoyi.item.service.IDevPersonnelAssignmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员设备分配Controller
 * 
 * @author wanghai
 * @date 2020-03-05
 */
@Controller
@RequestMapping("/item/personnelAssignment")
public class DevPersonnelAssignmentController extends BaseController
{
    private String prefix = "item/personnelAssignment";

    @Autowired
    private IDevPersonnelAssignmentService devPersonnelAssignmentService;

    @RequiresPermissions("item:personnelAssignment:view")
    @GetMapping()
    public String personnelAssignment()
    {
        return prefix + "/personnelAssignment";
    }

    /**
     * 查询人员设备分配列表
     */
    @RequiresPermissions("item:personnelAssignment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DevPersonnelAssignment devPersonnelAssignment)
    {
        startPage();
        List<DevPersonnelAssignment> list = devPersonnelAssignmentService.selectDevPersonnelAssignmentList(devPersonnelAssignment);
        return getDataTable(list);
    }

    /**
     * 导出人员设备分配列表
     */
    @RequiresPermissions("item:personnelAssignment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DevPersonnelAssignment devPersonnelAssignment)
    {
        List<DevPersonnelAssignment> list = devPersonnelAssignmentService.selectDevPersonnelAssignmentList(devPersonnelAssignment);
        ExcelUtil<DevPersonnelAssignment> util = new ExcelUtil<DevPersonnelAssignment>(DevPersonnelAssignment.class);
        return util.exportExcel(list, "personnelAssignment");
    }

    /**
     * 新增人员设备分配
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人员设备分配
     */
    @RequiresPermissions("item:personnelAssignment:add")
    @Log(title = "人员设备分配", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DevPersonnelAssignment devPersonnelAssignment)
    {
        return toAjax(devPersonnelAssignmentService.insertDevPersonnelAssignment(devPersonnelAssignment));
    }

    /**
     * 修改人员设备分配
     */
    @GetMapping("/edit/{deviceId}")
    public String edit(@PathVariable("deviceId") Long deviceId, ModelMap mmap)
    {
        DevPersonnelAssignment devPersonnelAssignment = devPersonnelAssignmentService.selectDevPersonnelAssignmentById(deviceId);
        mmap.put("devPersonnelAssignment", devPersonnelAssignment);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员设备分配
     */
    @RequiresPermissions("item:personnelAssignment:edit")
    @Log(title = "人员设备分配", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DevPersonnelAssignment devPersonnelAssignment)
    {
        return toAjax(devPersonnelAssignmentService.updateDevPersonnelAssignment(devPersonnelAssignment));
    }

    /**
     * 删除人员设备分配
     */
    @RequiresPermissions("item:personnelAssignment:remove")
    @Log(title = "人员设备分配", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(devPersonnelAssignmentService.deleteDevPersonnelAssignmentByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
