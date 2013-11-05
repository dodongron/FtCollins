/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Dummy
 */
public class DateType {

	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sf2 = new SimpleDateFormat("MMM d yyyy");
	public static SimpleDateFormat datetime = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");
	public static SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss aa");
	public static SimpleDateFormat time2 = new SimpleDateFormat("hh:mm aa");
	public static SimpleDateFormat sf1 = new SimpleDateFormat(
			"EEE, MMM dd,yyyy");
	public static SimpleDateFormat d = new SimpleDateFormat("dd");
	public static SimpleDateFormat m = new SimpleDateFormat("MMMMMMMMMMM");
	public static SimpleDateFormat m1 = new SimpleDateFormat("MM");
	public static SimpleDateFormat y = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat liquid = new SimpleDateFormat(
			"EEEEEEEEEEE dd MMMMMMMMMMM yyyy");
	public static SimpleDateFormat day = new SimpleDateFormat("EEEEEEEEEEE");
	public static SimpleDateFormat day_1 = new SimpleDateFormat(
			"EEEEEEEEEEE dd");
	public static SimpleDateFormat month_year = new SimpleDateFormat(
			"MMMMMMMMMMM yyyy");
	public static SimpleDateFormat month_date = new SimpleDateFormat(
			"MMMMMMMMMM dd, yyyy");
	public static SimpleDateFormat month_date2 = new SimpleDateFormat(
			"MMM dd, yyyy");
	public static SimpleDateFormat day_and_time = new SimpleDateFormat(
			"MMMMMMMMMM dd, yyyy hh:mm aa");
	public static SimpleDateFormat day_and_time2 = new SimpleDateFormat(
			"MM/dd/yyyy hh:mm aa");
	public static SimpleDateFormat str = new SimpleDateFormat(
			"MMMMMMMMMMM dd,yyyy (EEEEEEEE)");
	public static SimpleDateFormat slash = new SimpleDateFormat(
			"MM/dd/yy HH:mm");
	public static SimpleDateFormat w_day = new SimpleDateFormat(
			"EEE MMM dd,yyyy");
	public static SimpleDateFormat w_day2 = new SimpleDateFormat(
			"EEE MMM. dd,yyyy");
	public static SimpleDateFormat time_am_pm = new SimpleDateFormat("HH:mm aa");
	
	public static SimpleDateFormat MM_dd_yy1 = new SimpleDateFormat("M/d/yy");
	public static SimpleDateFormat MM_dd_yy = new SimpleDateFormat("MM/dd/yy");
	public static SimpleDateFormat MMMMM_dd_yy = new SimpleDateFormat("MMMMMMMM/dd/yy");
	public static SimpleDateFormat MMMMM_dd_yy_time = new SimpleDateFormat("MM/dd/yy HH:mm");
	public static SimpleDateFormat time1 = new SimpleDateFormat("HH:mm");
	public static void main2(String[] args) {
		System.out.println(nth("20"));
	}
	public static String nth(String day) {
		String nth = day;

		if (nth.startsWith("0")) {
			nth = nth.replaceAll("0", "");
		}

		if (nth.endsWith("0") || nth.endsWith("4") || nth.endsWith("5")
				|| nth.endsWith("6") || nth.endsWith("7") || nth.endsWith("8")
				|| nth.endsWith("9")) {
			nth = nth + "th";
		}
		if (nth.endsWith("1")) {
			nth = nth + "st";
		}
		if (nth.endsWith("2")) {
			nth = nth + "nd";
		}
		if (nth.endsWith("3")) {
			nth = nth + "rd";
		}
		return nth;
	}

	public static String convert_jan_1_2013_datetime(String datetime) {
		String date = "";
		Date d = new Date();
		if (datetime.isEmpty()) {
			datetime = DateType.datetime.format(new Date());
		}
		try {
			d = DateType.datetime.parse(datetime);
		} catch (ParseException ex) {
			Logger.getLogger(DateType.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		date = DateType.day_and_time.format(d);
		return date;
	}

	public static String convert_jan_1_2013_date_db(String datetime) {
		String date = "";
		Date d = new Date();
		if (datetime.isEmpty()) {
			datetime = DateType.month_date.format(new Date());
		}
		try {
			d = DateType.month_date.parse(datetime);
		} catch (ParseException ex) {
			Logger.getLogger(DateType.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		date = DateType.sf.format(d);
		return date;
	}

	public static String convert_jan_1_2013_date_rep(String datetime) {
		String date = "";
		Date d = new Date();
		if (datetime.isEmpty()) {
			datetime = DateType.sf.format(new Date());
		}
		try {
			d = DateType.sf.parse(datetime);
		} catch (ParseException ex) {
			Logger.getLogger(DateType.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		date = DateType.month_date2.format(d);
		return date;
	}

	public static List<String> days() {
		List<String> days = new ArrayList();
		for (int i = 1; i < 32; i++) {
			String l = "" + i;
			String add = "";
			if (l.length() == 1) {
				add = "0" + l;
			} else {
				add = "" + l;
			}
			days.add(add);
		}
		return days;
	}

	public static List<String> months() {
		List<String> days = new ArrayList();
		for (int i = 1; i < 13; i++) {
			String l = "" + i;
			String add = "";
			if (l.length() == 1) {
				add = "0" + l;
			} else {
				add = "" + l;
			}
			days.add(add);
		}
		return days;
	}

	public static String m(){
		String json="{'1':'January', '2':'Feb', '3':'Mar', '4':'Apr'}";
		return  json;
	}
	public static List<String> monthNames() {
		List<String> months = new ArrayList<String>();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
		return months;
	}

	public static List<String> years() {
		List<String> years = new ArrayList();
		int year = Integer.parseInt(DateType.y.format(new Date()));
		for (int i = 1; i < 3; i++) {
			years.add("" + year);
			year++;
		}
		return years;
	}

	// public static void main(String[] args) {
	// System.out.println(Arrays.asList(years()));
	// }
}
