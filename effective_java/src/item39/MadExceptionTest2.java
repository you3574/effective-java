package item39;
/*
 * effective java item39
 * �Ű����� �ֳ����̼�
 * MadPlay2
 */

import java.lang.annotation.*;

//����� ���ܸ� �����߸� �����ϴ� �׽�Ʈ �޼���� �ֳ����̼�
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MadExceptionTest2 {
 Class<? extends Throwable> value();
}