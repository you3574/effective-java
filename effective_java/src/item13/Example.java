package item13;
/*
 * clone메소
 */
import java.util.Calendar;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1996,04,30);
		
		System.out.print("(calendar)나의 생일은:");
		System.out.println(calendar.get(Calendar.YEAR)+ "년"+ 
							calendar.get(Calendar.MONTH)+ "월"+ 
							calendar.get(Calendar.DAY_OF_MONTH)+ "일");
		
		Calendar calendar2 = (Calendar)calendar.clone();
		
		System.out.print("(calendar2)나의 생일은:");
		System.out.println(calendar2.get(Calendar.YEAR)+ "년"+ 
							calendar2.get(Calendar.MONTH)+ "월"+ 
							calendar2.get(Calendar.DAY_OF_MONTH)+ "일");
		
		
		
	}

}
