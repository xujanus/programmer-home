package com.programmer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * <p>ClassName:     ConsumerController
 * <p>Description:   测试消费服务的例子
 * <p>Author         xu jun
 * <p>Version        V1.0
 * <p>Date           2018/5/14
 */
@RestController
@RequestMapping("/api")
public class ConsumerController {

    final
    RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://SCAFFOLD-SERVICE/api/service-register/test", String.class).getBody();
    }

}
