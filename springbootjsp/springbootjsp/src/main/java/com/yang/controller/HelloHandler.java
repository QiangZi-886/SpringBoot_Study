package com.yang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//注意这里的controller注解不能是RestController了，因为需要带上jsp视图，@RestHandler只会直接返回数据，它适用于前后端分离的异步交互。
@RequestMapping("/hello")
public class HelloHandler {

    @RequestMapping("/first")
    public ModelAndView first(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("first");
        modelAndView.addObject("mess","hello,my first springboot & jsp!");
        return modelAndView;
    }

}
