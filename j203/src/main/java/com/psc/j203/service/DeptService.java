package com.psc.j203.service;

import java.util.List;
import java.util.Optional;

import com.psc.j203.domain.Dept;

public interface DeptService {

	public void save(Dept dept);
	
	public Long count();
	
	public Optional<Dept> getDept(Integer deptno);
	
	public List<Dept> list();
	
	public void delete(Integer deptno);
}
