package picdownload.util;
import java.util.Date;

public class DateString {
	public  String strBeforeAday;
	public  String strDate;
	public  String strAdd6Hours; 
	public DateString() {
		long timeBeforeAday = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
		Date dateBeforeAday = new Date(timeBeforeAday);

		String dt1 = dateBeforeAday.toString();
		dt1 = dt1.replace("Jan", "01");
		dt1 = dt1.replace("Feb", "02");
		dt1 = dt1.replace("Mar", "03");
		dt1 = dt1.replace("Apr", "04");
		dt1 = dt1.replace("May", "05");
		dt1 = dt1.replace("Jun", "06");
		dt1 = dt1.replace("Jul", "07");
		dt1 = dt1.replace("Aug", "08");
		dt1 = dt1.replace("Sep", "09");
		dt1 = dt1.replace("Oct", "10");
		dt1 = dt1.replace("Nov", "11");
		dt1 = dt1.replace("Dec", "12");

		String[] dt2 = dt1.split(" ");
		// Wed May 07 11:35:39 CST 2014

		strBeforeAday = dt2[5] + dt2[1] + dt2[2];
		
		long timeAdd6Hours = System.currentTimeMillis() + 6*60*60*1000 - 24*60*60*1000;
		Date dateAdd6Hours = new Date(timeAdd6Hours);

		String dt6 = dateAdd6Hours.toString();
		dt6 = dt6.replace("Jan", "01");
		dt6 = dt6.replace("Feb", "02");
		dt6 = dt6.replace("Mar", "03");
		dt6 = dt6.replace("Apr", "04");
		dt6 = dt6.replace("May", "05");
		dt6 = dt6.replace("Jun", "06");
		dt6 = dt6.replace("Jul", "07");
		dt6 = dt6.replace("Aug", "08");
		dt6 = dt6.replace("Sep", "09");
		dt6 = dt6.replace("Oct", "10");
		dt6 = dt6.replace("Nov", "11");
		dt6 = dt6.replace("Dec", "12");

		String[] dt7 = dt6.split(" ");
		// Wed May 07 11:35:39 CST 2014

		strAdd6Hours = dt7[5] + dt7[1] + dt7[2];
		
		String dtNow = new Date().toString();
		dtNow = dtNow.replace("Jan", "01");
		dtNow = dtNow.replace("Feb", "02");
		dtNow = dtNow.replace("Mar", "03");
		dtNow = dtNow.replace("Apr", "04");
		dtNow = dtNow.replace("May", "05");
		dtNow = dtNow.replace("Jun", "06");
		dtNow = dtNow.replace("Jul", "07");
		dtNow = dtNow.replace("Aug", "08");
		dtNow = dtNow.replace("Sep", "09");
		dtNow = dtNow.replace("Oct", "10");
		dtNow = dtNow.replace("Nov", "11");
		dtNow = dtNow.replace("Dec", "12");

		String[] dtNow2 = dtNow.split(" ");
		// Wed May 07 11:35:39 CST 2014

		strDate = dtNow2[5] + dtNow2[1] + dtNow2[2];
	}
}
