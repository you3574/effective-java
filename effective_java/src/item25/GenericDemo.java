package item25;

class Wrapper<T> {

	private T data;

	public Wrapper(T data) {
		this.setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.data + "";
	}
}

public class GenericDemo {
	public static void main(String[] args) {
		Wrapper<Integer> n3 = new Wrapper<Integer>(300);
		System.out.println(n3);
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3);
		Wrapper<String> s3 = new Wrapper<String>("¹®ÀÚ¿­");
		System.out.println(s3);

	}
}
