package admin;

import java.util.List;
import java.util.Map;

import admin.services.MonthName;
import admin.services.WeekDay;
import admin.products.NewsPapers.NewspaperCategory;
import admin.products.bookAndPrediocals.newspapers.INewspaper;

public class SubscriptionManager {

	private Map<WeekDay, Double> dailyPriceRecord;
	private double weeklySubscriptionPrice;
	private double monthlySubscriptionPrice;
	private INewspaper newspaper;
	
	private void init() {
		dailyPriceRecord  = newspaper.getDefaultDailyPrice();
	}
	
	public SubscriptionManager(INewspaper newspaper) {
		this.newspaper = newspaper;
		init();
	}
	
	public void setDailySubscriptionPrice(WeekDay day , double price) {
		newspaper.updateDailyPrice(day, price);
	}
	
	public void setMonthlySubscriptionPrice(MonthName month , double price) {
		newspaper.updateMonthlyPrice(month, price);
	}
	
	public double getDailySubscriptionPrice(WeekDay day ) {
		return newspaper.getDailyPrice(day);
	}
	
	public double getWeeklySubscriptionPrice() {
		return newspaper.getWeeklyPrice();
	}
	
	public double getMonthlySubscriptionPrice(MonthName name) {
		return newspaper.getMonthlyPrice(name);
	}
	
}
