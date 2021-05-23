package admin.products.bookAndPrediocals.newspapers;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.stream.Collectors;

import admin.services.MonthName;
import admin.services.WeekDay;

public class TimesOfIndia implements INewspaper {

	private HashMap<WeekDay, Double> dailyPriceRecord;
	private HashMap<MonthName, Double> monthPriceRecord;

	public TimesOfIndia() {
		dailyPriceRecord = new HashMap<WeekDay, Double>();
		monthPriceRecord = new HashMap<MonthName, Double>();
		setDailyDefaultPrice();
		setMonthlyDefaultPrice();
	}

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

	@Override
	public HashMap<WeekDay, Double> getDefaultDailyPrice() {
		return dailyPriceRecord;
	}

	@Override
	public void updateDailyPrice(WeekDay day, double price) {
		dailyPriceRecord.replace(day, price);
	}

	@Override
	public double getDailyPrice(WeekDay day) {
		return dailyPriceRecord.get(day);
	}
	
	@Override
	public void updateMonthlyPrice(MonthName month, double price) {
		monthPriceRecord.replace(month, price);
	}

	@Override
	public HashMap<MonthName, Double> getDefaultMonthlyPrice() {
		return monthPriceRecord;
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
