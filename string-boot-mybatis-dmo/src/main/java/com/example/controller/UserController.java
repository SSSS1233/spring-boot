package com.example.controller;

import com.example.po.User;
import com.example.po.UserExpand;
import com.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SUBING on 2018/4/4.
 */
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/index")
    public String index(Model m, HttpSession session) {
        m.addAttribute("demo","hello");
        session.setAttribute("name","宿冰");
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model m, HttpSession session) {
        return "login";
    }
    @RequestMapping("/add.do")
    public String addUser(User user) {
        userService.insert(user);
        return "index";
    }
     @ResponseBody
     @RequestMapping("/checks.do")
     public Map<String,Object> checks(User user)
     {
         System.out.println(user.getName()+" "+user.getPassword());
         Map<String,Object> map=new HashMap<>();
        if(userService.selectName(user)!=null)
        {
            if(user.getPassword().equals(userService.selectpass(user)))
            {
                map.put("message","用户存在");
            }
            else {
                map.put("message","密码错误");
            }

        }else {
           map.put("message","用户不存在");
        }
        return map;
     }
    @ResponseBody
    @RequestMapping("/check.do")
    public List<User> check(UserExpand user) {
        System.out.println(user.getNum()+"PAGE");
        List l = userService.selectAll(user.getNum(), 2);
        System.out.println(l.size());
        return l;
    }

}
