package member.core.singleton;

import member.core.AppConfig;
import member.core.member.MemberRepository;
import member.core.member.MemberServiceImpl;
import member.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSignletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);
        
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isEqualTo(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isEqualTo(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
        
    }
    
}
