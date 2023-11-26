package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.MemberServiceTest;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링이 없는 순수한DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //싱글톤을 쓰는 이유 -> 객체생성이 많아지면 곤란하다
        //객체 생성
        MemberService memberService1 = appConfig.memberService();
        //객체 생성2
        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService1);
        System.out.println(memberService2);

        //m1 != m2
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println(singletonService1);
        System.out.println(singletonService2);
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }


    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //싱글톤을 쓰는 이유 -> 객체생성이 많아지면 곤란하다
        //객체 생성
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        //객체 생성2
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);

        //m1 != m2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
