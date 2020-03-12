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
import com.ruoyi.item.domain.VtrSubscribe;
import com.ruoyi.item.service.IVtrSubscribeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 访客预约Controller
 * 
 * @author wanghai
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/item/vtrSubscribe")
public class VtrSubscribeController extends BaseController
{
    private String prefix = "item/vtrSubscribe";

    @Autowired
    private IVtrSubscribeService vtrSubscribeService;

    @RequiresPermissions("item:vtrSubscribe:view")
    @GetMapping()
    public String vtrSubscribe()
    {
        return prefix + "/vtrSubscribe";
    }

    /**
     * 查询访客预约列表
     */
    @RequiresPermissions("item:vtrSubscribe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VtrSubscribe vtrSubscribe)
    {
        startPage();
        List<VtrSubscribe> list = vtrSubscribeService.selectVtrSubscribeList(vtrSubscribe);
        return getDataTable(list);
    }

    /**
     * 导出访客预约列表
     */
    @RequiresPermissions("item:vtrSubscribe:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VtrSubscribe vtrSubscribe)
    {
        List<VtrSubscribe> list = vtrSubscribeService.selectVtrSubscribeList(vtrSubscribe);
        ExcelUtil<VtrSubscribe> util = new ExcelUtil<VtrSubscribe>(VtrSubscribe.class);
        return util.exportExcel(list, "vtrSubscribe");
    }

    /**
     * 新增访客预约
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存访客预约
     */
    @RequiresPermissions("item:vtrSubscribe:add")
    @Log(title = "访客预约", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VtrSubscribe vtrSubscribe)
    {
        return toAjax(vtrSubscribeService.insertVtrSubscribe(vtrSubscribe));
    }

    /**
     * 修改访客预约
     */
    @GetMapping("/edit/{subscribeId}")
    public String edit(@PathVariable("subscribeId") Long subscribeId, ModelMap mmap)
    {
        VtrSubscribe vtrSubscribe = vtrSubscribeService.selectVtrSubscribeById(subscribeId);
        mmap.put("vtrSubscribe", vtrSubscribe);
        return prefix + "/edit";
    }

    /**
     * 修改保存访客预约
     */
    @RequiresPermissions("item:vtrSubscribe:edit")
    @Log(title = "访客预约", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VtrSubscribe vtrSubscribe)
    {
        return toAjax(vtrSubscribeService.updateVtrSubscribe(vtrSubscribe));
    }

    /**
     * 删除访客预约
     */
    @RequiresPermissions("item:vtrSubscribe:remove")
    @Log(title = "访客预约", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vtrSubscribeService.deleteVtrSubscribeByIds(ids));
    }

     /**~*/ /**~actionBegin*/

}
