package com.psc.sample.j214.config;

import com.psc.sample.j214.domain.Member;
import com.psc.sample.j214.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;
	

	@Autowired
	private HttpServletResponse response;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		

	    Optional<Member> op =  memberRepository.findById(username);
	    
	    if(!op.isPresent()) {
	    	throw new UsernameNotFoundException("사용자 없음");
	    }
	    

	    
	    
	    Member member = op.get();
		return new SecurityUser(member);
	}

}
