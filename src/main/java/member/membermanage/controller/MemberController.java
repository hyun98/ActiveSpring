package member.membermanage.controller;

import member.membermanage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    
    private final MemberService memberService;
    
    // 스프링 컨테이너에서 MemberService 를 가져온다 == 스프링 컨테이너와 MemberService 를 연결
    @Autowired
    public MemberController(MemberService memberService) {
        
        this.memberService = memberService;
    }
}
