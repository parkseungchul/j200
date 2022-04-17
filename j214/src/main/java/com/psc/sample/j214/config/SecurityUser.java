package com.psc.sample.j214.config;

import com.psc.sample.j214.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


@Getter
@Setter
@ToString
public class SecurityUser extends User{

	private Member member;
	
	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		this.member = member;
		
		
	}
}
