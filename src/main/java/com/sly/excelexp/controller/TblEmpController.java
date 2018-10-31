package com.sly.excelexp.controller;

import com.sly.excelexp.mapper.TblEmpMapper;
import com.sly.excelexp.model.TblEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class TblEmpController {
    @Autowired
    private TblEmpMapper tblEmpMapper;

    @ResponseBody
    @GetMapping(value = "/getall")
    public Object getAll() throws ParseException {
        List<TblEmp> tl = tblEmpMapper.getAll();
//        tblEmpMapper.selectByPrimaryKey(1);
        return tl;
    }
}
