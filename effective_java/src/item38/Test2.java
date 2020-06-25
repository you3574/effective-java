
package item38;

import java.util.Arrays;
import java.util.Collection;

public class Test2 {

    // 컬렉션 인스턴스를 이용해 확장된 열거 타입의 모든 원소를 사용하는 예 (235쪽)
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