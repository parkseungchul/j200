package com.psc.sample.web.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="dept")
public class DeptEntity {

    @Id
    private Integer deptNo;
    private String dName;
    private String loc;

}
