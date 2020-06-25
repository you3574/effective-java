package item30;

import java.util.function.UnaryOperator;

// ���׸� �̱��� ���͸� ���� (178��)
public class GenericSingletonFactory {
    // �ڵ� 30-4 ���׸� �̱��� ���͸� ���� (178��)
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // �ڵ� 30-5 ���׸� �̱����� ����ϴ� �� (178��)
    public static void main(String[] args) {
        String[] strings = { "�ﺣ", "�븶", "���Ϸ�" };
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}