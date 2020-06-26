package item39;
/*
 * effective java item39
 * 배열 매개변수를 갖는 애너테이션
 * MadPlay4
 */
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MadExceptionTest3 {
    // 배열로 변경한다.
    Class<? extends Throwable>[] value();
}