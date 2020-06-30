package item53;

//�����μ� Ȱ�� �� (320-321��)
public class Varargs {
 // �ڵ� 53-1 ������ �����μ� Ȱ�� �� (320��)
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