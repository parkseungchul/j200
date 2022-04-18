package com.psc.j215.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dept")
public class Dept {

    @Id
    Integer deptNo;
    String dName;
    String loc;
}
