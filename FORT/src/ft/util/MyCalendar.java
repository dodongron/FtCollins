/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ft.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author i1
 */
public class MyCalendar {

	public static class days_of_month {

		public String day;

		public days_of_month(String day) {
			this.day = day;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}
	}

	public static void main(String[] args) {
		System.out.println("    S    M    T    W    T    F    S");
		System.out.println("    -------------------------------");
		String month = "August";
		String year = "2013";
		List<days_of_month> datas = list(month, year);
		int i = 0;
		for (days_of_month dm : datas) {
			if (i == 7 || i == 14 || i == 21 || i == 28 || i == 35 || i == 42) {
				System.out.println("");
			}
			System.out.print(" " + dm.day);
			i++;
		}
		System.out.println("");
		System.out.println("    -------------------------------");
	}

	public static List<days_of_month> list(String month, String year) {
		List<days_of_month> datas = new ArrayList();

		Date f = new Date();
		Date l = new Date();
		Date selectedDate = setDate(month, year);

		try {
			f = DateType.sf.parse(firstDay(selectedDate));
			l = DateType.sf.parse(lastDay(selectedDate));
		} catch (ParseException ex) {
			Logger.getLogger(MyCalendar.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		int day = 1;
		String my_day = DateType.day.format(f);

		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };
		int my_day_no = 0;
		int j = 0;
		for (String s : days) {
			if (s.equalsIgnoreCase(my_day)) {
				my_day_no = j;
				break;
			}
			j++;
		}

		int last = Integer.parseInt(DateType.d.format(l));
		System.out.println(my_day_no);
		for (int i = 0; i < 42; i++) {
			if (day <= last) {
				if (my_day_no == 0 && (i >= 0 && i <= 6)) {
					days_of_month d = new days_of_month("");
					datas.add(d);
				} else if (my_day_no == 1 && (i >= 0 && i <= 0)) {
					days_of_month d = new days_of_month("   ");
					datas.add(d);

				} else if (my_day_no == 2 && (i >= 0 && i <= 1)) {
					days_of_month d = new days_of_month("   ");
					datas.add(d);

				} else if (my_day_no == 3 && (i >= 0 && i <= 2)) {
					days_of_month d = new days_of_month("   ");
					datas.add(d);

				} else if (my_day_no == 4 && (i >= 0 && i <= 3)) {
					days_of_month d = new days_of_month("   ");
					datas.add(d);

				} else if (my_day_no == 5 && (i >= 0 && i <= 4)) {
					days_of_month d = new days_of_month("   ");
					datas.add(d);

				} else if (my_day_no == 6 && (i >= 0 && i <= 5)) {
					days_of_month d = new days_of_month("   ");
					datas.add(d);

				} else {
					days_of_month d = new days_of_month("  " + twoDigit(day));
					datas.add(d);
					day++;
				}

			} else {
				days_of_month d = new days_of_month("  ");
				datas.add(d);
			}

		}
		// else if(my_day_no == 2 && (i >= 0 && i <= 2)){
		// days_of_month d = new days_of_month("  ");
		// datas.add(d);
		// }
		return datas;
	}

	public static String twoDigit(int num) {
		String con = "" + num;
		if (con.length() == 1) {
			con = "0" + con;
		}
		return con;
	}

	public static void main2(String[] args) {
		System.out.println(setDate("January", "2013"));
	}

	public static Date setDate(String month, String year) {
		List<String> months = DateType.monthNames();
		String m = "";
		int i = 1;
		for (String s : months) {
			if (s.equalsIgnoreCase(month)) {
				m = MyCalendar.twoDigit(i);
				break;
			}
			i++;
		}
		String dateNow = year + "-" + m + "-" + "01";
		Date d = new Date();
		try {
			d = DateType.sf.parse(dateNow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	public static String lastDay(Date date) {
		Date today = date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		Date lastDayOfMonth = calendar.getTime();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(lastDayOfMonth);
	}

	public static String firstDay(Date date) {
		Date today = date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		// System.out.println(""+Calendar.DATE);
		// System.out.println(""+calendar.getTime());
		Date lastDayOfMonth = calendar.getTime();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(lastDayOfMonth);
	}
}
