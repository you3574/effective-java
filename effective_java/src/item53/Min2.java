package item53;

//�����μ� Ȱ�� �� (320-321��)
public class Min2 {

 // �ڵ� 53-3 �μ��� 1�� �̻��̾�� �� �� �����μ��� ����� ����ϴ� ��� (321��)
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