package item38;
public class Test {
    
    // ���� Ÿ���� Class ��ü�� �̿��� Ȯ��� ���� Ÿ���� ��� ���Ҹ� ����ϴ� �� (234��)
    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        test(ExtendedOperation.class, x, y);
    }
    
    private static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }

}