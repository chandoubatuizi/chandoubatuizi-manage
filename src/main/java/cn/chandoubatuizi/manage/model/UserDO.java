package cn.chandoubatuizi.manage.model;

import java.util.Date;

public class UserDO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别 0男 1女
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后IP
     */
    private String lastLoginIp;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 0锁定 1正常
     */
    private Integer status;

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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "UserDO{" + "id=" + id + ", loginName='" + loginName + '\'' + ", deptId=" + deptId + ", nickName='"
                + nickName + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", sex=" + sex
                + ", avatar='" + avatar + '\'' + ", password='" + password + '\'' + ", salt='" + salt + '\''
                + ", lastLoginTime=" + lastLoginTime + ", lastLoginIp='" + lastLoginIp + '\'' + ", description='"
                + description + '\'' + ", status=" + status + ", createTime=" + createTime + ", updateTime="
                + updateTime + '}';
    }
}