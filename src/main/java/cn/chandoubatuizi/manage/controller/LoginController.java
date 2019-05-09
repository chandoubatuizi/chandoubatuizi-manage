package cn.chandoubatuizi.manage.controller;

import cn.chandoubatuizi.manage.common.annotation.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chandoubatuizi.manage.common.responseWrap.JsonResponse;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @JsonResponse
    public void ajaxLogin(String loginName, String password, boolean rememberMe) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
    }

    @RequestMapping("/")
    public String redirect2Home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/403")
    public String unAuth() {
        return "error/403";
    }

    @Log("日志测试")
    @RequestMapping("/auth/test")
    @ResponseBody
    public String test() {
        return "=========test==========";
    }
}
