package com.psc.sample.j213.service;

import com.psc.sample.j213.dto.Dept;

import java.util.List;

public interface DeptService {

    Dept getDept(Integer deptNo);

    List<Dept> deptList();

    void addDept(Dept dept);

    void deleteDept(Integer deptNo);

    void updateDept(Dept dept);



}
