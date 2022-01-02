package hello.hellospring.controller;

import hello.hellospring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    /**
    private final MemberService memberService = new MemberService(); // 다른 cotroller도 객체 생성을 할 수 있다.
    **/

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
