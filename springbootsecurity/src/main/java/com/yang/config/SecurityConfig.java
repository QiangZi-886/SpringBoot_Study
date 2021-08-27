package com.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration      //配置类注解
@EnableWebSecurity      //开启基于web的安全验证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 设置角色和资源的关系
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")//拥有ADMIN角色的用户可以访问admin.html
                .antMatchers("/index").access("hasRole('ADMIN') or hasRole('USER')")//不管是拥有ADMIN还是USER的用户都可以访问index
                .anyRequest().authenticated()//表示任何请求都要验证
                .and()
                .formLogin()//表示需要配置它的登录信息
                .loginPage("/login")//指定登录页面(现在是自己定义的一个页面,不使用默认的登录界面了)
                .permitAll()//请求不需要验证(还没登录，角色还未赋予，所以登录的时候不需要验证)
                .and()
                .logout()//表示有可以退出的功能
                .permitAll()//表示关于退出的请求也都不验证
                .and()
                .csrf()
                .disable();//关闭csrf这个组件

    }

    /**
     *  这里设置不同的角色
     *  设置用户和角色的关系
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("user").password(new MyPasswordEncoder()
                .encode("000")).roles("USER")//将角色赋予USER，如果想要再创建角色就需要使用and接着连接
                .and().withUser("admin").password(new MyPasswordEncoder()
                .encode("123")).roles("ADMIN","USER");//拥有两个角色就可以访问admin和user的全部部分，拥有一个角色就只能访问一个角色的内容
    }
}
