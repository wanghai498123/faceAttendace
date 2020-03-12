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
import com.ruoyi.item.domain.ItemTestx;
import com.ruoyi.item.service.IItemTestxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.item.service.IItemTestyService;
import com.ruoyi.item.domain.ItemTesty;

/**
 * 测试Controller
 * 
 * @author wanghai
 * @date 2020-03-12
 */
@Controller
@RequestMapping("/item/testx")
public class ItemTestxController extends BaseController
{
    private String prefix = "item/testx";

    @Autowired
    private IItemTestxService itemTestxService;
    @Autowired
    private IItemTestyService testyService;


    @RequiresPermissions("item:testx:view")
    @GetMapping()
    public String testx(ModelMap mmap)
    {
        mmap.put("testys", testyService.selectItemTestyAll());
        return prefix + "/testx";
    }

    /**
     * 查询测试列表
     */
    @RequiresPermissions("item:testx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ItemTestx itemTestx)
    {
        startPage();
        List<ItemTestx> list = itemTestxService.selectItemTestxList(itemTestx);
        return getDataTable(list);
    }

    /**
     * 导出测试列表
     */
    @RequiresPermissions("item:testx:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ItemTestx itemTestx)
    {
        List<ItemTestx> list = itemTestxService.selectItemTestxList(itemTestx);
        ExcelUtil<ItemTestx> util = new ExcelUtil<ItemTestx>(ItemTestx.class);
        return util.exportExcel(list, "testx");
    }

    /**
     * 新增测试
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("testys", testyService.selectItemTestyAll());
        return prefix + "/add";
    }

    /**
     * 新增保存测试
     */
    @RequiresPermissions("item:testx:add")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ItemTestx itemTestx)
    {
        return toAjax(itemTestxService.insertItemTestx(itemTestx));
    }

    /**
     * 修改测试
     */
    @GetMapping("/edit/{testxId}")
    public String edit(@PathVariable("testxId") Long testxId, ModelMap mmap)
    {
        mmap.put("testys", testyService.selectItemTestyAll());
        ItemTestx itemTestx = itemTestxService.selectItemTestxById(testxId);
        mmap.put("itemTestx", itemTestx);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试
     */
    @RequiresPermissions("item:testx:edit")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ItemTestx itemTestx)
    {
        return toAjax(itemTestxService.updateItemTestx(itemTestx));
    }

    /**
     * 删除测试
     */
    @RequiresPermissions("item:testx:remove")
    @Log(title = "测试", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(itemTestxService.deleteItemTestxByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
