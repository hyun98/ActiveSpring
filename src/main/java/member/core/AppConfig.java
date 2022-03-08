package member.core;

import member.core.discount.DiscountPolicy;
import member.core.discount.FixDiscountPolicy;
import member.core.discount.RateDiscountPolicy;
import member.core.member.MemberRepository;
import member.core.member.MemberService;
import member.core.member.MemberServiceImpl;
import member.core.member.MemoryMemberRepository;
import member.core.order.OrderService;
import member.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    
    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    
}
