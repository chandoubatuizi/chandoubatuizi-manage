package cn.chandoubatuizi.manage.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import cn.chandoubatuizi.manage.common.annotation.Log;
import cn.chandoubatuizi.manage.common.constant.ResponseCode;
import cn.chandoubatuizi.manage.common.exception.ServiceException;
import cn.chandoubatuizi.manage.common.responseWrap.JsonResponse;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private Producer captchaProducer;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @JsonResponse
    public void ajaxLogin(String loginName, String password, String code, boolean rememberMe) throws ServiceException {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!sessionCode.equals(code)) {
            throw new ServiceException(ResponseCode.LOGIN_ERROR.getCode(), "验证码错误");
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName, password, rememberMe);

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

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream out = null;
        try {
            HttpSession session = request.getSession();
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");

            String text = captchaProducer.createText();
            BufferedImage image = captchaProducer.createImage(text);

            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
            out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
        } catch (Exception e) {
            LOGGER.error("验证码生成异常", e);
        } finally {
            IOUtils.closeQuietly(out);
        }

    }
}
