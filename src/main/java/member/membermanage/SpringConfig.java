package member.membermanage;

import member.membermanage.repository.MemberRepository;
import member.membermanage.repository.MemoryMemberRepository;
import member.membermanage.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
