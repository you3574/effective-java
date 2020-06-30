package item53;

//가변인수 활용 예 (320-321쪽)
public class Varargs {
 // 코드 53-1 간단한 가변인수 활용 예 (320쪽)
 static int sum(int... args) {
     int sum = 0;
     for (int arg : args)
         sum += arg;
     return sum;
 }

 public static void main(String[] args) {

     System.out.println(sum());
     System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
 }
}