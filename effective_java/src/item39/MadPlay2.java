package item39;
/*
 * effective java item39
 * 매개변수 애너테이션
 * MadException2
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//애너테이션 테스트 샘플
class Sample2 {
 @MadExceptionTest2(ArithmeticException.class)
 public static void m1() {
     int i = 0;
     i = i / i;
     // 성공해야 한다.
 }

 @MadExceptionTest2(ArithmeticException.class)
 public static void m2() {
     int[] a = new int[0];
     a[1] = 2;
     // 다른 예외가 발생하므로 실패해야 한다.
 }

 @MadExceptionTest2(ArithmeticException.class)
 public static void m3() {
     // 예외가 발생하지 않기 때문에 실패해야 한다.
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
                 System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", method);
             } catch (InvocationTargetException itException) {
                 Throwable ex = itException.getCause();
                 Class<? extends Throwable> type = method.getAnnotation(MadExceptionTest2.class).value();
                 if (type.isInstance(ex)) {
                     passedCount++;
                 } else {
                     System.out.printf("테스트 %s 실패: 기대한 예외: %s, 실제 예외: %s%n",
                             method, type.getName(), ex);
                 }
             } catch (Exception e) {
                 System.out.println("잘못 사용한 @MadExceptionTest: " + method);
             }
         }
     }
     System.out.printf("성공: %d, 실패: %d%n", passedCount, testCount - passedCount);
 }
}

//실행 결과
//테스트 public static void Sample2.m2() 실패: 기대한 예외: java.lang.ArithmeticException,
//실제 예외: java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 0
//테스트 public static void Sample2.m3() 실패: 예외를 던지지 않음
//성공: 1, 실패: 2