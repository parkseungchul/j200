package com.psc.sample.web.service;

import com.psc.sample.web.domain.DeptEntity;
import com.psc.sample.web.domain.DeptRepository;
import com.psc.sample.web.dto.DefaultDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class WebServiceImpl implements WebService{

    @Autowired
    DeptRepository deptRepository;

    @Override
    public DefaultDto get(String msg) {

        DefaultDto defaultDto = new DefaultDto();
        if(msg == null){
            defaultDto.setMsg("msg is not exist");
            defaultDto.setResult(false);
        }else{
            defaultDto.setMsg(msg);
            defaultDto.setResult(true);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i<101; i++){
            list.add(i);
        }
        defaultDto.setStringFlux(list);
        return defaultDto;
    }

    @Override
    public void addDept(DeptEntity deptEntity) {
        deptRepository.save(deptEntity);
    }

    @Override
    public void deleteDept(Integer deptNo) {
        deptRepository.deleteById(deptNo);
    }

    @Override
    public DeptEntity getDept(Integer deptNo) {
        return deptRepository.findById(deptNo).orElse(new DeptEntity());
    }

    @Override
    public List<DeptEntity> listDept() {


        List<DeptEntity> list = new ArrayList<>();
        Iterable<DeptEntity> iterable = deptRepository.findAll();
        iterable.forEach(dept ->{
            list.add(dept);
        });

        return list;
    }
}
