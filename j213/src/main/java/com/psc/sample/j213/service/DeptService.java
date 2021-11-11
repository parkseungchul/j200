package com.psc.sample.j213.service;

import com.psc.sample.j213.domain.Dept;

import java.util.Optional;

public interface DeptService {

    Optional<Dept> getDept(Integer deptno);

    Dept saveDept(Dept dept);
}
