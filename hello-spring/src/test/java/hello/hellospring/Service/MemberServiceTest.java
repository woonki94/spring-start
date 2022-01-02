package hello.hellospring.Service;

import hello.hellospring.domain.Member;

import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.repository.MemoryMemberRepositoryTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService; //= new MemberService();
    MemoryMemberRepository memberRepository;// = new MemoryMemberRepository();
    // test에서 새로운 객체를 만들어사용..? 굳이...? 내용물이 달라질 위험도 있음
    // memberService에서 생성자를 만들어


    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join(){
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember =  memberService.findone(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicatedMemberException(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");

        /**
        try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
        }
         **/



    }




    @Test
    void findMembers(){

    }

    @Test
    void findOne(){

    }

}