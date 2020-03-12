package com.ruoyi.item.service.impl;


import com.ruoyi.item.domain.DevDeviceinfo;
import com.ruoyi.item.domain.PerPersonnelinfo;
import com.ruoyi.item.mapper.PerPersonnelinfoMapper;
import com.ruoyi.item.service.IAttendanceAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 业务接口业务层处理
 * 
 * @author wanghai
 * @date 2019-11-09
 */
@Service
public class AttendanceAPIServiceImpl implements IAttendanceAPIService
{
        //private  String url= Global.getApiPost();
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        private static final Logger log = LoggerFactory.getLogger(AttendanceAPIServiceImpl.class);


    @Autowired
    private PerPersonnelinfoMapper perPersonnelinfoMapper;

    @Override
    public String faceDown(PerPersonnelinfo perPersonnelinfo, List<DevDeviceinfo> devDeviceinfos) {
        StringBuilder ret=new StringBuilder();
//        StringBuilder cmd = new StringBuilder();
//        String Base64String="";
//
//        for (DevDeviceinfo devDeviceinfo : devDeviceinfos) {
//            try
//            {
//                cmd.append("{");
//                cmd.append("\"token_id\": \""+UUID.randomUUID().toString()+"\","); // 令牌id"
//                cmd.append("\"device_ip\": \""+devDeviceinfo.getIpAddress()+"\","); // 设备ip
//                cmd.append("\"cmdType\": \"AddFace\","); // 命令类型"
//                cmd.append("\"person_id\": \""+perPersonnelinfo.getPersonnelId()+"\","); // 人员ID
//                cmd.append("\"requst_time\": \""+sdf.format(new Date())+"\","); // 请求时间"
//                cmd.append("\"person_name\": \""+perPersonnelinfo.getPersonnelName()+"\","); // 人员姓名
//                cmd.append("\"wg_no\": \"0\","); // 韦根卡号"
//                cmd.append("\"effect_starttime\": \""+sdf.format(perPersonnelinfo.getApproachTime())+"\","); // 开始时间
//                cmd.append("\"effectTime\": \""+sdf.format(perPersonnelinfo.getValidity())+"\","); // 到期时间
//                cmd.append("\"schedule_mode\": \"0\","); // 调度模式
//                cmd.append("\"person_role\": \"0\","); // 人员角色
//                cmd.append("\"user_param\": \"\","); // 用户备注
//                cmd.append("\"pic_data\": \"" + FileToBase64.encodeBase64File(perPersonnelinfo.getFacePath()) + "\""); // 人脸图片
//                cmd.append("}");
//                //System.out.println(cmd);
//
//                String ss= HttpUtils.doJsonPost(url, cmd.toString());
//                System.out.println(ss);
//                JSONObject object = JSONObject.parseObject(ss);
//                String device_ip=object.getString("device_ip");
//                String err_state=object.getString("err_state");
//                boolean isSYN=true;
//
//                if (err_state.equals("1")) {
//                    ret.append(object.getString("err_note"));
//                    isSYN=false;
//                } else {
//                   if(!object.getJSONObject("data_buf").getString("execute_state").equals("1"))
//                    {
//                        ret.append(device_ip+"同步失败！");
//                        isSYN=false;
//                    }
//                }
//                if(isSYN)
//                    perPersonnelinfo.setDataState("成功");
//                else
//                    perPersonnelinfo.setDataState("失败");
//                System.out.println("下发状态"+ret.toString());
//                perPersonnelinfoMapper.updatePerPersonnelinfo(perPersonnelinfo);
//
//                cmd = new StringBuilder();
//            }
//            catch (Exception e)
//            {
//                log.error("异常", e);
//            }
//        }
        return ret.toString();
    }

    @Override
    public String faceDelete(PerPersonnelinfo perPersonnelinfo, List<DevDeviceinfo> devDeviceinfos) {
        StringBuilder ret=new StringBuilder();
//        StringBuilder cmd = new StringBuilder();
//        for (DevDeviceinfo devDeviceinfo : devDeviceinfos) {
//            try
//            {
//                cmd.append("{");
//                cmd.append("\"token_id\": \""+UUID.randomUUID().toString()+"\","); // 令牌id"
//                cmd.append("\"device_ip\": \""+devDeviceinfo.getIpAddress()+"\","); // 设备ip"
//                cmd.append("\"cmdType\": \"DeleteFace\","); // 命令类型"
//                cmd.append("\"person_id\": \""+perPersonnelinfo.getPersonnelId()+"\","); // 人员ID"
//                cmd.append("\"requst_time\": \""+sdf.format(new Date())+"\""); // 请求时间"
//                cmd.append("}");
//                System.out.println(cmd);
//
//                String ss= HttpUtils.doJsonPost(url, cmd.toString());
//                System.out.println(ss);
//                JSONObject object = JSONObject.parseObject(ss);
//
//                String device_ip=object.getString("device_ip");
//                String err_state=object.getString("err_state");
//                boolean isSYN=true;
//
//                if (err_state.equals("1")) {
//                    ret.append(object.getString("err_note"));
//                    isSYN=false;
//                } else {
//                    if(!object.getJSONObject("data_buf").getString("execute_state").equals("1"))
//                    {
//                        ret.append(device_ip+"同步失败！");
//                        isSYN=false;
//                    }
//                }
//                if(isSYN)
//                    perPersonnelinfo.setDataState("成功");
//                else
//                    perPersonnelinfo.setDataState("失败");
//                System.out.println("删除下发状态"+ret.toString());
//                perPersonnelinfoMapper.updatePerPersonnelinfo(perPersonnelinfo);
//
//                cmd = new StringBuilder();
//            }
//            catch (Exception e)
//            {
//                log.error("异常", e);
//            }
//        }
        return ret.toString();
    }

