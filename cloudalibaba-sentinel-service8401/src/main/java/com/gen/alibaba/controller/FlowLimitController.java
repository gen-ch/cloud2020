package com.gen.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println((Thread.currentThread().getName() + "\t" + "...testB"));
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TestD 测试RT");
//        int age = 10 / 0;
        return "------testD";
    }

    @GetMapping("/testHotKey")
// value值可以随意起，但为唯一标识，blockHandler是处理方法
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHostKey(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        System.out.println(p1);
        return "testHostKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "deal_testHotKey";
    }
}
