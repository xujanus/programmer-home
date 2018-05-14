package com.programer.scaffold.controller.restful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>ClassName:     HelloController
 * <p>Description:   Controller类的第一个例子
 * <p>Author         xu jun
 * <p>Version        V1.0
 * <p>Date           2018/5/8
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class HelloController {
    @Value("${test.text}")
    private String textInSysConfig;

    @Value("${spring.application.name}")
    private String serviceId;

    final
    DiscoveryClient discoveryClient;

    @Autowired
    public HelloController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }

    @RequestMapping("/sys-config/test")
    public String sysConfigTest() {
        return textInSysConfig;
    }

    @RequestMapping("/service-register/test")
    public String serviceRegisterTest() {
        //输出服务列表
        List service_name_list = discoveryClient.getServices();
        log.info("service name list:" + service_name_list);

        List<ServiceInstance> service_list = discoveryClient.getInstances(serviceId);
        for(ServiceInstance temp : service_list){
            log.info("uri={}，serviceId={}，result={}", temp.getUri(), temp.getServiceId(), temp);
        }

        return "Hello eureka!";
    }
}
