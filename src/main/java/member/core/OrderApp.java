package member.core;

import member.core.member.Grade;
import member.core.member.Member;
import member.core.member.MemberService;
import member.core.member.MemberServiceImpl;
import member.core.order.Order;
import member.core.order.OrderService;
import member.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = applicationContext.getBean("memberServiceImpl", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderServiceImpl", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
