package com.psc.j2021.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name="app_logs")
public class AppLogs {

    @Id
    private String log_id;
    private String trace_id;
    private Timestamp entry_date;
    private String logger;
    private String log_level;



    @Lob
    private String message;
    private String exception;


}
