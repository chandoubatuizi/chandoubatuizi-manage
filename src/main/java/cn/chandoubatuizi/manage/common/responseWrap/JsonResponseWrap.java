package cn.chandoubatuizi.manage.common.responseWrap;

import cn.chandoubatuizi.manage.common.constants.ResponseCode;

public class JsonResponseWrap<T> {

    private int code;

    private String message;

    private T data;

    public JsonResponseWrap(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> JsonResponseWrap ofSuccess(T data) {
        return new JsonResponseWrap<>(ResponseCode.SUCCESS.getCode(), data);
    }
}
