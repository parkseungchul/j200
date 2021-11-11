package com.psc.sample.j213.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dept")
public class Dept extends BaseTimeEntity{

    @Id
    @Column(length = 10)
    private Integer deptno;

    @Column(length = 14)
    private String dname;

    @Column(length = 13)
    private String loc;


    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", create=" + super.getCreatedDate() +
                ", modified=" + super.getLastModifedDate()+
                '}';
    }
}
