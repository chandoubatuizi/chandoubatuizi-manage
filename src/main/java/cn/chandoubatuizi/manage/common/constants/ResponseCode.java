package cn.chandoubatuizi.manage.common.constants;

public enum ResponseCode {

    SUCCESS(0, "success"),

    SERVICE_INNTER_ERROR(10001, "内部业务错误");

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
