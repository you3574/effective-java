package item29;

import java.util.Arrays;
import java.util.List;

// E[]�� �̿��� ���׸� ���� (170-174��)
public class Stack2<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // �ڵ� 29-3 �迭�� ����� �ڵ带 ���׸����� ����� ��� 1 (172��)
    // �迭 elements�� push(E)�� �Ѿ�� E �ν��Ͻ��� ��´�.
    // ���� Ÿ�� �������� ����������,
    // �� �迭�� ��Ÿ�� Ÿ���� E[]�� �ƴ� Object[]��!
    @SuppressWarnings("unchecked")
    public Stack2() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        //���׸� �迭 ������ �����ϴ� ������ ����� ��ȸ�ϴ� ���.
        //Object�迭�� ������ ���� ���׸� �迭�� ����ȯ.
    } 

    //push �޼��带 ���� �迭�� ����Ǵ� ������ Ÿ���� �׻� E.
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new RuntimeException("������ ����");
        E result = elements[--size];
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
        Stack2<String> stack = new Stack2<>();
        List<String> list = Arrays.asList("a","b","c");

        for (String arg : list)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}