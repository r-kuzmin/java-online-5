package by.jonline.oop.task3;

/**
 * Создать класс Календарь с внутренним классом, с помощью объектов которого
 * можно хранить информацию о выходных и праздничных днях.
 * 
 * @author R. Kuzmin
 *
 */
public class Task3 {

	public static void main(String[] args) {
		
		Calendar calendar = new Calendar();
		
		calendar.add(new Calendar.Day(2021, 2, 1, false, true));
		calendar.add(new Calendar.Day(2021, 2, 2, false, false));
		calendar.add(new Calendar.Day(2021, 2, 3, false, false));
		calendar.add(new Calendar.Day(2021, 2, 4, false, false));
		calendar.add(new Calendar.Day(2021, 2, 5, false, false));
		calendar.add(new Calendar.Day(2021, 2, 6, true, false));
		calendar.add(new Calendar.Day(2021, 2, 7, true, false));
		
		CalendarView view = new CalendarView(calendar);
		view.printWeekends();
		view.printHolidays();
	}

}
