package com.sly.excelexp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HelloController {
    @RequestMapping({"/","index.html"})
    public String index(){
        return "index";
    }
}
