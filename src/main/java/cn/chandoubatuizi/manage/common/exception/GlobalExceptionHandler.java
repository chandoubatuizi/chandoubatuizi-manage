package cn.chandoubatuizi.manage.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chandoubatuizi.manage.common.constants.ResponseCode;
import cn.chandoubatuizi.manage.common.responseWrap.JsonResponseWrap;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public JsonResponseWrap handlerError(ServiceException e) {
        logger.info("Service execution fail, full trace: ", e);
        return JsonResponseWrap.ofErrorCodeMessage(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(value = { MissingServletRequestParameterException.class })
    @ResponseBody
    public JsonResponseWrap errorHandler(MissingServletRequestParameterException e) {
        return JsonResponseWrap.ofErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = { Throwable.class })
    @ResponseBody
    public JsonResponseWrap errorHandler(Throwable e) {
        logger.error("Exception caught: ", e);
        return JsonResponseWrap.ofErrorCodeMessage(ResponseCode.INTERNAL_ERROR.getCode(), e.getMessage());
    }
}
