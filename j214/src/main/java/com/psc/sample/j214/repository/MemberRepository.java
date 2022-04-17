package com.psc.sample.j214.repository;

import com.psc.sample.j214.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
