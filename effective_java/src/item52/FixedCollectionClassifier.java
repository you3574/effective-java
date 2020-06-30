package item52;

import java.math.BigInteger;
import java.util.*;

// ������ �÷��� �з��� (314��)
public class FixedCollectionClassifier {
    public static String classify(Collection<?> c) {
        return c instanceof Set ? "����" :
                c instanceof List ? "����Ʈ" : "�� ��";
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