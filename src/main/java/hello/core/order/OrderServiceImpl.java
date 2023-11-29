package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@RequiredArgsConstructor // lombok - final을 보고 직접 생성자를 만들어줌 - command + f12에서 확인
@Component
public class OrderServiceImpl implements OrderService {

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    //3.구현체에 직접 @Primary 붙여두기 ex) 메인db, 보조db
    @Autowired //타입 매칭 결과가 2개 이상인 경우 방법 1.파라미터 명으로 빈 이름 매칭 2.Qulifier을 사용해서 적용 cf.Qulifier 끼리 매칭
    public OrderServiceImpl(DiscountPolicy DiscountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = DiscountPolicy;
        this.memberRepository = memberRepository;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
