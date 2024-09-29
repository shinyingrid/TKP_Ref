package java_concepts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateAndCalendarJavaPgm
{
public static void main(String[] args)
	
	{
		Date dateObj = new Date();
		System.out.println("Date class output : "+dateObj);
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd"); // Month should be in upper case
		String formattedDate=sim.format(dateObj);		
		System.out.println("SimpleFormat class output :"+formattedDate);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);  //+ or - days
		String reqDate = sim.format(cal.getTime());
		System.out.println("Required date is :"+reqDate);
		


	}

}
