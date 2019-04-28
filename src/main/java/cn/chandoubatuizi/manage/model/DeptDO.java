package cn.chandoubatuizi.manage.model;

import java.util.Date;

public class DeptDO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 父级部门ID 第一级为0
     */
    private Integer parentId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DeptDO{" + "id=" + id + ", parentId=" + parentId + ", deptName='" + deptName + '\'' + ", createTime="
                + createTime + ", updateTime=" + updateTime + '}';
    }
}