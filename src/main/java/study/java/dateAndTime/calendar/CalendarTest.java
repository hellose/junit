package study.java.dateAndTime.calendar;

import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarTest {

	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	private static class DateAndTimeInfo {

		private int year;
		private int month;
		private int dayOfMonth;

		// 12시 시간(0~11). Noon and midnight are represented by 0, not by 12.
		private int hour;
		// 24시 시간(0~23)
		private int hourOfDay;

		private int minute;
		private int second;
		private int milliSecond;

		public DateAndTimeInfo(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second,
				int milliSecond) {
			this.year = year;
			this.month = month;
			this.dayOfMonth = dayOfMonth;
//			this.hour = hour;
			this.hourOfDay = hourOfDay;
			this.minute = minute;
			this.second = second;
			this.milliSecond = milliSecond;
		}

		public DateAndTimeInfo fromCalendar(Calendar cal) {
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

			hour = cal.get(Calendar.HOUR);
			hourOfDay = cal.get(Calendar.HOUR_OF_DAY);

			minute = cal.get(Calendar.MINUTE);
			second = cal.get(Calendar.SECOND);
			milliSecond = cal.get(Calendar.MILLISECOND);
			
			return this;
		}

		public Calendar toCalendar() {
			Calendar cal = Calendar.getInstance();

			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month - 1);
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, second);
			cal.set(Calendar.MILLISECOND, milliSecond);

			return cal;
		}
	}

	@Test
	@DisplayName("Calendar를 사용해서 날짜 및 시간을 가져오기")
	void getCurrentDateAndTime() {
		Calendar now = Calendar.getInstance();
		log.debug("Calendar: {}", now);

		DateAndTimeInfo info = new DateAndTimeInfo();
		info.fromCalendar(now);
		log.debug("DateAndTimeInfo: {}", info);
	}

	@Test
	@DisplayName("String을 통해 Calendar날짜를 설정하기")
	void setCalendarDateAndTime() {
		DateAndTimeInfo info = new DateAndTimeInfo(2050, 11, 29, 13, 30, 00, 500);
		Calendar cal = info.toCalendar();
		log.debug("Calendar: {}", cal);
	}

}
