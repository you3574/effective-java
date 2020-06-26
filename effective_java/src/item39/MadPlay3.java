package item39;
/*
 * effective java item39
 * 배열 매개변수를 갖는 애너테이션
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
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", method);
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
                        System.out.printf("테스트 %s 실패: %s %n", method, ex);
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @MadExceptionTest3: " + method);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passedCount, testCount - passedCount);
    }
}

// 실행 결과
// 성공: 1, 실패: 0