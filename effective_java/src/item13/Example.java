package item13;
/*
 * clone�޼�
 */
import java.util.Calendar;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1996,04,30);
		
		System.out.print("(calendar)���� ������:");
		System.out.println(calendar.get(Calendar.YEAR)+ "��"+ 
							calendar.get(Calendar.MONTH)+ "��"+ 
							calendar.get(Calendar.DAY_OF_MONTH)+ "��");
		
		Calendar calendar2 = (Calendar)calendar.clone();
		
		System.out.print("(calendar2)���� ������:");
		System.out.println(calendar2.get(Calendar.YEAR)+ "��"+ 
							calendar2.get(Calendar.MONTH)+ "��"+ 
							calendar2.get(Calendar.DAY_OF_MONTH)+ "��");
		
		
		
	}

}
