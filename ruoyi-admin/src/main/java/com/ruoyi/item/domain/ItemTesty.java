package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 部门对象 item_testy
 * 
 * @author wanghai
 * @date 2020-03-11
 */
public class ItemTesty extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Long testyId;
    /** 部门名称 */
    @Excel(name = "部门名称")
    private String testyName;
    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;
    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;
    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;
    /** 部门状态（0正常 1停用） */
    @Excel(name = "部门状态", readConverterExp = "0=正常,1=停用")
    private String status;
    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
    /** 机构类型（0公司 1部门 2分组） */
    @Excel(name = "机构类型", readConverterExp = "0=公司,1=部门,2=分组")
    private String deptType;

    public void setTestyId(Long testyId) 
    {
        this.testyId = testyId;
    }
    public Long getTestyId() 
    {
        return testyId;
    }
    public void setTestyName(String testyName) 
    {
        this.testyName = testyName;
    }
    public String getTestyName() 
    {
        return testyName;
    }
    public void setLeader(String leader) 
    {
        this.leader = leader;
    }
    public String getLeader() 
    {
        return leader;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }
    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }
    public String getEmail() 
    {
        return email;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }
    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }
    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setDeptType(String deptType) 
    {
        this.deptType = deptType;
    }
    public String getDeptType() 
    {
        return deptType;
    }


    /** 用户是否存在此标识 默认不存在 用于多选时选中*/
    private boolean flag = false;
    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .toString();
    }
}
