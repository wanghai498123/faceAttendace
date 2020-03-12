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
import com.ruoyi.item.domain.RecTimeRule;
import com.ruoyi.item.service.IRecTimeRuleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考勤时间设置Controller
 * 
 * @author wanghai
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/item/timeRule")
public class RecTimeRuleController extends BaseController
{
    private String prefix = "item/timeRule";

    @Autowired
    private IRecTimeRuleService recTimeRuleService;

    @RequiresPermissions("item:timeRule:view")
    @GetMapping()
    public String timeRule()
    {
        return prefix + "/timeRule";
    }

    /**
     * 查询考勤时间设置列表
     */
    @RequiresPermissions("item:timeRule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecTimeRule recTimeRule)
    {
        startPage();
        List<RecTimeRule> list = recTimeRuleService.selectRecTimeRuleList(recTimeRule);
        return getDataTable(list);
    }

    /**
     * 导出考勤时间设置列表
     */
    @RequiresPermissions("item:timeRule:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecTimeRule recTimeRule)
    {
        List<RecTimeRule> list = recTimeRuleService.selectRecTimeRuleList(recTimeRule);
        ExcelUtil<RecTimeRule> util = new ExcelUtil<RecTimeRule>(RecTimeRule.class);
        return util.exportExcel(list, "timeRule");
    }

    /**
     * 新增考勤时间设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤时间设置
     */
    @RequiresPermissions("item:timeRule:add")
    @Log(title = "考勤时间设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecTimeRule recTimeRule)
    {
        return toAjax(recTimeRuleService.insertRecTimeRule(recTimeRule));
    }

    /**
     * 修改考勤时间设置
     */
    @GetMapping("/edit/{timeRuleId}")
    public String edit(@PathVariable("timeRuleId") Long timeRuleId, ModelMap mmap)
    {
        RecTimeRule recTimeRule = recTimeRuleService.selectRecTimeRuleById(timeRuleId);
        mmap.put("recTimeRule", recTimeRule);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤时间设置
     */
    @RequiresPermissions("item:timeRule:edit")
    @Log(title = "考勤时间设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecTimeRule recTimeRule)
    {
        return toAjax(recTimeRuleService.updateRecTimeRule(recTimeRule));
    }

    /**
     * 删除考勤时间设置
     */
    @RequiresPermissions("item:timeRule:remove")
    @Log(title = "考勤时间设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recTimeRuleService.deleteRecTimeRuleByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
