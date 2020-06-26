package item39;
/*
 * effective java item39
 * �ݺ� ���ɾֳ����̼�
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