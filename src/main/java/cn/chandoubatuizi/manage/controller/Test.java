package cn.chandoubatuizi.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chandoubatuizi.manage.common.annotation.Log;
import cn.chandoubatuizi.manage.common.exception.ServiceException;
import cn.chandoubatuizi.manage.core.service.TestService;
import cn.chandoubatuizi.manage.model.UserDO;

@Controller
@RequestMapping("/test")
public class Test {

    @Autowired
    private TestService userService;

    @ResponseBody
    @RequestMapping("/test1")
    public void test() throws ServiceException {
        userService.create();
    }

    @Log("test22222")
    @ResponseBody
    @RequestMapping("/test2")
    public UserDO test2(UserDO user) {
        return userService.select();
    }
}
