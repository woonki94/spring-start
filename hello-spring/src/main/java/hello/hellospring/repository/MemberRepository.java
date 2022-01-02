package hello.hellospring.repository;
import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // save를 만드는 것
    Optional<Member> findById(Long id); // 저장된 데이터 중 id로 찾는ㄴ것
    Optional<Member> findByName(String name); // 이름으로 찾는 것
    List<Member> findAll();



}
