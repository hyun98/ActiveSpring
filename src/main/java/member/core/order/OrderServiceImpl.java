package member.core.order;

import member.core.discount.DiscountPolicy;
import member.core.discount.FixDiscountPolicy;
import member.core.discount.RateDiscountPolicy;
import member.core.member.Member;
import member.core.member.MemberRepository;
import member.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
