package hello.hellospring.controller;

import hello.hellospring.Service.MemberService;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    /**
    private final MemberService memberService = new MemberService(); // 다른 cotroller도 객체 생성을 할 수 있다.
    **/
    //필드 주입
    //@Autowired MemberService memberService

    //setter 주입
    //private MemberService memberService;
    //public void setMemberService(MemberService memberService){
    //    this.memberService = memberService;
    //}

    //생성자 주입 **권장
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    @GetMapping(value = "/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());
        memberService.join(member);

        return "redirect:/";
    }
}
