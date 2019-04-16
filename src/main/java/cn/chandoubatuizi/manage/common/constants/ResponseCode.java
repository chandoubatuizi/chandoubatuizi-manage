package cn.chandoubatuizi.manage.common.constants;

public enum ResponseCode {

    SUCCESS(0, "success"),

    ILLEGAL_ARGUMENT(10001, "非法参数"),

    INTERNAL_ERROR(10002, "内部错误");


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
