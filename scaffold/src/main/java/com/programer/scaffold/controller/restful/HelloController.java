package com.programer.scaffold.controller.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>ClassName:     HelloController
 * <p>Description:   Controller类的第一个例子
 * <p>Author         xu jun
 * <p>Version        V1.0
 * <p>Date           2018/5/8
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }
}
