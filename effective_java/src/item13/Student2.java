package item13;
/*
 * Cloneable 인터페이스 사용
 */
public class Student2 implements Cloneable {

	private String Name;
	
	public Student2(String _name) {
		Name= _name;
	}
	
	public String getName() {
		return Name;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student2 student1= new Student2("key");
		Student2 student2 =null;
		
		try {
			student2 = (Student2) student1.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println("student1의 이름:"+ student1.getName());
		System.out.println("student2의 이름:"+ student2.getName());
		
	}

}



