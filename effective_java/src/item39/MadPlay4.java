package item39;
/*
 * effective java item39
 * �ݺ� ���ɾֳ����̼�
 * MadExceptionTest4
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Sample4 {
	@MadExceptionTest4(NullPointerException.class)
	@MadExceptionTest4(IndexOutOfBoundsException.class)    
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(1, null);
    }
}

public class MadPlay4 {
    public static void main(String[] args) throws Exception {
        int testCount = 0;
        int passedCount = 0;

        Class<?> testClass = Class.forName("item39.Sample4");
        for (Method method : testClass.getDeclaredMethods()) {

            // ��� �˻��� �� �ֵ��� �Ѵ�.
            if (method.isAnnotationPresent(MadExceptionTest4.class)
                    || method.isAnnotationPresent(MadExceptionContainer.class)) {
                testCount++;
                try {
                    method.invoke(null);
                    System.out.printf("�׽�Ʈ %s ����: ���ܸ� ������ ����%n", method);
                } catch (InvocationTargetException itException) {
                    Throwable ex = itException.getCause();
                    int oldPassedCount = passedCount;

                    MadExceptionTest4[] tests = method.getAnnotationsByType(MadExceptionTest4.class);
                    for (MadExceptionTest4 test : tests) {
                        if (test.value().isInstance(ex)) {
                            passedCount++;
                            break;
                        }
                    }

                    if (passedCount == oldPassedCount) {
                        System.out.printf("�׽�Ʈ %s ����: %s %n", method, ex);
                    }
                } catch (Exception e) {
                    System.out.println("�߸� ����� @MadTest: " + method);
                }
            }
        }
        System.out.printf("����: %d, ����: %d%n", passedCount, testCount - passedCount);
    }
}

// ���� ���
// ����: 1, ����: 0