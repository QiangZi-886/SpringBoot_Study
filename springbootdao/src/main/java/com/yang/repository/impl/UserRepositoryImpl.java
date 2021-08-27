package com.yang.repository.impl;

import com.yang.entity.User;
import com.yang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    //这里的jdbcTemplate是框架自带的，以及注入了，不需要自己再手动来写JdbcTemplate.
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from t_user",
                new BeanPropertyRowMapper<>(User.class)//这里还需要new一个BeanPropertyRowMapper，需要指定好它的泛类型
        );
    }

    @Override
    public User findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from t_user where id = ?",
                new Object[]{id},
                new int[] {id},//还需要一个argType来指定传入参数类型
                new BeanPropertyRowMapper<>(User.class)
        );
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update(     //添加数据、对数据有变动都是使用的update，查询数据都是使用的query
                "insert into t_user(username,password) values (?,?)",
                user.getUsername(),
                user.getPassword()
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete from t_user where id = ?",
                id
        );
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "update t_user set username = ?,password = ? where id = ?",
                user.getUsername(),
                user.getPassword(),
                user.getId()
        );
    }
}
