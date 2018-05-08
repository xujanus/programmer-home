package com.programer.scaffold.controller.restful;

import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/api")
public class HelloController {
    @Value("${test.text}")
    private String textInSysConfig;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }

    @RequestMapping("/sys-config/test")
    public String sysConfigTest() {
        return textInSysConfig;
    }
}
