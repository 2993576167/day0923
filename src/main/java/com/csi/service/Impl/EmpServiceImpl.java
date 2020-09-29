package com.csi.service.Impl;

import com.csi.dao.EmpDao;
import com.csi.dao.impl.EmpDaoImpl;
import com.csi.domin.Emp;
import com.csi.service.EmpService;

import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    //创建dao实例对象
    private EmpDao empDao;

    public EmpServiceImpl(){
        this.empDao = new EmpDaoImpl();
    }

    @Override
    public String addEmp(Emp emp) throws SQLException {
        //判断当前录入的员工信息是否已经存在
        if (this.empDao.selectByIdAndName(emp.getEmpno(),emp.getEname())!=null){
            return "对不起该员工已经录入";
        }
        return this.empDao.insert(emp)>0?"录入员工信息成功":"录入信息失败";
    }

    @Override
    public List<Emp> findAll() throws SQLException {
        return this.empDao.selectAll();
    }

    @Override
    public List<Emp> findAllManager() throws SQLException {
        return this.empDao.selectManager();
    }
}
