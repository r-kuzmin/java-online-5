package by.epam.training.task3;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Calendar extends ArrayList<Calendar.Day> {

	private static final long serialVersionUID = 5533810703239183339L;

	/**
	 * День не обязательно жестко привязан к конкретному календарю. Объект Day не
	 * имеет ссылки на Calendar, но Calendar - это список Day, поэтому класс static.
	 * 
	 * @author R. Kuzmin
	 *
	 */
	public static class Day extends GregorianCalendar {

		private static final long serialVersionUID = -6811774860589603288L;
		
		private boolean weekend;
		private boolean holiday;

		public Day() {
			this(1, 1, 1, false, false);
		}
		
		public Day(int year, int month, int date, boolean weekend, boolean holiday) {
			super();
			super.clear();
			super.set(year, month - 1, date);
			this.weekend = weekend;
			this.holiday = holiday;
		}

		public boolean isWeekend() {
			return weekend;
		}

		public Day setWeekend(boolean weekend) {
			this.weekend = weekend;
			return this;
		}

		public boolean isHoliday() {
			return holiday;
		}

		public Day setHoliday(boolean holiday) {
			this.holiday = holiday;
			return this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (holiday ? 1231 : 1237);
			result = prime * result + (weekend ? 1231 : 1237);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Day other = (Day) obj;
			if (holiday != other.holiday)
				return false;
			if (weekend != other.weekend)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Day [weekend=" + weekend + ", holiday=" + holiday + ", toString()=" + super.toString() + "]";
		}

	}

}
