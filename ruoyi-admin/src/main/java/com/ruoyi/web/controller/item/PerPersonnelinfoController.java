package com.ruoyi.web.controller.item;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.item.domain.DevDeviceinfo;
import com.ruoyi.item.domain.PerPersonnelinfo;
import com.ruoyi.item.service.IAttendanceAPIService;
import com.ruoyi.item.service.IDevDeviceinfoService;
import com.ruoyi.item.service.IPerPersonnelinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 人员信息Controller
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Controller
@RequestMapping("/item/personnelinfo")
public class PerPersonnelinfoController extends BaseController
{
    private String prefix = "item/personnelinfo";

    @Autowired
    private IDevDeviceinfoService iDevDeviceinfoService;
    @Autowired
    private IAttendanceAPIService attendanceAPIService;


    @Autowired
    private IPerPersonnelinfoService perPersonnelinfoService;

    @RequiresPermissions("item:personnelinfo:view")
    @GetMapping()
    public String personnelinfo()
    {
        return prefix + "/personnelinfo";
    }

    /**
     * 查询人员信息列表
     */
    @RequiresPermissions("item:personnelinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerPersonnelinfo perPersonnelinfo)
    {
        startPage();
        List<PerPersonnelinfo> list = perPersonnelinfoService.selectPerPersonnelinfoList(perPersonnelinfo);
        return getDataTable(list);
    }

    /**
     * 导出人员信息列表
     */
    @RequiresPermissions("item:personnelinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerPersonnelinfo perPersonnelinfo)
    {
        List<PerPersonnelinfo> list = perPersonnelinfoService.selectPerPersonnelinfoList(perPersonnelinfo);
        ExcelUtil<PerPersonnelinfo> util = new ExcelUtil<PerPersonnelinfo>(PerPersonnelinfo.class);
        return util.exportExcel(list, "personnelinfo");
    }

    /**
     * 新增人员信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人员信息
     */
    @RequiresPermissions("item:personnelinfo:add")
    @Log(title = "人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerPersonnelinfo perPersonnelinfo) throws IOException {
        //处理照片路径
        String fileName=perPersonnelinfo.getFiles().get(0).getOriginalFilename();
        perPersonnelinfo.setFacePath(Global.getUploadPath() + "/" +UUID.randomUUID().toString()+fileName.substring(fileName.indexOf(".")));
        fileName=perPersonnelinfo.getFiles().get(1).getOriginalFilename();
        perPersonnelinfo.setCertificatePath(Global.getUploadPath() + "/" +UUID.randomUUID().toString()+fileName.substring(fileName.indexOf(".")));

        int ret=perPersonnelinfoService.insertPerPersonnelinfo(perPersonnelinfo);
        if(ret==1)
        {
            //保存照片
            perPersonnelinfo.getFiles().get(0).transferTo(Paths.get(perPersonnelinfo.getFacePath()));
            perPersonnelinfo.getFiles().get(1).transferTo(Paths.get( perPersonnelinfo.getCertificatePath()));
        }

        //数据下方
        if(perPersonnelinfo.getDataDissemination().equals("1"))
        {
            DevDeviceinfo devDeviceinfo=new DevDeviceinfo();
            List<DevDeviceinfo> devDeviceinfos =iDevDeviceinfoService.selectDevDeviceinfoList(devDeviceinfo);
            String ss=attendanceAPIService.faceDown(perPersonnelinfo,devDeviceinfos);
            if(!ss.equals(""))
            {
                perPersonnelinfoService.deletePerPersonnelinfoById(perPersonnelinfo.getPersonnelId());
                return error(ss);
            }
        }
        //认证对照不知道是哪个设备
        //attendanceAPI.personWitnessRatio();
        return toAjax(ret);
    }

    /**
     * 修改人员信息
     */
    @GetMapping("/edit/{personnelId}")
    public String edit(@PathVariable("personnelId") Long personnelId, ModelMap mmap)
    {
        PerPersonnelinfo perPersonnelinfo = perPersonnelinfoService.selectPerPersonnelinfoById(personnelId);
        mmap.put("perPersonnelinfo", perPersonnelinfo);
        return prefix + "/edit";
    }
    /**
     * 下发数据人员信息
     */
    @GetMapping("/synData/{personnelId}")
    public String synData(@PathVariable("personnelId") Long personnelId, ModelMap mmap)
    {
        //PerPersonnelinfo perPersonnelinfo = perPersonnelinfoService.selectPerPersonnelinfoById(personnelId);
        mmap.put("personnelId", personnelId);
        return prefix + "/synData";
    }

    /**
     * 下发数据人员信息
     */
    @PostMapping("/synData")
    @ResponseBody
    public AjaxResult synDataSave(String ids)
    {
        String[] arryId=ids.split(",");
        PerPersonnelinfo perPersonnelinfo = perPersonnelinfoService.selectPerPersonnelinfoById(Long.valueOf(arryId[0]));
        List<DevDeviceinfo> devDeviceinfos=new ArrayList<DevDeviceinfo>();
        for (int i=1;i<arryId.length;i++)
        {
            devDeviceinfos.add(iDevDeviceinfoService.selectDevDeviceinfoById(Long.valueOf(arryId[i])));
        }
        String ret=attendanceAPIService.faceDown(perPersonnelinfo,devDeviceinfos);
        if(!ret.equals(""))
           return error(ret);
        else
            return  toAjax(1);
    }
    /**
     * 修改保存人员信息
     */
    @RequiresPermissions("item:personnelinfo:edit")
    @Log(title = "人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerPersonnelinfo perPersonnelinfo)
    {
        return toAjax(perPersonnelinfoService.updatePerPersonnelinfo(perPersonnelinfo));
    }

  /** 删除人员信息 */
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    DevDeviceinfo devDeviceinfo = new DevDeviceinfo();
    List<DevDeviceinfo> devDeviceinfos =
        iDevDeviceinfoService.selectDevDeviceinfoList(devDeviceinfo);

    String[] arry = ids.split(",");
    for (String id : arry) {
      Long byId = Long.valueOf(id);
      PerPersonnelinfo perPersonnelinfo = perPersonnelinfoService.selectPerPersonnelinfoById(byId);
      String ss = attendanceAPIService.faceDelete(perPersonnelinfo, devDeviceinfos);
      if (!ss.equals("")) {
        return error(ss);
      }
      else
      {
          perPersonnelinfoService.deletePerPersonnelinfoById(byId);
      }
    }
    return toAjax(1);
    }
    /**~*/ /**~actionBegin*/
}