    @Override
    public String personWitnessRatio(PerPersonnelinfo perPersonnelinfo, DevDeviceinfo devDeviceinfo) {
        StringBuilder ret=new StringBuilder();
//        StringBuilder cmd = new StringBuilder();
//
//        try
//        {
//            cmd.append("{");
//            cmd.append("\"token_id\": \""+UUID.randomUUID().toString()+"\","); // 令牌id"
//            cmd.append("\"device_ip\": \""+devDeviceinfo.getIpAddress()+"\","); // 设备ip"
//            cmd.append("\"cmdType\": \"WitnessVerification\","); // 命令类型"
//            cmd.append("\"person_id\": \""+perPersonnelinfo.getPersonnelId()+"\","); // 人员ID"
//            cmd.append("\"requst_time\": \""+sdf.format(new Date())+"\""); // 请求时间"
//            cmd.append("}");
//            System.out.println(cmd);
//
//            JSONObject object = JSONObject.parseObject(HttpUtils.doJsonPost(url, cmd.toString()));
//            String device_ip=object.getString("device_ip");
//            object=object.getJSONObject("data_buf");
//            System.out.println(object.getString("verify_result").equals("1")?"人证验证成功":"人证验证失败");
//
//            cmd = new StringBuilder();
//        }
//        catch (Exception e)
//        {
//            log.error("异常", e);
//        }
        return ret.toString();
    }

    @Override
    public String queryAllDevice() {
        StringBuilder ret=new StringBuilder();
//        StringBuilder cmd = new StringBuilder();
//        cmd.append("{");
//        cmd.append("\"token_id\": \""+UUID.randomUUID().toString()+"\","); // 令牌id"
//        cmd.append("\"cmdType\": \"QueryAllDevice\","); // 命令类型"
//        cmd.append("\"requst_time\": \""+sdf.format(new Date())+"\""); // 请求时间"
//        cmd.append("}");
//        System.out.println(cmd);
//
//        String ss= HttpUtils.doJsonPost(url, cmd.toString());
//        System.out.println(ss);
//        JSONObject object = JSONObject.parseObject(ss);
//
//        String device_ip=object.getString("device_ip");
//        String err_state=object.getString("err_state");
//        boolean isSYN=true;
//
//        if (err_state.equals("1")) {
//            ret.append(object.getString("err_note"));
//            isSYN=false;
//        } else {
//            String ip=object.getJSONObject("data_buf").getString("ip");
//            String manufacturer=object.getJSONObject("data_buf").getString("manufacturer");
//            String mac=object.getJSONObject("data_buf").getString("mac");
//        }
//        System.out.println("删除下发状态"+ret.toString());
        return ret.toString();

    }

    @Override
    public void parseAttendanceData(String attendanceData) {
//        try
//        {
//            JSONObject object = JSONObject.parseObject(attendanceData);
//            RecRecord recRecord=new RecRecord();
//            Long personnelId=object.getLong("personnel_id");
//            recRecord.setPersonnelId(personnelId);  //人员ID
//            //recRecord.setPersonnelId(object.getLong("person_role"));  //人员权限
//            //recRecord.setPersonnelId(object.getLong("device_sn"));  //设备唯一序列号
//            String punch_card_photos=object.getString("punch_card_photos"); //抓拍图像
//            recRecord.setPunchCardTime(sdf.parse(object.getString("punch_card_time")));  //抓拍时间
//            recRecord.setPunchCardState(object.getString("punch_card_state"));  //打卡状态
//            //写入base64的图片文件
//            String fileName= Global.getUploadPath() + "/" + UUID.randomUUID().toString()+".txt";
//            recRecord.setPunchCardPhotos(fileName);
//            FileWriter writer = new FileWriter(fileName);
//            writer.write(punch_card_photos);
//            writer.flush();
//            writer.close();
//            //查询人员基本数据
//            PerPersonnelinfo perPersonnelinfo=perPersonnelinfoMapper.selectPerPersonnelinfoById(personnelId);
//            recRecord.setPersonnelName(perPersonnelinfo.getPersonnelName());
//            recRecord.setDeptName(perPersonnelinfo.getDeptName());
//            recRecord.setDeptId(perPersonnelinfo.getDeptId());
//            recRecord.setTeamName(perPersonnelinfo.getDeptName());
//            recRecordMapper.insertRecRecord(recRecord);
//            //生成考勤日报
//        }
//        catch (Exception e)
//        {
//            log.error("异常", e);
//        }
    }


}
