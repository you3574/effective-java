package item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
 * �޸� ������ �Ͼ�� �ڵ�
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
	 * �޸� ������ �Ͼ�� �κ�. ��ü���� �� �̻� ������� �ʴ��� �� �� ������ �̷���� ������ �����. ������ ��ü���� ������ �÷��Ͱ�
	 * ȸ������ ����.
	 */
	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return this.elements[--size];
	}

	/*
	 * ���Ұ� ������ ��ü���� �� null ó�� nulló���� ������ ����ϰԵǸ� NullPointerException
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
	 * ���Ҹ� ���� ������ ��� �ϳ� �̻� Ȯ���Ѵ�. �迭 ũ�⸦ �÷��� �� ������ �뷫 �� �辿 �ø���.
	 */
	private void ensureCapacity() {
		if (this.elements.length == size) {
			this.elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
