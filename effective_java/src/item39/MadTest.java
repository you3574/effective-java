package item39;
/*
 * effective java item39
 * 기본 애너테이션
 * MadPlay
 */


import java.lang.annotation.*;

// 테스트 메서드임을 선언하는 애너테이션
// 매개변수 없는 정적 메서드 전용이다.
@Retention(RetentionPolicy.RUNTIME) // @MadTest가 런타임에도 유지되어야 한다는 뜻
@Target(ElementType.METHOD) // @MadTest가 메서드 선언에서만 사용돼야 한다는 뜻
public @interface MadTest {
}