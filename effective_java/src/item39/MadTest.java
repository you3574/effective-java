package item39;
/*
 * effective java item39
 * �⺻ �ֳ����̼�
 * MadPlay
 */


import java.lang.annotation.*;

// �׽�Ʈ �޼������� �����ϴ� �ֳ����̼�
// �Ű����� ���� ���� �޼��� �����̴�.
@Retention(RetentionPolicy.RUNTIME) // @MadTest�� ��Ÿ�ӿ��� �����Ǿ�� �Ѵٴ� ��
@Target(ElementType.METHOD) // @MadTest�� �޼��� ���𿡼��� ���ž� �Ѵٴ� ��
public @interface MadTest {
}