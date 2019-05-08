package cn.chandoubatuizi.manage.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.chandoubatuizi.manage.common.constant.ResponseCode;
import cn.chandoubatuizi.manage.common.responseWrap.JsonResponseWrap;
import cn.chandoubatuizi.manage.common.util.HttpContextUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 登录异常处理器
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = { AuthenticationException.class })
    @ResponseBody
    public Object handleAuthenticationException(HttpServletRequest request, AuthenticationException e) {
        if (HttpContextUtil.isAjaxRequest(request)) {
            return JsonResponseWrap.ofErrorCodeMessage(ResponseCode.LOGIN_ERROR.getCode(), e.getMessage());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/login");
            return modelAndView;
        }
    }

    /**
     * 权限异常处理
     * 
     * @param request
     * @return
     */
    @ExceptionHandler(value = { AuthorizationException.class })
    @ResponseBody
    public Object handleAuthorizationException(HttpServletRequest request) {
        if (HttpContextUtil.isAjaxRequest(request)) {
            return JsonResponseWrap.ofErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(),
                    ResponseCode.NO_PERMISSION.getMessage());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/error/404");
            return modelAndView;
        }
    }

    @ResponseBody
    @ExceptionHandler(value = { ServiceException.class })
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
