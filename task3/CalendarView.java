package by.jonline.oop.task3;

import java.text.SimpleDateFormat;

public class CalendarView {

	private Calendar calendar;
	
	public CalendarView(Calendar calendar) {
		this.calendar = calendar;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public void printWeekends() {
		System.out.println("Weekends:");
		
		SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy");
		
		for (Calendar.Day day : calendar) {
			if (day.isWeekend()) {
				System.out.println("\t" + formater.format(day.getTime()));
			}
		}
	}
	
	public void printHolidays() {
		System.out.println("Holidays:");
		
		SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy");
		
		for (Calendar.Day day : calendar) {
			if (day.isHoliday()) {
				System.out.println("\t" + formater.format(day.getTime()));
			}
		}
	}
}
