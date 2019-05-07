package cn.chandoubatuizi.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "121212121212";
    }

    @RequestMapping("/")
    public String redirect2Home() {
        return "index";
    }
}
