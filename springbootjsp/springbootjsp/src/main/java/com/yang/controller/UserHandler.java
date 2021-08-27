package com.yang.controller;

import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;


    @GetMapping("/findAll")
    public ModelAndView findAll(){
//        User user1 = new User(1,"杨杨杨");
//        User user2 = new User(2,"刘刘刘");
//        User user3 = new User(3,"梁梁梁");
//        List<User> list = Arrays.asList(user1,user2,user3);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("list",userService.findAll());
        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }


    //添加数据，使用的是PostMapping
    @PostMapping("/save")
    public String save(User user){
        userService.sava(user);
        return "redirect:/user/findAll"; //返回的字符串通过资源重定向的方式，返回到findAll，对数据重新查询且输出到页面
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/user/findAll";
    }

    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user/findAll";
    }


}
