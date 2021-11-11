package com.psc.sample.j213.service;

import com.psc.sample.j213.domain.Dept;
import com.psc.sample.j213.domain.DeptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DepServiceImpl implements DeptService{

    final DeptRepository deptRepository;

    @Override
    public Optional<Dept> getDept(Integer deptno) {
        return deptRepository.findById(deptno);
    }

    @Override
    public Dept saveDept(Dept dept) {
        return deptRepository.save(dept);
    }
}
