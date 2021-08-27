package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityHandler {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
