package cn.chandoubatuizi.manage.common.responseWrap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
class ReturnValueConfig implements InitializingBean {

    @Resource(name = "requestMappingHandlerAdapter")
    private RequestMappingHandlerAdapter handlerAdapter;


    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> list = handlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newList = new ArrayList<>(list.size());
        for (HandlerMethodReturnValueHandler handler : list) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                newList.add(new JsonResponseHandler(handler));
            } else {
                newList.add(handler);
            }
        }
        handlerAdapter.setReturnValueHandlers(newList);
    }
}
