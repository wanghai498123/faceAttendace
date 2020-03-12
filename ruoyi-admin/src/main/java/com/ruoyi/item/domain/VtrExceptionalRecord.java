package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 异常来访对象 vtr_exceptional_record
 * 
 * @author wanghai
 * @date 2020-02-28
 */
public class VtrExceptionalRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标识 */
    private Long recordId;

    /** 登记照片 */
    @Excel(name = "登记照片")
    private String registrationPhoto;

    /** 打卡照片 */
    @Excel(name = "打卡照片")
    private String punchCardPhotos;

    /** 打卡时间 */
    @Excel(name = "打卡时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date punchCardTime;

    /** 状态(进场，出场) */
    @Excel(name = "状态(进场，出场)")
    private String punchCardState;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setRegistrationPhoto(String registrationPhoto) 
    {
        this.registrationPhoto = registrationPhoto;
    }

    public String getRegistrationPhoto() 
    {
        return registrationPhoto;
    }
    public void setPunchCardPhotos(String punchCardPhotos) 
    {
        this.punchCardPhotos = punchCardPhotos;
    }

    public String getPunchCardPhotos() 
    {
        return punchCardPhotos;
    }
    public void setPunchCardTime(Date punchCardTime) 
    {
        this.punchCardTime = punchCardTime;
    }

    public Date getPunchCardTime() 
    {
        return punchCardTime;
    }
    public void setPunchCardState(String punchCardState) 
    {
        this.punchCardState = punchCardState;
    }

    public String getPunchCardState() 
    {
        return punchCardState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("registrationPhoto", getRegistrationPhoto())
            .append("punchCardPhotos", getPunchCardPhotos())
            .append("punchCardTime", getPunchCardTime())
            .append("punchCardState", getPunchCardState())
            .toString();
    }
}
