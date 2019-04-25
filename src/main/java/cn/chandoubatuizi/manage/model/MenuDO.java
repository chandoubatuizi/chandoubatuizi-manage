package cn.chandoubatuizi.manage.model;

import java.util.Date;

public class MenuDO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 菜单/按钮名称
     */
    private String menuName;

    /**
     * 父级菜单ID 顶级菜单为0
     */
    private Integer parentId;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 类型 0菜单 1按钮
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单排序 按钮为-1
     */
    private Integer orderNum;

    /**
     * 权限标识
     */
    private String perms;

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


    public String getMenuName() {
        return menuName;
    }


    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public Integer getParentId() {
        return parentId;
    }


    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public Integer getType() {
        return type;
    }


    public void setType(Integer type) {
        this.type = type;
    }


    public String getIcon() {
        return icon;
    }


    public void setIcon(String icon) {
        this.icon = icon;
    }


    public Integer getOrderNum() {
        return orderNum;
    }


    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }


    public String getPerms() {
        return perms;
    }


    public void setPerms(String perms) {
        this.perms = perms;
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
}