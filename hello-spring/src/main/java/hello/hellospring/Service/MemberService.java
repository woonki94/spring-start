package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {


    private final MemberRepository memberRepository;
    //test에서의 새로운 객체 생성을 하지 않고 Memberservice 클래스에 직접 넣어준다.  beforeeach 사용
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**회원가입 **/
    public long join(Member member){
        //같은 이름이 있는 중복 회원 불가

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Optional<Member> result = memberRepository.findByName(member.getName());
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    /** 전체 회원 존재**/

    public List<Member> findMembers(){
        return memberRepository.findAll();

    }

    public Optional<Member> findone(Long memberId){
        return memberRepository.findById(memberId);

    }


}
