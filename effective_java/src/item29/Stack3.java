package item29;

import java.util.Arrays;
import java.util.List;

// Object[]�� �̿��� ���׸� Stack (170-174��)
public class Stack3<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack3() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // �ڵ� 29-4 �迭�� ����� �ڵ带 ���׸����� ����� ��� 2 (173��)
    // ��˻� ��� ������ �����.
    public E pop() {
        if (size == 0)
            throw new RuntimeException();

        // push���� E Ÿ�Ը� ����ϹǷ� �� ����ȯ�� �����ϴ�.
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];

        elements[size] = null; // �� �� ���� ����
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // �ڵ� 29-5 ���׸� Stack�� ����ϴ� ������ ���α׷� (174��)
    public static void main(String[] args) {
        Stack3<String> stack = new Stack3<>();
        List<String> list = Arrays.asList("a", "b", "c");

        for (String arg : list)
            stack.push(arg);

        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}