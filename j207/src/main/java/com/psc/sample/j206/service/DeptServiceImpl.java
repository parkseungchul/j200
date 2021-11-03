package com.psc.sample.j206.service;


import com.psc.sample.j206.domain.DeptRepository;
import com.psc.sample.j206.dto.Dept;
import com.psc.sample.j206.dto.DeptMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeptServiceImpl implements DeptService{

    final DeptMapper deptMapper;
    final DeptRepository deptRepository;

    @Override
    public Dept getDept(Integer deptNo) {
        return deptMapper.entityToDto(deptRepository.findById(deptNo).get());
    }

    @Override
    public List<Dept> deptList() {
        List<Dept> deptList = new ArrayList<Dept>();
        deptRepository.findAll().forEach(deptEntity -> {
            deptList.add(deptMapper.entityToDto(deptEntity));
        });
        return deptList;
    }

    @Override
    public void addDept(Dept dept) {
        deptRepository.save(deptMapper.dtoToEntity(dept));
    }

    @Override
    public void deleteDept(Integer deptNo) {
        deptRepository.deleteById(deptNo);
    }

    @Override
    public void updateDept(Dept dept) {
        deptRepository.save(deptMapper.dtoToEntity(dept));
    }
}
