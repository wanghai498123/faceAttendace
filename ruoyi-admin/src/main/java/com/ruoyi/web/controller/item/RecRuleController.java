package com.ruoyi.web.controller.item;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.item.domain.RecRule;
import com.ruoyi.item.service.IRecRuleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考勤规则Controller
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Controller
@RequestMapping("/item/rule")
public class RecRuleController extends BaseController
{
    private String prefix = "item/rule";

    @Autowired
    private IRecRuleService recRuleService;

    @RequiresPermissions("item:rule:view")
    @GetMapping()
    public String rule()
    {
        return prefix + "/rule";
    }

    /**
     * 查询考勤规则列表
     */
    @RequiresPermissions("item:rule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecRule recRule)
    {
        startPage();
        List<RecRule> list = recRuleService.selectRecRuleList(recRule);
        return getDataTable(list);
    }

    /**
     * 导出考勤规则列表
     */
    @RequiresPermissions("item:rule:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecRule recRule)
    {
        List<RecRule> list = recRuleService.selectRecRuleList(recRule);
        ExcelUtil<RecRule> util = new ExcelUtil<RecRule>(RecRule.class);
        return util.exportExcel(list, "rule");
    }

    /**
     * 新增考勤规则
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤规则
     */
    @RequiresPermissions("item:rule:add")
    @Log(title = "考勤规则", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecRule recRule)
    {
        return toAjax(recRuleService.insertRecRule(recRule));
    }

    /**
     * 修改考勤规则
     */
    @GetMapping("/edit/{ruleId}")
    public String edit(@PathVariable("ruleId") Long ruleId, ModelMap mmap)
    {
        RecRule recRule = recRuleService.selectRecRuleById(ruleId);
        mmap.put("recRule", recRule);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤规则
     */
    @RequiresPermissions("item:rule:edit")
    @Log(title = "考勤规则", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecRule recRule)
    {
        return toAjax(recRuleService.updateRecRule(recRule));
    }

    /**
     * 删除考勤规则
     */
    @RequiresPermissions("item:rule:remove")
    @Log(title = "考勤规则", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recRuleService.deleteRecRuleByIds(ids));
    }
    /**~*/ /**~actionBegin*/
}
