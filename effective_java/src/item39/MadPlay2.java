package item39;
/*
 * effective java item39
 * �Ű����� �ֳ����̼�
 * MadException2
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//�ֳ����̼� �׽�Ʈ ����
class Sample2 {
 @MadExceptionTest2(ArithmeticException.class)
 public static void m1() {
     int i = 0;
     i = i / i;
     // �����ؾ� �Ѵ�.
 }

 @MadExceptionTest2(ArithmeticException.class)
 public static void m2() {
     int[] a = new int[0];
     a[1] = 2;
     // �ٸ� ���ܰ� �߻��ϹǷ� �����ؾ� �Ѵ�.
 }

 @MadExceptionTest2(ArithmeticException.class)
 public static void m3() {
     // ���ܰ� �߻����� �ʱ� ������ �����ؾ� �Ѵ�.
 }
}

public class MadPlay2 {
 public static void main(String[] args) throws Exception {
     int testCount = 0;
     int passedCount = 0;

     Class<?> testClass = Class.forName("item39.Sample2");
     for (Method method : testClass.getDeclaredMethods()) {
         if (method.isAnnotationPresent(MadExceptionTest2.class)) {
             testCount++;
             try {
                 method.invoke(null);
                 System.out.printf("�׽�Ʈ %s ����: ���ܸ� ������ ����%n", method);
             } catch (InvocationTargetException itException) {
                 Throwable ex = itException.getCause();
                 Class<? extends Throwable> type = method.getAnnotation(MadExceptionTest2.class).value();
                 if (type.isInstance(ex)) {
                     passedCount++;
                 } else {
                     System.out.printf("�׽�Ʈ %s ����: ����� ����: %s, ���� ����: %s%n",
                             method, type.getName(), ex);
                 }
             } catch (Exception e) {
                 System.out.println("�߸� ����� @MadExceptionTest: " + method);
             }
         }
     }
     System.out.printf("����: %d, ����: %d%n", passedCount, testCount - passedCount);
 }
}

//���� ���
//�׽�Ʈ public static void Sample2.m2() ����: ����� ����: java.lang.ArithmeticException,
//���� ����: java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 0
//�׽�Ʈ public static void Sample2.m3() ����: ���ܸ� ������ ����
//����: 1, ����: 2