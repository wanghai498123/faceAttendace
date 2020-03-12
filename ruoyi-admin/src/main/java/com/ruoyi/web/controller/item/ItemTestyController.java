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
import com.ruoyi.item.domain.ItemTesty;
import com.ruoyi.item.service.IItemTestyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 部门Controller
 * 
 * @author wanghai
 * @date 2020-03-11
 */
@Controller
@RequestMapping("/item/testy")
public class ItemTestyController extends BaseController
{
    private String prefix = "item/testy";

    @Autowired
    private IItemTestyService itemTestyService;


    @RequiresPermissions("item:testy:view")
    @GetMapping()
    public String testy(ModelMap mmap)
    {
        return prefix + "/testy";
    }

    /**
     * 查询部门树列表
     */
    @RequiresPermissions("item:testy:list")
    @PostMapping("/list")
    @ResponseBody
    public List<ItemTesty> list(ItemTesty itemTesty)
    {
        List<ItemTesty> list = itemTestyService.selectItemTestyList(itemTesty);
        return list;
    }

    /**
     * 导出部门列表
     */
    @RequiresPermissions("item:testy:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ItemTesty itemTesty)
    {
        List<ItemTesty> list = itemTestyService.selectItemTestyList(itemTesty);
        ExcelUtil<ItemTesty> util = new ExcelUtil<ItemTesty>(ItemTesty.class);
        return util.exportExcel(list, "testy");
    }

    /**
     * 新增部门
     */
    @GetMapping(value = { "/add/{testyId}", "/add/" })
    public String add(@PathVariable(value = "testyId", required = false) Long testyId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(testyId))
        {
            mmap.put("itemTesty", itemTestyService.selectItemTestyById(testyId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存部门
     */
    @RequiresPermissions("item:testy:add")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ItemTesty itemTesty)
    {
        return toAjax(itemTestyService.insertItemTesty(itemTesty));
    }

    /**
     * 修改部门
     */
    @GetMapping("/edit/{testyId}")
    public String edit(@PathVariable("testyId") Long testyId, ModelMap mmap)
    {
        ItemTesty itemTesty = itemTestyService.selectItemTestyById(testyId);
        mmap.put("itemTesty", itemTesty);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门
     */
    @RequiresPermissions("item:testy:edit")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ItemTesty itemTesty)
    {
        return toAjax(itemTestyService.updateItemTesty(itemTesty));
    }

    /**
     * 删除
     */
    @RequiresPermissions("item:testy:remove")
    @Log(title = "部门", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{testyId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("testyId") Long testyId)
    {
        return toAjax(itemTestyService.deleteItemTestyById(testyId));
    }

    /**
     * 非选择部门树面板
     */
    @GetMapping(value = { "/selectTestyTree/{testyId}", "/selectTestyTree/" })
    public String selectTestyTree(@PathVariable(value = "testyId", required = false) Long testyId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(testyId))
        {
            mmap.put("itemTesty", itemTestyService.selectItemTestyById(testyId));
        }
        return prefix + "/tree";
    }
    /**
     * 加载部门非选择树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<ItemTesty> itemTestyList =itemTestyService.selectItemTestyAll();
        List<Ztree> ztrees = itemTestyService.generateItemTestyTreeDate(itemTestyList,false);;
        return ztrees;
    }

     /**~*/ /**~actionBegin*/

}
