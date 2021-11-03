package com.psc.j209.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dept")
public class Dept {

    @Id
    private Integer deptno;
    private String dname;
    private String loc;
}
