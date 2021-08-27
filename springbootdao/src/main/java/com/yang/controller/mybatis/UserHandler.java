package com.yang.controller.mybatis;

import com.yang.entity.User;
import com.yang.mybatis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "mybatisHandler")
@RequestMapping("/mybatisUser")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @PostMapping("/save")
    public int save(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/update")
    public int update(@RequestBody User user){
        return userRepository.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") int id){
        return userRepository.deleteById(id);
    }
}
