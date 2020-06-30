package item53;

//가변인수 활용 예 (320-321쪽)
public class Min {


 // 코드 53-2 인수가 1개 이상이어야 하는 가변인수 메서드 - 잘못 구현한 예! (320쪽)
 static int min(int... args) {
     if (args.length == 0)
         throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
     int min = args[0];
     for (int i = 1; i < args.length; i++)
         if (args[i] < min)
             min = args[i];
     return min;
 }


 public static void main(String[] args) {
     
     System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
     System.out.println(min());
 }
}