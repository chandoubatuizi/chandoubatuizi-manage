package cn.chandoubatuizi.manage.common.constant;

public enum ResponseCode {

    SUCCESS(0, "success"),

    ILLEGAL_ARGUMENT(10001, "非法参数"),

    INTERNAL_ERROR(10002, "内部错误"),

    LOGIN_ERROR(10003, "登录错误"),

    NO_PERMISSION(10004, "暂无权限，请联系系统管理员");

    private int code;

    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
