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
import com.ruoyi.item.domain.ThmRule;
import com.ruoyi.item.service.IThmRuleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 体温检测规则Controller
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/item/thmRule")
public class ThmRuleController extends BaseController
{
    private String prefix = "item/thmRule";

    @Autowired
    private IThmRuleService thmRuleService;

    @RequiresPermissions("item:thmRule:view")
    @GetMapping()
    public String thmRule()
    {
        return prefix + "/thmRule";
    }

    /**
     * 查询体温检测规则列表
     */
    @RequiresPermissions("item:thmRule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThmRule thmRule)
    {
        startPage();
        List<ThmRule> list = thmRuleService.selectThmRuleList(thmRule);
        return getDataTable(list);
    }

    /**
     * 导出体温检测规则列表
     */
    @RequiresPermissions("item:thmRule:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThmRule thmRule)
    {
        List<ThmRule> list = thmRuleService.selectThmRuleList(thmRule);
        ExcelUtil<ThmRule> util = new ExcelUtil<ThmRule>(ThmRule.class);
        return util.exportExcel(list, "thmRule");
    }

    /**
     * 新增体温检测规则
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存体温检测规则
     */
    @RequiresPermissions("item:thmRule:add")
    @Log(title = "体温检测规则", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThmRule thmRule)
    {
        return toAjax(thmRuleService.insertThmRule(thmRule));
    }

    /**
     * 修改体温检测规则
     */
    @GetMapping("/edit/{ruleId}")
    public String edit(@PathVariable("ruleId") Long ruleId, ModelMap mmap)
    {
        ThmRule thmRule = thmRuleService.selectThmRuleById(ruleId);
        mmap.put("thmRule", thmRule);
        return prefix + "/edit";
    }

    /**
     * 修改保存体温检测规则
     */
    @RequiresPermissions("item:thmRule:edit")
    @Log(title = "体温检测规则", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThmRule thmRule)
    {
        return toAjax(thmRuleService.updateThmRule(thmRule));
    }

    /**
     * 删除体温检测规则
     */
    @RequiresPermissions("item:thmRule:remove")
    @Log(title = "体温检测规则", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thmRuleService.deleteThmRuleByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
