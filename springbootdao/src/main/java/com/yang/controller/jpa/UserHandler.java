package com.yang.controller.jpa;

import com.yang.jpa.entity.User;
import com.yang.jpa.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "myJpaHandler")
@RequestMapping("/jpaUser")
public class UserHandler {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return jpaUserRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id){
        //这里封装的findById方法的返回值是一个option类型，防止空指针报错，所以需要使用.get()调用返回值类型，这样类型就匹配得上了
        return jpaUserRepository.findById(id).get();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        jpaUserRepository.save(user);
    }

    @PutMapping("update")
    public void update(@RequestBody User user){
        //注意：这里没有update方法，而是和save()添加方法集成到一起，在表格中查询，如果不存在就添加，存在就修改
        jpaUserRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        jpaUserRepository.deleteById(id);
    }

    //非常规的方法，在接口中定义好之后，来这里调用测试
    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return jpaUserRepository.findByUsername(username);
    }
}
