package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes=Configuration.class),
        basePackages = "hello.core.member"

        //default - 지정한 클래스 패키지를 탑색 시작 위치로 지정 hello.core
        //Component - 컴포터넌트 스캔에서 사용
        //Controller - 스프링 MVC 컨트롤러에서 사용
        //Service - 스프링 비즈니스 로직에서 사용
        //Repository - 스프링 데이터 접근 계층에서 사용
        //Configuration - 스프링 설정 정보에서 사용
)

public class AutoAppConfig {

}
