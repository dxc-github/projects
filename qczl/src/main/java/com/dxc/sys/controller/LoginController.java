package com.dxc.sys.controller;

import com.dxc.sys.contast.SysConstast;
import com.dxc.sys.entity.User;
import com.dxc.sys.service.UserService;
import com.dxc.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/main/login";
    }

    @RequestMapping("login")
    public String login(User user, Model model){
        String code = WebUtils.getHttpSession().getAttribute("code").toString();
//        if (userVo.getCode().equals(code)){
        User u = userService.login(user);
//            System.out.println(user);
        if (null!=u){
            //放到session
            WebUtils.getHttpSession().setAttribute("user",user);

            //记录登陆日志 向sys_log_login里面插入数据
            //日志功能会在后面实现,这里做一个标记


            return "system/main/index";
        }else {
            model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
            return "system/main/login";
        }
//        }else {
//            model.addAttribute("error", SysConstast.USER_LOGIN_CODE_ERROR_MSG);
//            return "system/main/login";
//        }
    }
}
