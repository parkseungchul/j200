package com.psc.j203.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psc.j203.domain.Dept;
import com.psc.j203.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptRepository deptRepository;
	
	@Override
	public void save(Dept dept) {
		deptRepository.save(dept);
	}
	
	@Override
	public Long count() {
		return deptRepository.count();
	}
	
	@Override
	public Optional<Dept> getDept(Integer deptno) {
		// TODO Auto-generated method stub
		return deptRepository.findById(deptno);
	}
	
	
	@Override
	public List<Dept> list() {
		List<Dept> deptList = new ArrayList<Dept>();
		deptRepository.findAll().forEach(dept ->{
			deptList.add(dept);
		});
		return deptList;
	}



	@Override
	public void delete(Integer deptno) {
		deptRepository.deleteById(deptno);
	}






}
