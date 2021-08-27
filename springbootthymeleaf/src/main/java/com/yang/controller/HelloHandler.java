package com.yang.controller;

import com.yang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/hello")
public class HelloHandler {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("mess","Hello,My fist SpringBoot & Thymeleaf!!梁");
        return modelAndView;
    }

    //对thymeleaf静态模块中的标签“if”测试
    @GetMapping("/if")
    public ModelAndView iftest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("score",90);
        return modelAndView;
    }

    @GetMapping("/unless")
    public ModelAndView unlessTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("score",90);
        return modelAndView;
    }

    @GetMapping("/switch")
    public ModelAndView switchTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("studentId",1);
        return modelAndView;
    }

    //配置一个专门用来做映射的方法,这样在客户端直接按照"http://localhost:8080/hello/redirect/+需要放的html资源"就可以直接访问了
    @GetMapping("/redirect/{url}")
    public String redirect(@PathVariable("url") String url, Model model){
        model.addAttribute("url","/hello/login");
        return url;
    }


    @PostMapping("/login")
    @ResponseBody
    public String login(){
        return "login";
    }

    //each标签，遍历集合元素
    @GetMapping("/each")
    public ModelAndView eachTest(){
        List<User> list = Arrays.asList(
                new User(1,"杨涵琪"),
                new User(2,"小灰灰"),
                new User(3,"懒羊羊"),
                new User(4,"7(8)班")
        );

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/value")
    public ModelAndView value(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("value","SpringBoot");
        return modelAndView;
    }

    @GetMapping("/src")
    public ModelAndView src(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("src","/2.jpg");
        return modelAndView;
    }

    @GetMapping("/href")
    public ModelAndView href(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("href","http://www.baidu.com");
        return modelAndView;
    }

    @GetMapping("/select")
    public ModelAndView select(){
        List<User> list1 =  Arrays.asList(
                new User(1,"张三"),
                new User(2,"李四"),
                new User(3,"王五"),
                new User(4,"小灰灰")
        );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("list1",list1);
        modelAndView.addObject("id",4);
        return modelAndView;
    }

    @GetMapping("/servlet")
    public String servlet(HttpServletRequest request){
        request.setAttribute("value","request");
        request.getSession().setAttribute("value","session");
        request.getServletContext().setAttribute("value","servletContext");
        return "test";
    }

    @GetMapping("/servlet2")
    public ModelAndView servlet2(HttpSession session){
        session.setAttribute("name","小灰灰");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("name","偏爱");
        return modelAndView;
    }

    @GetMapping("/utility")
    public ModelAndView utility(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,7,31);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test1");
        //日期类
        modelAndView.addObject("date",new Date());
        //日期操作
        modelAndView.addObject("calendar",calendar);
        //数字
        modelAndView.addObject("numbers",0.520);
        //字符串
        modelAndView.addObject("string","I can't find you..");
        //布尔类型
        modelAndView.addObject("boolean",true);
        //数组
        modelAndView.addObject("array",Arrays.asList("小灰灰","懒羊羊","蕉太狼"));
        //List集合
        List<User> list2 = new ArrayList<>();
        list2.add(new User(1,"小灰灰"));
        list2.add(new User(2,"懒羊羊"));
        modelAndView.addObject("list2",list2);
        //set集合
        Set<User> set = new HashSet<>();
        set.add(new User(1,"小灰灰"));
        set.add(new User(2,"懒羊羊"));
        modelAndView.addObject("set",set);
        //map集合
        Map<Integer,User> map = new HashMap<>();
        map.put(1,new User(1,"小灰灰"));
        map.put(2,new User(2,"懒羊羊"));
        modelAndView.addObject("map",map);
        return modelAndView;
    }
}
