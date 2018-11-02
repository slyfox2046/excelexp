package com.sly.excelexp.service;

import com.github.pagehelper.PageHelper;
import com.sly.excelexp.mapper.TblEmpMapper;
import com.sly.excelexp.model.TblEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tplEmpService")
public class TblEmpSeriviceImpl implements TblEmpService {

    @Autowired
    private TblEmpMapper tblEmpMapper;

    @Override
    public List<TblEmp> findAllEmp(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return tblEmpMapper.findAllEmp();
    }
}
