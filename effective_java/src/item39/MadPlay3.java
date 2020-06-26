package item39;
/*
 * effective java item39
 * �迭 �Ű������� ���� �ֳ����̼�
 * MadExceptionTest3
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Sample3 {
    @MadExceptionTest3({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(1, null);
    }
}

class MadPlay3 {
    public static void main(String[] args) throws Exception {
        int testCount = 0;
        int passedCount = 0;

        Class<?> testClass = Class.forName("item39.Sample3");
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MadExceptionTest3.class)) {
                testCount++;
                try {
                    method.invoke(null);
                    System.out.printf("�׽�Ʈ %s ����: ���ܸ� ������ ����%n", method);
                } catch (InvocationTargetException itException) {
                    Throwable ex = itException.getCause();
                    int oldPassedCount = passedCount;
                    Class<? extends Throwable>[] types = method.getAnnotation(MadExceptionTest3.class).value();

                    for (Class<? extends Throwable> type : types) {
                        if (type.isInstance(ex)) {
                            passedCount++;
                            break;
                        }
                    }
                    if (passedCount == oldPassedCount) {
                        System.out.printf("�׽�Ʈ %s ����: %s %n", method, ex);
                    }
                } catch (Exception e) {
                    System.out.println("�߸� ����� @MadExceptionTest3: " + method);
                }
            }
        }
        System.out.printf("����: %d, ����: %d%n", passedCount, testCount - passedCount);
    }
}

// ���� ���
// ����: 1, ����: 0