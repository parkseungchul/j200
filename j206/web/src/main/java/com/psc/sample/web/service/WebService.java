package com.psc.sample.web.service;

import com.psc.sample.web.domain.DeptEntity;
import com.psc.sample.web.dto.DefaultDto;

import java.util.List;

public interface WebService {

    public DefaultDto get(String msg);

    public void addDept(DeptEntity deptEntity);

    public void deleteDept(Integer deptNo);

    public DeptEntity getDept(Integer deptNo);

    public List<DeptEntity> listDept();

}
