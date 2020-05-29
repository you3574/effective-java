package item13;
/*
 * Cloneable 인터페이스 사용
 */
public class Student implements Cloneable {

	private Object[] elements;
	private String Name;
	

	public Student(String _name) {
		Name= _name;
		this.elements=new Object[16];
	}
	
	public String getName() {
		return Name;
	}
	
	/*@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	*/
	
//	@Override
//	public Student clone(){
//		try {
//			return (Student) super.clone();
//		}catch(CloneNotSupportedException e) {
//			throw new AssertionError();
//		}
//	}
//	
	@Override
	public Student clone(){
		try {
			Student result=(Student) super.clone();
			result.elements=elements.clone();
			return result;
		}catch(CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student student1= new Student("yoobin");
		Student student2 =null;
		
		student2 = (Student) student1.clone();
		
		
		System.out.println("student1의 이름:"+ student1.getName());
		System.out.println("student2의 이름:"+ student2.getName());
		
	}

}



