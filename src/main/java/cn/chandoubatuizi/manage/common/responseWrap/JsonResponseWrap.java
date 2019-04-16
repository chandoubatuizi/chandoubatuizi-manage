package cn.chandoubatuizi.manage.common.responseWrap;

import cn.chandoubatuizi.manage.common.constants.ResponseCode;

public class JsonResponseWrap<T> {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public JsonResponseWrap(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public JsonResponseWrap(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> JsonResponseWrap ofSuccess(T data) {
        return new JsonResponseWrap<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> JsonResponseWrap ofErrorCodeMessage(int code, String message) {
        return new JsonResponseWrap<>(code, message);
    }
}
