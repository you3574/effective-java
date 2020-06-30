package item53;

//가변인수 활용 예 (320-321쪽)
public class Min2 {

 // 코드 53-3 인수가 1개 이상이어야 할 때 가변인수를 제대로 사용하는 방법 (321쪽)
 static int min(int firstArg, int... remainingArgs) {
     int min = firstArg;
     for (int arg : remainingArgs)
         if (arg < min)
             min = arg;
     return min;
 }

 public static void main(String[] args) {

     System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

 }
}