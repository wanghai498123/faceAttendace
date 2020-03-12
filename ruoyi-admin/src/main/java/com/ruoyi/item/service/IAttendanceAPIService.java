package com.ruoyi.item.service;

import com.ruoyi.item.domain.DevDeviceinfo;
import com.ruoyi.item.domain.PerPersonnelinfo;

import java.util.List;

/**
 * 设备信息Service接口
 * 
 * @author wanghai
 * @date 2019-11-09
 */
public interface IAttendanceAPIService
{
    /**
     * 人脸下发
     *
     * @param devDeviceinfos 设备信息
     * @return 结果
     */
    public  String faceDown(PerPersonnelinfo perPersonnelinfo, List<DevDeviceinfo> devDeviceinfos);

    /**
     * 删除人脸
     *
     * @param devDeviceinfos 设备信息
     * @return 结果
     */
    public String faceDelete(PerPersonnelinfo perPersonnelinfo, List<DevDeviceinfo> devDeviceinfos);


    /**
     * 人证比对验证
     *
     * @param perPersonnelinfo 设备信息
     * @return 结果
     */
    public String personWitnessRatio(PerPersonnelinfo perPersonnelinfo, DevDeviceinfo devDeviceinfo);


    /**
     * 考勤数据产生
     *
     * @param attendanceData
     * @return 结果
     */
    public  void parseAttendanceData(String attendanceData);

    /**
     * 考勤数据产生
     *
     * @param attendanceData
     * @return 结果
     */
    public  String queryAllDevice();
    /**~*/ /**~actionBegin*/
}
