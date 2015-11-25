package cn.easyui.web;

import cn.easyui.domain.User;
import cn.easyui.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static cn.common.util.StringUtil.toJson;

/**
 * Created by Sun on 2015/11/19.
 */
@Controller
@RequestMapping
public class MybatisController {
    Log log = LogFactory.getLog(getClass());
    Logger log4=Logger.getLogger(getClass());
    @Autowired
    private UserService userService;

    @RequestMapping(value="/myq.html")
    public String loginPage(){
        User user=userService.queryUserById(1);
        System.out.println(user);
        log.info(user.getUserName());
        log4.info(user.getUserName());
        return "login";
    }

    @RequestMapping(value="/insert.html")
    public String insertUser(){
        User user=new User();
        user.setUserName("zhangsan");
        user.setPassword("111111");
        userService.insertUser(user);
        log.info("插入成功");
        log4.info("插入陈功");
        return "login";
    }

    @RequestMapping(value = "/selectAll.html")
    @ResponseBody
    public String selectAll(){
       List<User> ulist=  userService.selectAllUser();
        for(Object list:ulist){
            System.out.println(list);
        }
       return toJson(ulist);
    }

    @RequestMapping(value="/table.html")
    public String table(){
        return "table";
    }

    @RequestMapping(value="/table2.html")
    public String table2(){
        return "table2";
    }

    @RequestMapping(value="/home.html")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/edit/{Id}.html")
    public String edit(HttpServletRequest req,
                       @PathVariable("Id") Integer Id) throws Exception {
        User userInfo = userService.queryUserById(Id);
        req.setAttribute("user", userInfo);
        return "edit";
    }
}
