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
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                MemberRepository(),
                discountPolicy()
        );
    }
    
}
