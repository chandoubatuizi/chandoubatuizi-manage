package cn.chandoubatuizi.manage.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * request上下文工具类
 */
public class HttpContextUtil {

    private static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获取HttpServletRequest
     * 
     * @return HttpServletRequest
     */
    public static HttpServletRequest getHttpServletRequest() {
        return getServletRequestAttributes().getRequest();
    }

    /**
     * 获取HttpServletResponse
     * 
     * @return HttpServletResponse
     */
    public static HttpServletResponse getHttpServletResponse() {
        return getServletRequestAttributes().getResponse();
    }

    /**
     * 获取请求URI
     * 
     * @return String
     */
    public static String getRequestURI() {
        return getHttpServletRequest().getRequestURI();
    }

    /**
     * 获取请求参数Map
     * 
     * @return
     */
    public static Map<String, String[]> getParameterMap() {
        return getHttpServletRequest().getParameterMap();
    }

    /**
     * 判断是否为ajax请求
     * 
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
    }
}
