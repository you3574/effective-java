package item53;

//�����μ� Ȱ�� �� (320-321��)
public class Min {


 // �ڵ� 53-2 �μ��� 1�� �̻��̾�� �ϴ� �����μ� �޼��� - �߸� ������ ��! (320��)
 static int min(int... args) {
     if (args.length == 0)
         throw new IllegalArgumentException("�μ��� 1�� �̻� �ʿ��մϴ�.");
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