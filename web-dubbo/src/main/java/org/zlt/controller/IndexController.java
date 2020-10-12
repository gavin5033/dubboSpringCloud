package org.zlt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello(String name){
        return "hi " + name;
    }

    @RequestMapping("/timeout")
    public String timeout(){
        try{
            //睡5秒，网关Hystrix3秒超时
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "timeout";
    }

    @RequestMapping("/timeout2")
    public String timeout2(){
        try{
            //睡5秒，网关Hystrix3秒超时
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "timeout";
    }


    @RequestMapping("/addMethod")
    public String addMethod(String name){
        return "你好 " + name;
    }
}
