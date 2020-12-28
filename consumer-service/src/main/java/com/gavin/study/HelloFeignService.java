package com.gavin.study;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//指定了url就会访问该url地址，否则会把name参数当作服务名到注册中心中查询该名字服务，此时指定了url后可以随意命名
@FeignClient(name = "provider-service" , fallback = HelloFeignFallbackService.class, configuration = FeignConfiguration.class)
public interface HelloFeignService {

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

}
