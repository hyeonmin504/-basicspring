package hello.core.discount;

import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public interface DiscountPolicy {

    /*
    * @return 할인 대상 금₩액
    * */
    int discount(Member member, int price);
}
