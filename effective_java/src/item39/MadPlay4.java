package item39;
/*
 * effective java item39
 * 반복 가능애너테이션
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

            // 모두 검사할 수 있도록 한다.
            if (method.isAnnotationPresent(MadExceptionTest4.class)
                    || method.isAnnotationPresent(MadExceptionContainer.class)) {
                testCount++;
                try {
                    method.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", method);
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
                        System.out.printf("테스트 %s 실패: %s %n", method, ex);
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @MadTest: " + method);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passedCount, testCount - passedCount);
    }
}

// 실행 결과
// 성공: 1, 실패: 0