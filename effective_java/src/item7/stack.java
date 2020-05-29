package item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
 * 메모리 누수가 일어나는 코드
 */
public class stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		this.ensureCapacity();
		this.elements[size++] = e;
	}

	/*
	 * 메모리 누수가 일어나는 부분. 객체들을 더 이상 사용하지 않더라도 다 쓴 참조가 이루어져 문제가 생긴다. 꺼내진 객체들은 가비지 컬렉터가
	 * 회수하지 않음.
	 */
	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return this.elements[--size];
	}

	/*
	 * 원소가 참조한 객체들을 다 null 처리 null처리한 참조를 사용하게되면 NullPointerException
	 */
	public Object popSolution() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object result = this.elements[--size];
		this.elements[size] = null;
		return result;
	}

	/*
	 * 원소를 위한 공간을 적어도 하나 이상 확보한다. 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
	 */
	private void ensureCapacity() {
		if (this.elements.length == size) {
			this.elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
