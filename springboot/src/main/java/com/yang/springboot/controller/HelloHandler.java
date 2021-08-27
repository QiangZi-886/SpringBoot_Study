package com.yang.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloHandler {

    @GetMapping("/index")
    public String index(){
        return "hello my first springboot project!!";
    }

    /**
     * 如果想在Handler中直接打印输出properties中的一些属性值，就需要通过@Value注释，括号中使用EL表达式
     *      SpEL Spring Expression Language （核心包中的一个模块）
     */
    @Value("${server.tomcat.uri-encoding}")
    private String code;

    @GetMapping("/test")
    public String test(){
        return "当前服务的编码格式是:"+this.code;
    }
}
