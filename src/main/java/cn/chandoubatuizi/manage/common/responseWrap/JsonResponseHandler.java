package cn.chandoubatuizi.manage.common.responseWrap;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 通过代理RequestResponseBodyMethodProcessor，对@ResponseBody返回的JSON数据做封装处理
 */
public class JsonResponseHandler implements HandlerMethodReturnValueHandler {

    /**
     * 代理的Handler对象，一般是
     *
     * @see org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor
     */
    private HandlerMethodReturnValueHandler proxiedHandler;

    public JsonResponseHandler(HandlerMethodReturnValueHandler proxiedHandler) {
        this.proxiedHandler = proxiedHandler;
    }

    private boolean hasJsonResponseAnnotation(MethodParameter returnType) {
        return (AnnotationUtils.findAnnotation(returnType.getContainingClass(), JsonResponse.class) != null
                || returnType.getMethodAnnotation(JsonResponse.class) != null);
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return hasJsonResponseAnnotation(returnType) || proxiedHandler.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest) throws Exception {
        // 如果是@JsonResponse则对返回数据做二次包装
        if (hasJsonResponseAnnotation(returnType)) {
            JsonResponseWrap jsonResponseWrap = JsonResponseWrap.ofSuccess(returnValue);
            proxiedHandler.handleReturnValue(jsonResponseWrap, returnType, mavContainer, webRequest);
        } else if (proxiedHandler.supportsReturnType(returnType)) {
            proxiedHandler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
        }
    }
}
