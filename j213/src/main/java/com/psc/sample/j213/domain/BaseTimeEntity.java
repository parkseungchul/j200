package com.psc.sample.j213.domain;
//스프링 부트와 AWS 혼자 구현하는 웹 서비스


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // [1]
public class BaseTimeEntity {


    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifedDate;
}
