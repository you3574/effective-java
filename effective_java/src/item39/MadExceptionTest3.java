package item39;
/*
 * effective java item39
 * �迭 �Ű������� ���� �ֳ����̼�
 * MadPlay4
 */
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MadExceptionTest3 {
    // �迭�� �����Ѵ�.
    Class<? extends Throwable>[] value();
}