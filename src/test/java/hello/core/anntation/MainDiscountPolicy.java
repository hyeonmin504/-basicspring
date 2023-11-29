package hello.core.anntation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
    //command + o qualifier 검색 후 애노테이션 다 가져오기
    //애노테이션 직접 만들기
    //qulifier은 문자열이라 오류 찾기 힘들어서 직접 만들어 사용할 때가 있다
    //필요한 곳에 @MainDiscountPolicy 사용
}
