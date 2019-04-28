package cn.chandoubatuizi.manage.model;

import java.util.Date;

public class LogDO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 操作用户（登录名）
     */
    private String loginName;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 方法参数
     */
    private String params;

    /**
     * 操作者IP
     */
    private String ip;

    /**
     * 操作者地点
     */
    private String location;

    /**
     * 耗时 ms
     */
    private Integer time;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LogDO{" + "id=" + id + ", operation='" + operation + '\'' + ", loginName='" + loginName + '\''
                + ", url='" + url + '\'' + ", method='" + method + '\'' + ", params='" + params + '\'' + ", ip='" + ip
                + '\'' + ", location='" + location + '\'' + ", time=" + time + ", createTime=" + createTime + '}';
    }
}