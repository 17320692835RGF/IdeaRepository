package com.neuedu.springboot_red_bag.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 14:14 2021/9/1
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "<h1> Hello </h1>";
    }
}
