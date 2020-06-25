
package item30;

import java.util.*;

// ����� Ÿ�� ������ �̿��� ��ȣ ���� �� ������ ǥ�� (179��)
public class RecursiveTypeBound {
    // �ڵ� 30-7 �÷��ǿ��� �ִ��� ��ȯ�Ѵ�. - ����� Ÿ�� ���� ��� (179��)
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty())
            return Optional.empty();

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }
        return Optional.of(result);
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList("a","b","c");
        max(argList).ifPresent((values)->{
            System.out.println(values);
        });
    }
}