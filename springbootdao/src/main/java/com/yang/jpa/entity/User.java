package com.yang.jpa.entity;

import lombok.Data;

import javax.persistence.*;


/**
 *      底层是Hibernate实现的
 * jpa是一个全自动的ROM框架，所以这里需要对表格和实体类做一个映射
 */

@Data
@Entity(name = "t_user")//指向自己的表格名称
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//指定主键为自增
    private int id;
    @Column
    private String username;
    @Column
    private String password;
}
