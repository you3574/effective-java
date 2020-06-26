package item39;
/*
 * effective java item39
 * �⺻ �ֳ����̼�
 * MadTest
 */


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Sample{
    @MadTest
    public static void m1() {
        // �����Ѵ�.
    }

    public static void m2() {
        // ���õȴ�.
    }

    @MadTest
    public void m3() {
        // �߸� ���Ǿ���. ���� �޼��尡 �ƴϴ�.
    }

    @MadTest
    public static void m4() {
        throw new RuntimeException("����");
    }
}
class MadPlay {
    public static void main(String[] args) throws Exception {
        int testCount = 0;
        int passedCount = 0;

        Class<?> testClass = Class.forName("item39.Sample") ;
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MadTest.class)) {
                testCount++;
                try {
                    method.invoke(null);
                    passedCount++;
                } catch (InvocationTargetException itException) {
                    Throwable ex = itException.getCause();
                    System.out.println(method + " ����: " + ex);
                } catch (Exception e) {
                    System.out.println("�߸� ����� @MadTest: " + method);
                }
            }
        }
        System.out.printf("����: %d, ����: %d%n", passedCount, testCount - passedCount);
    }
}
// ���� ���
// public static void Sample.m4() ����: java.lang.RuntimeException: ����
// �߸� ����� @MadTest: public void Sample.m3()
// ����: 1, ����: 2