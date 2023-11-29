package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*
    @Bean memberService -> new MemoryMemberRepository()
    @Bean orderService -> new MemoryMemberRepository() -> 보기에 싱글톤이 깨져보인다
    하지만 @Configuration이 매소드당 한번만 호출되도록 변경한다 = 즉 한번만 생성된다
    */
    //수동 빈 등록은 언제 사용할까
    //기술 지원 빈: 업무 로직과 비교해서 그 수가 매우 적고 앱에 광범위하게 영향을 미친다. 수동으로 등록해서 명확하게 나타나게 하는 것이 유지보수에 좋다.
    //자동 빈 등록은 언제 사용할까
    //업무 로직 빈: 웹을 지원하는 컨트롤러, 핵심 비즈니스 로직이 있는 서비스, 리포지토리 등이 있어 유사 패턴이 존재한다 이런 경우 자동 기능을 적극 사용한다
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl( discountPolicy(), memberRepository());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
