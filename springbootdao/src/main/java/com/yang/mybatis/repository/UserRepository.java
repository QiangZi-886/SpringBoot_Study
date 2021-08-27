package com.yang.mybatis.repository;

import com.yang.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
    public User findById(int id);
    public int save(User user);
    public int deleteById(int id);
    public int update(User user);
}
