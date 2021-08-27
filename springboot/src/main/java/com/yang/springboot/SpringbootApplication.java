package com.yang.springboot;

import com.yang.springboot.controller.HelloHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * spring boot 默认的启动类
 *      启动类必须覆盖所有与业务相关的类：启动类所在的包必须是业务类所在的包的同包或父包，如果没有覆盖，业务类就不会自动装配到IOC容器中
 *
 * @SpringBootApplication注解，可以拆开成@SpringBootConfiguration、@EnableAutoConfiguration和@ComponentScan
 *      其中@ComponentScan就是指扫描的包的路径，默认的就是指向拥有@SprringBootApplication注解的包，但是也可以自己指定，
 *      比如：@ComponentScan(com.yang.controller)那么扫描的路径就更改为了controller包下的HelloHandler类，IOC容器
 *      中就会只存在HelloHandler这一个bean对象了（原来是拥有两个：HelloHandler、SpringBootApplication）
 *
 *
 * 注意：这里的@ComponentScan，它就表明了，我们的springboot包不一定非要全部覆盖所有的业务类，也可以通过手动配置@ComponentScan
 *      来进行包位置的更改
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        //应用上下文（可以理解成IOC，因为可以从Application中获取bean对象）
        ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
        //在ApplicationContext中通过类型获取bean，可以看到，HelloHandler确实被装配进了IOC容器中，成为了一个bean对象
        HelloHandler helloHandler = context.getBean(HelloHandler.class);
        System.out.println(helloHandler);
    }

}
