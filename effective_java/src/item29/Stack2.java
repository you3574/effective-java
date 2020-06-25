package item29;

import java.util.Arrays;
import java.util.List;

// E[]를 이용한 제네릭 스택 (170-174쪽)
public class Stack2<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)
    // 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 타입 안전성을 보장하지만,
    // 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
    @SuppressWarnings("unchecked")
    public Stack2() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        //제네릭 배열 생성을 금지하는 제약을 대놓고 우회하는 방법.
        //Object배열을 새성한 다음 제네릭 배열로 형변환.
    } 

    //push 메서드를 통해 배열에 저장되는 원소의 타입은 항상 E.
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new RuntimeException("스텍이 비였음");
        E result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // 코드 29-5 제네릭 Stack을 사용하는 맛보기 프로그램 (174쪽)
    public static void main(String[] args) {
        Stack2<String> stack = new Stack2<>();
        List<String> list = Arrays.asList("a","b","c");

        for (String arg : list)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}