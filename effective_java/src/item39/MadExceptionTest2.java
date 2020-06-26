package item39;
/*
 * effective java item39
 * 매개변수 애너테이션
 * MadPlay2
 */

import java.lang.annotation.*;

//명시한 예외를 던져야만 성공하는 테스트 메서드용 애너테이션
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MadExceptionTest2 {
 Class<? extends Throwable> value();
}