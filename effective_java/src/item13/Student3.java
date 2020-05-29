package item13;
/*
 * Cloneable 인터페이스 사용
 */
public class Student3 implements Cloneable {

	private String Name;
	
	public Student3(String _name) {
		Name= _name;
	}
	
	public String getName() {
		return Name;
	}
	
	
	@Override
	public Student3 clone(){
		try {
			return (Student3) super.clone();
		}catch(CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student3 student1= new Student3("0g");
		Student3 student2 =null;
		
		
		student2 = (Student3) student1.clone();
		
		
		System.out.println("student1의 이름:"+ student1.getName());
		System.out.println("student2의 이름:"+ student2.getName());
		
	}

}
