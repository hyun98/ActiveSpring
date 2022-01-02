package member.membermanage;

import member.membermanage.repository.JdbcTemplateMemberRepository;
import member.membermanage.repository.MemberRepository;
import member.membermanage.repository.MemoryMemberRepository;
import member.membermanage.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    
    private final DataSource dataSource;
    
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}