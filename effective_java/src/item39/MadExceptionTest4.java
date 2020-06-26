package item39;
/*
 * effective java item39
 * 반복 가능애너테이션
 * MadPlay4
 */
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(MadExceptionContainer.class)
public @interface MadExceptionTest4 {
    Class<? extends Throwable> value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MadExceptionContainer {
    MadExceptionTest4[] value();
}