package com.yang.controller;

import com.yang.entity.User;
import com.yang.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepositoryImpl.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id){
        return userRepositoryImpl.findById(id);
    }

    //添加数据，使用PostMan进行测试
    @PostMapping("/save")//使用的restful风格，Get请求没有请求体，所以在这里需要使用Post请求，然后使用RequestBody对对象进行封装
    public int save(@RequestBody User user){
        return userRepositoryImpl.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") int id){
        return userRepositoryImpl.deleteById(id);
    }

    @PutMapping("/update")
    public int update(@RequestBody User user){
        return userRepositoryImpl.update(user);
    }
}
