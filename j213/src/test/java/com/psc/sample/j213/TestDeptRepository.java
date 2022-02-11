package com.psc.sample.j213;

import com.psc.sample.j213.domain.DeptEntity;
import com.psc.sample.j213.domain.DeptRepository;
import com.psc.sample.j213.dto.Dept;
import com.psc.sample.j213.dto.DeptMapper;
import com.psc.sample.j213.service.DeptService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestDeptRepository {

    private DeptMapper mapper = Mappers.getMapper(DeptMapper.class);

    @Autowired
    DeptRepository deptRepository;

    @Autowired
    DeptService deptService;

    Dept dept = new Dept(1,"1","1","1");
    DeptEntity deptEntity = new DeptEntity(1,"1","1","1");


    @BeforeEach
    public void dbInit(){
        deptRepository.deleteAll();
    }

    @Test
    public void A001_맵퍼_테스트(){
        DeptEntity deptEntity = mapper.dtoToEntity(dept);
        Assertions.assertEquals(dept.getDeptNo(), deptEntity.getDeptNo());
        Assertions.assertEquals(dept.getDName(), deptEntity.getDName());
        Assertions.assertEquals(dept.getLoc(), deptEntity.getLoc());
        Assertions.assertNull(deptEntity.getEntityValue());
    }

    @Test
    public void A002_DEPT_DB(){
        List<DeptEntity> deptEntityList = new ArrayList<DeptEntity>();
        for(int i= 1; i<11; i++){
            Dept dept = new Dept(i ,String.valueOf(i),String.valueOf(i),String.valueOf(i));
            deptEntityList.add(mapper.dtoToEntity(dept));
        }
        deptRepository.saveAll(deptEntityList);
        Assertions.assertEquals(deptRepository.count(), 10);
        deptRepository.deleteAll();
        Assertions.assertEquals(deptRepository.count(), 0);
    }

    @Test
    public void A003_DEPT_SERVICE(){
        for(int i= 1; i<11; i++){
            Dept dept = new Dept(i ,String.valueOf(i),String.valueOf(i),String.valueOf(i));
            deptService.addDept(dept);
        }
        Assertions.assertEquals(deptRepository.count(), 10);
        deptService.deleteDept(1);
        Assertions.assertEquals(deptRepository.count(), 9);
    }
}
