package com.psc.j203.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "dept")
@Entity
@AllArgsConstructor
public class Dept {
	
	public Dept() {}
	@Id
	private Integer deptno;
	private String dname;
	private String loc;
}
