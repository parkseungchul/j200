package com.psc.sample.j214;

import com.psc.sample.j214.domain.Member;
import com.psc.sample.j214.domain.Role;
import com.psc.sample.j214.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class J214Application {

    final PasswordEncoder passwordEncoder;
    final MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(J214Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {
        Member memberEntity = new Member();
        memberEntity.setId("admin@naver.com");
        memberEntity.setPassword(passwordEncoder.encode("admin"));
        memberEntity.setEnabled(true);
        memberEntity.setRole(Role.ROLE_ADMIN);
        memberRepository.save(memberEntity);

    }

}
