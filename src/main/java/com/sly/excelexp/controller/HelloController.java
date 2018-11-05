package com.sly.excelexp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping({"/","index.html","/abcd"})
    public String index(){
        return "index";
    }

}
