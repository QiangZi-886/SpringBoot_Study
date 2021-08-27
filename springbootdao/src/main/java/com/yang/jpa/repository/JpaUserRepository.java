package com.yang.jpa.repository;

import com.yang.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * jpa封装好了基本的CRUD的方法，所以在不需要实现接口的情况下，就可以完成对数据库的操作。
 *      但是需要将自己定义好的接口继承JpaRepository<User, Integer> JPA封装好的接口，而且需要传进来两个泛型
 *      第一个泛型是：指自己的接口中方法的返回类型，即 User
 *      第二个泛型是：表格(t_user)中的主键类型
 */
public interface JpaUserRepository extends JpaRepository<User, Integer> {
    /**
     * 当常规的业务方法无法满足需求的时候，就需要在这个JpaUserRepository接口中进行扩充
     *      注意，扩充的方法只需要写出方法名即可，不需要具体实现。它会自动帮助实现（有够智能）
     * @return
     */
    public User findByUsername(String username);
}
