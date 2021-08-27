package com.yang.service;

import com.yang.entity.User;

import java.util.Collection;

public interface UserService {
    public Collection<User> findAll();
    public User findById(Integer id);
    public void sava(User user);
    public void deleteById(Integer id);
    public void update(User user);
}
