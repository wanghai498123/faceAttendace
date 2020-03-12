package com.ruoyi.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.item.domain.ItemTesty;

/**
 * 测试对象 item_testx
 * 
 * @author wanghai
 * @date 2020-03-12
 */
public class ItemTestx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long testxId;
    /** 名称 */
    @Excel(name = "名称")
    private String testxName;
    /** 描叙 */
    @Excel(name = "描叙")
    private String script;
    /** 部门 */
    private Long testyId;

    public void setTestxId(Long testxId) 
    {
        this.testxId = testxId;
    }
    public Long getTestxId() 
    {
        return testxId;
    }
    public void setTestxName(String testxName) 
    {
        this.testxName = testxName;
    }
    public String getTestxName() 
    {
        return testxName;
    }
    public void setScript(String script) 
    {
        this.script = script;
    }
    public String getScript() 
    {
        return script;
    }
    public void setTestyId(Long testyId) 
    {
        this.testyId = testyId;
    }
    public Long getTestyId() 
    {
        return testyId;
    }

    private ItemTesty testy;
    public void setTesty(ItemTesty testy)
    {
        this.testy = testy;
    }
    public ItemTesty getTesty()
    {
        return testy;
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
