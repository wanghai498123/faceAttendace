package com.ruoyi.web.controller.item;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.item.domain.ItemCompany;
import com.ruoyi.item.service.IItemCompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 建筑公司Controller
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Controller
@RequestMapping("/item/company")
public class ItemCompanyController extends BaseController
{
    private String prefix = "item/company";

    @Autowired
    private IItemCompanyService itemCompanyService;

    @RequiresPermissions("item:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询建筑公司列表
     */
    @RequiresPermissions("item:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ItemCompany itemCompany)
    {
        startPage();
        List<ItemCompany> list = itemCompanyService.selectItemCompanyList(itemCompany);
        return getDataTable(list);
    }

    /**
     * 导出建筑公司列表
     */
    @RequiresPermissions("item:company:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ItemCompany itemCompany)
    {
        List<ItemCompany> list = itemCompanyService.selectItemCompanyList(itemCompany);
        ExcelUtil<ItemCompany> util = new ExcelUtil<ItemCompany>(ItemCompany.class);
        return util.exportExcel(list, "company");
    }

    /**
     * 新增建筑公司
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存建筑公司
     */
    @RequiresPermissions("item:company:add")
    @Log(title = "建筑公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ItemCompany itemCompany)
    {
        return toAjax(itemCompanyService.insertItemCompany(itemCompany));
    }

    /**
     * 修改建筑公司
     */
    @GetMapping("/edit/{companyId}")
    public String edit(@PathVariable("companyId") Long companyId, ModelMap mmap)
    {
        ItemCompany itemCompany = itemCompanyService.selectItemCompanyById(companyId);
        mmap.put("itemCompany", itemCompany);
        return prefix + "/edit";
    }

    /**
     * 修改保存建筑公司
     */
    @RequiresPermissions("item:company:edit")
    @Log(title = "建筑公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ItemCompany itemCompany)
    {
        return toAjax(itemCompanyService.updateItemCompany(itemCompany));
    }

    /**
     * 删除建筑公司
     */
    @RequiresPermissions("item:company:remove")
    @Log(title = "建筑公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(itemCompanyService.deleteItemCompanyByIds(ids));
    }
    /**~*/ /**~actionBegin*/
}
