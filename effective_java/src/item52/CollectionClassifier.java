package item52;
import java.math.BigInteger;
import java.util.*;
//�ڵ� 52-1 �÷��� �з��� - ����! �� ���α׷��� ������ ����ұ�? (312��)
public class CollectionClassifier {
 public static String classify(Set<?> s) {
     return "����";
 }

 public static String classify(List<?> lst) {
     return "����Ʈ";
 }

 public static String classify(Collection<?> c) {
     return "�� ��";
 }

 public static void main(String[] args) {
     Collection<?>[] collections = {
             new HashSet<String>(),
             new ArrayList<BigInteger>(),
             new HashMap<String, String>().values()
     };

     for (Collection<?> c : collections)
         System.out.println(classify(c));
 }
}