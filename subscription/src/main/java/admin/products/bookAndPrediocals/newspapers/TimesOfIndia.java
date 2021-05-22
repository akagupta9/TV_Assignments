package admin.products.bookAndPrediocals.newspapers;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import admin.services.MonthName;
import admin.services.WeekDay;

public class TimesOfIndia implements INewspaper {

	private HashMap<WeekDay, Double> dailyPriceRecord;
	private Map<MonthName, Double> monthPriceRecord;

	public void setDailyDefaultPrice() {
		dailyPriceRecord.put(WeekDay.SUNDAY, 6.0);
		dailyPriceRecord.put(WeekDay.MONDAY, 3.5);
		dailyPriceRecord.put(WeekDay.TUESDAY, 3.5);
		dailyPriceRecord.put(WeekDay.WEDNESDAY, 3.5);
		dailyPriceRecord.put(WeekDay.THURSDAY, 3.5);
		dailyPriceRecord.put(WeekDay.FRIDAY, 3.5);
		dailyPriceRecord.put(WeekDay.SATURDAY, 5.0);
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

	public Map<WeekDay, Double> getDefaultDailyPrice() {
		return dailyPriceRecord;
	}

	public void updateDailyPrice(WeekDay day, double price) {
		dailyPriceRecord.put(day, price);
	}

	public double getDailyPrice(WeekDay day) {
		return dailyPriceRecord.get(day);
	}
	
	public void updateMonthlyPrice(MonthName month, double price) {
		monthPriceRecord.put(month, price);
	}

	@Override
	public double getWeeklyPrice() {
		DoubleSummaryStatistics summary = dailyPriceRecord.values().stream()
				.collect(Collectors.summarizingDouble(i -> i));
		return summary.getSum();
	}

	@Override
	public double getMonthlyPrice(MonthName month) {
		return monthPriceRecord.get(month);
	}
}
