package admin.products.bookAndPrediocals.newspapers;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.stream.Collectors;

import admin.services.MonthName;
import admin.services.WeekDay;

public class Hindu implements INewspaper {

	private static HashMap<WeekDay, Double> dailyPriceRecord;
	private static HashMap<MonthName, Double> monthPriceRecord;

	public Hindu() {
		dailyPriceRecord = new HashMap<WeekDay, Double>();
		monthPriceRecord = new HashMap<MonthName, Double>();
	}

	public void setDailyDefaultPrice() {
		dailyPriceRecord.put(WeekDay.SUNDAY, 4.0);
		dailyPriceRecord.put(WeekDay.MONDAY, 2.5);
		dailyPriceRecord.put(WeekDay.TUESDAY, 2.5);
		dailyPriceRecord.put(WeekDay.WEDNESDAY, 2.5);
		dailyPriceRecord.put(WeekDay.THURSDAY, 2.5);
		dailyPriceRecord.put(WeekDay.FRIDAY, 2.5);
		dailyPriceRecord.put(WeekDay.SATURDAY, 4.0);
	}

	public void setMonthlyDefaultPrice() {
		monthPriceRecord.put(MonthName.JANUARY, 40.0);
		monthPriceRecord.put(MonthName.FEBRUARY, 40.0);
		monthPriceRecord.put(MonthName.MARCH, 40.0);
		monthPriceRecord.put(MonthName.APRIL, 40.0);
		monthPriceRecord.put(MonthName.MAY, 40.0);
		monthPriceRecord.put(MonthName.JUNE, 40.0);
		monthPriceRecord.put(MonthName.JULY, 40.0);
		monthPriceRecord.put(MonthName.AUGUST, 40.0);
		monthPriceRecord.put(MonthName.SEPTEMBER, 40.0);
		monthPriceRecord.put(MonthName.OCTOBER, 40.0);
		monthPriceRecord.put(MonthName.NOVEMBER, 40.0);
		monthPriceRecord.put(MonthName.DECEMEBER, 40.0);
	}

	public HashMap<WeekDay, Double> getDefaultDailyPrice() {
		return dailyPriceRecord;
	}

	public HashMap<MonthName, Double> getDefaultMonthlyPrice() {
		return monthPriceRecord;
	}

	public void updateDailyPrice(WeekDay day, double price) {
		dailyPriceRecord.put(day, price);
	}

	public void updateMonthlyPrice(MonthName month, double price) {
		monthPriceRecord.put(month, price);
	}

	public double getDailyPrice(WeekDay day) {
		return dailyPriceRecord.get(day);
	}

	public double getWeeklyPrice() {
		DoubleSummaryStatistics summary = dailyPriceRecord.values().stream()
				.collect(Collectors.summarizingDouble(i -> i));
		return summary.getSum();
	}

	public double getMonthlyPrice(MonthName month) {
		return monthPriceRecord.get(month);
	}

}
