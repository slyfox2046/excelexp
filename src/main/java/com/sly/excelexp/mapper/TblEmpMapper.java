package com.sly.excelexp.mapper;

import com.sly.excelexp.model.TblEmp;

public interface TblEmpMapper {
    int deleteByPrimaryKey(Integer empId);

    int insert(TblEmp record);

    int insertSelective(TblEmp record);

    TblEmp selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(TblEmp record);

    int updateByPrimaryKey(TblEmp record);
}