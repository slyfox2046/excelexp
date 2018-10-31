package com.sly.excelexp.controller;

import com.sly.excelexp.service.TblEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/emp")
public class TblEmpController {
    @Autowired
    private TblEmpService tblEmpService;

    @ResponseBody
    @GetMapping(value="/getall",produces = {"application/json;charset=UTF-8"})
    public Object getAll(){

        return tblEmpService.findAllEmp(1,20);
    }
}
