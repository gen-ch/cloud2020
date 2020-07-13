package com.gen.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("test")
    public String test(Entity entity, int qa, String qw) {
        System.out.println(qa);
        System.out.println(qw);
        System.out.println(entity.toString());
        return "ss";
    }
}
