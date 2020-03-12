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
import com.ruoyi.item.domain.DevDeviceTeam;
import com.ruoyi.item.service.IDevDeviceTeamService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 设备分组Controller
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/item/deviceTeam")
public class DevDeviceTeamController extends BaseController
{
    private String prefix = "item/deviceTeam";

    @Autowired
    private IDevDeviceTeamService devDeviceTeamService;

    @RequiresPermissions("item:deviceTeam:view")
    @GetMapping()
    public String deviceTeam()
    {
        return prefix + "/deviceTeam";
    }

    /**
     * 查询设备分组树列表
     */
    @RequiresPermissions("item:deviceTeam:list")
    @PostMapping("/list")
    @ResponseBody
    public List<DevDeviceTeam> list(DevDeviceTeam devDeviceTeam)
    {
        List<DevDeviceTeam> list = devDeviceTeamService.selectDevDeviceTeamList(devDeviceTeam);
        return list;
    }

    /**
     * 导出设备分组列表
     */
    @RequiresPermissions("item:deviceTeam:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DevDeviceTeam devDeviceTeam)
    {
        List<DevDeviceTeam> list = devDeviceTeamService.selectDevDeviceTeamList(devDeviceTeam);
        ExcelUtil<DevDeviceTeam> util = new ExcelUtil<DevDeviceTeam>(DevDeviceTeam.class);
        return util.exportExcel(list, "deviceTeam");
    }

    /**
     * 新增设备分组
     */
    @GetMapping(value = { "/add/{deviceTeamId}", "/add/" })
    public String add(@PathVariable(value = "deviceTeamId", required = false) Long deviceTeamId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(deviceTeamId))
        {
            mmap.put("devDeviceTeam", devDeviceTeamService.selectDevDeviceTeamById(deviceTeamId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存设备分组
     */
    @RequiresPermissions("item:deviceTeam:add")
    @Log(title = "设备分组", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DevDeviceTeam devDeviceTeam)
    {
        return toAjax(devDeviceTeamService.insertDevDeviceTeam(devDeviceTeam));
    }

    /**
     * 修改设备分组
     */
    @GetMapping("/edit/{deviceTeamId}")
    public String edit(@PathVariable("deviceTeamId") Long deviceTeamId, ModelMap mmap)
    {
        DevDeviceTeam devDeviceTeam = devDeviceTeamService.selectDevDeviceTeamById(deviceTeamId);
        mmap.put("devDeviceTeam", devDeviceTeam);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备分组
     */
    @RequiresPermissions("item:deviceTeam:edit")
    @Log(title = "设备分组", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DevDeviceTeam devDeviceTeam)
    {
        return toAjax(devDeviceTeamService.updateDevDeviceTeam(devDeviceTeam));
    }

    /**
     * 删除
     */
    @RequiresPermissions("item:deviceTeam:remove")
    @Log(title = "设备分组", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{deviceTeamId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("deviceTeamId") Long deviceTeamId)
    {
        return toAjax(devDeviceTeamService.deleteDevDeviceTeamById(deviceTeamId));
    }

    /**
     * 选择设备分组树
     */
    @GetMapping(value = { "/selectDeviceTeamTree/{deviceTeamId}", "/selectDeviceTeamTree/" })
    public String selectDeviceTeamTree(@PathVariable(value = "deviceTeamId", required = false) Long deviceTeamId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(deviceTeamId))
        {
            mmap.put("devDeviceTeam", devDeviceTeamService.selectDevDeviceTeamById(deviceTeamId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载设备分组树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = devDeviceTeamService.selectDevDeviceTeamTree();
        return ztrees;
    }

     /**~*/ /**~actionBegin*/

}
