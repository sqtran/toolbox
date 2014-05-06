package date;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date start = new GregorianCalendar(2012+1900, 10, 2).getTime();
		Date end = new GregorianCalendar(2012+1900, 10, 17).getTime();

		Date d3 = new GregorianCalendar(2012+1900, 10, 17).getTime();
		Date d4 = new GregorianCalendar(2012+1900, 10, 17).getTime();

		System.out.println(overlap(start, end, d3, d4));

		System.out.println(overlap2(start, end, d3, d4));
		
		
		System.out.println(new Date().toString());


		System.out.println(new Date("Jun 10 17:00 EDT 2013"));
		System.out.println(new Date("6/10/2013 17:00:00"));
		
		System.out.println(new Date("June 10 2013 17:00"));

	}
	
	/**
	 * @return true if [start2,end2] overlaps in the start,end time frame.
	 */
	public static boolean overlap2(Date s1, Date e1, Date s2, Date e2) {
		long d1 = s1.getTime(), d2 = e1.getTime(), d3 = s2.getTime(), d4 = e2.getTime();
		if(d3 < d2) {
			if(( d3 + (d4 - d3)) > d1) return true;
		}
		return false;
	}

	public static boolean overlap(Date start, Date end, Date start2, Date end2) {
		if(start == start2) return true;
		if(start.compareTo(start2) * start2.compareTo(end) > 0) return true;	
		if(start.compareTo(end2) * end2.compareTo(end) > 0) return true;
		long d1 = start.getTime(), d2 = end.getTime(), d3 = start2.getTime(), d4 = end2.getTime();
		long duration2 = d4 - d3;

		if(d3 < d2) {
			if(( d3 + duration2) > d1) return true;
		}

		return false;
	}
}
