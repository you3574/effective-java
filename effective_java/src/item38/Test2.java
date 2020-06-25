
package item38;

import java.util.Arrays;
import java.util.Collection;

public class Test2 {

    // �÷��� �ν��Ͻ��� �̿��� Ȯ��� ���� Ÿ���� ��� ���Ҹ� ����ϴ� �� (235��)
    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        test2(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static void test2(Collection<? extends Operation> opSet,
                             double x, double y) {
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
}