package com.sly.excelexp.controller;

import com.github.pagehelper.PageInfo;
import com.sly.excelexp.model.TblEmp;
import com.sly.excelexp.service.TblEmpService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/emp")
public class TblEmpController {
    @Autowired
    private TblEmpService tblEmpService;

    @ResponseBody
    @GetMapping(value = "/getall", produces = {"application/json;charset=UTF-8"})
    public Object getAll() {
        PageInfo pageInfo = new PageInfo<>(tblEmpService.findAllEmp(6, 5), 3);
        return pageInfo;
    }

    @ResponseBody
    @GetMapping(value = "/getall2excel", produces = {"application/json;charset=UTF-8"})
    public void getAll2Excel(HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("emp");
        List<TblEmp> list = tblEmpService.findAllEmp(1, 1000);

        //文件名称
        String fileName = "123" + ".xls";

        //新增数据行，设置单元格数据
        int rowNum = 1;
        //表头
        String[] headers = {"学号", "姓名","性别","Mail"};

        HSSFRow row = sheet.createRow(0);
        //添加表头数据
        for (int i = 0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //查询数据写入
//        for (TblEmp tblEmp : list){
//            HSSFRow row1 = sheet.createRow(rowNum);
//            row1.createCell(0).setCellValue(tblEmp.getEmpId());
//            row1.createCell(1).setCellValue(tblEmp.getEmpName());
//            row1.createCell(2).setCellValue(tblEmp.getGender());
//            row1.createCell(3).setCellValue(tblEmp.getEmail());
//            rowNum++;
//        }
        for (int i=0;i<65535 ;i++){
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(1);
            row1.createCell(1).setCellValue(2);
            row1.createCell(2).setCellValue(3);
            row1.createCell(3).setCellValue(4);
            rowNum++;
        }

        //输出导出
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

//        return "下载excel成功";
    }

    @GetMapping(value = "/getexcel2007")
    public void getExcel2007(HttpServletResponse response) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("加班明细");

        List<TblEmp> list = tblEmpService.findAllEmp(1,1000);

        //文件名称
        String fileName = "321" + ".xlsx";

        //新增数据行，设置单元格数据
        int rowNum = 1;
        //表头
        String[] headers = {"学号", "姓名","性别","Mail"};

        XSSFRow row = sheet.createRow(0);
        //添加表头数据
        for (int i = 0;i<headers.length;i++){
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //查询数据写入
//        for (TblEmp tblEmp : list){
//            HSSFRow row1 = sheet.createRow(rowNum);
//            row1.createCell(0).setCellValue(tblEmp.getEmpId());
//            row1.createCell(1).setCellValue(tblEmp.getEmpName());
//            row1.createCell(2).setCellValue(tblEmp.getGender());
//            row1.createCell(3).setCellValue(tblEmp.getEmail());
//            rowNum++;
//        }
        for (int i=0;i<99999 ;i++){
            XSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(1);
            row1.createCell(1).setCellValue(2);
            row1.createCell(2).setCellValue(3);
            row1.createCell(3).setCellValue(4);
            rowNum++;
        }

        //输出导出
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

//        return "下载excel成功";


    }
}
