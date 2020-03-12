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
import com.ruoyi.item.domain.RecPersonnelLeave;
import com.ruoyi.item.service.IRecPersonnelLeaveService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工请假Controller
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/item/personnelLeave")
public class RecPersonnelLeaveController extends BaseController
{
    private String prefix = "item/personnelLeave";

    @Autowired
    private IRecPersonnelLeaveService recPersonnelLeaveService;

    @RequiresPermissions("item:personnelLeave:view")
    @GetMapping()
    public String personnelLeave()
    {
        return prefix + "/personnelLeave";
    }

    /**
     * 查询员工请假列表
     */
    @RequiresPermissions("item:personnelLeave:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecPersonnelLeave recPersonnelLeave)
    {
        startPage();
        List<RecPersonnelLeave> list = recPersonnelLeaveService.selectRecPersonnelLeaveList(recPersonnelLeave);
        return getDataTable(list);
    }

    /**
     * 导出员工请假列表
     */
    @RequiresPermissions("item:personnelLeave:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecPersonnelLeave recPersonnelLeave)
    {
        List<RecPersonnelLeave> list = recPersonnelLeaveService.selectRecPersonnelLeaveList(recPersonnelLeave);
        ExcelUtil<RecPersonnelLeave> util = new ExcelUtil<RecPersonnelLeave>(RecPersonnelLeave.class);
        return util.exportExcel(list, "personnelLeave");
    }

    /**
     * 新增员工请假
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工请假
     */
    @RequiresPermissions("item:personnelLeave:add")
    @Log(title = "员工请假", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecPersonnelLeave recPersonnelLeave)
    {
        return toAjax(recPersonnelLeaveService.insertRecPersonnelLeave(recPersonnelLeave));
    }

    /**
     * 修改员工请假
     */
    @GetMapping("/edit/{personnelLeaveId}")
    public String edit(@PathVariable("personnelLeaveId") Long personnelLeaveId, ModelMap mmap)
    {
        RecPersonnelLeave recPersonnelLeave = recPersonnelLeaveService.selectRecPersonnelLeaveById(personnelLeaveId);
        mmap.put("recPersonnelLeave", recPersonnelLeave);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工请假
     */
    @RequiresPermissions("item:personnelLeave:edit")
    @Log(title = "员工请假", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecPersonnelLeave recPersonnelLeave)
    {
        return toAjax(recPersonnelLeaveService.updateRecPersonnelLeave(recPersonnelLeave));
    }

    /**
     * 删除员工请假
     */
    @RequiresPermissions("item:personnelLeave:remove")
    @Log(title = "员工请假", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recPersonnelLeaveService.deleteRecPersonnelLeaveByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
