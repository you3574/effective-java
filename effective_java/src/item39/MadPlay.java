package item39;
/*
 * effective java item39
 * 기본 애너테이션
 * MadTest
 */


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Sample{
    @MadTest
    public static void m1() {
        // 성공한다.
    }

    public static void m2() {
        // 무시된다.
    }

    @MadTest
    public void m3() {
        // 잘못 사용되었다. 정적 메서드가 아니다.
    }

    @MadTest
    public static void m4() {
        throw new RuntimeException("실패");
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
                    System.out.println(method + " 실패: " + ex);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @MadTest: " + method);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passedCount, testCount - passedCount);
    }
}
// 실행 결과
// public static void Sample.m4() 실패: java.lang.RuntimeException: 실패
// 잘못 사용한 @MadTest: public void Sample.m3()
// 성공: 1, 실패: 2