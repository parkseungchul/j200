package com.psc.sample.j214.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name="member")
public class Member implements Serializable{
	
	@Id
	private String id;
	
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean enabled;
	
	private String dname;
}
