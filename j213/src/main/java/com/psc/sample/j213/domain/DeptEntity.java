package com.psc.sample.j213.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DEPT")
public class DeptEntity {
    @Id
    Integer deptNo;
    String dName;
    String loc;
    String entityValue;
}
