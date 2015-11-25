package cn.easyui.web;

import cn.easyui.domain.User;
import cn.easyui.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Sun on 2015/11/3.
 */
//Spring MVC Controller
@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @RequestMapping(value="/login.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,User user){
        boolean isValidUser= userServiceImpl.hasMatchUser(user.getUserName(),user.getPassword());
        if(!isValidUser){
            return new ModelAndView("login" ,"error","用户名或密码错误");
        }else{
            User user1= userServiceImpl.findUserByUserName(user.getUserName());
            user1.setLastIp(request.getRemoteAddr());
            user1.setLastVisit(new Date());
            userServiceImpl.loginSuccess(user1);
            request.getSession().setAttribute("user",user1);
            System.out.println(request.getSession());
            return new ModelAndView("main");
        }
    }
}
