package com.psc.sample.j213.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class Emp {

    @Id
    @Column(length = 4)
    private Integer empno;

    @Column(length = 10)
    private String ename;

    @Column(length = 9)
    private String job;

    @Column(length = 9)
    private Integer mgr;


    /**
    EMPNO               NUMBER(4) NOT NULL,
    ENAME               VARCHAR2(10),
    JOB                 VARCHAR2(9),
    MGR                 NUMBER(4) ,
    HIREDATE            DATE,
    SAL                 NUMBER(7,2),
    COMM                NUMBER(7,2),
    DEPTNO              NUMBER(2) );
     **/
}
