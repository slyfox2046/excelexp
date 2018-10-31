package com.sly.excelexp.service;

import com.sly.excelexp.model.TblEmp;

import java.util.List;

public interface TblEmpService {
    List<TblEmp> findAllEmp(int pageNum,int pageSize);


}
