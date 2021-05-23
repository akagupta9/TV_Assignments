package admin;

import admin.services.MonthName;
import admin.services.WeekDay;
import admin.products.NewsPapers.NewspaperCategory;
import admin.products.bookAndPrediocals.newspapers.Hindu;
import admin.products.bookAndPrediocals.newspapers.INewspaper;
import admin.products.bookAndPrediocals.newspapers.TimesOfIndia;

public class SubscriptionManager {

	private INewspaper newspaper;

	public SubscriptionManager(NewspaperCategory category) {
		this.newspaper = initNewsPaperObject(category);
		this.newspaper.setDailyDefaultPrice();
		this.newspaper.setMonthlyDefaultPrice();
	}
	
	public double getPrice() {
		return getWeeklySubscriptionPrice();
	}

	public double getPrice(WeekDay day) {
		return getDailySubscriptionPrice(day);
	}

	public double getPrice(MonthName month) {
		return getMonthlySubscriptionPrice(month);
	}

	public void setDailySubscriptionPrice(WeekDay day, double price) {
		newspaper.updateDailyPrice(day, price);
	}

	public void setMonthlySubscriptionPrice(MonthName month, double price) {
		newspaper.updateMonthlyPrice(month, price);
	}

	private double getDailySubscriptionPrice(WeekDay day) {
		return newspaper.getDailyPrice(day);
	}

	private double getWeeklySubscriptionPrice() {
		return newspaper.getWeeklyPrice();
	}

	private double getMonthlySubscriptionPrice(MonthName name) {
		return newspaper.getMonthlyPrice(name);
	}

	private INewspaper initNewsPaperObject(NewspaperCategory category) {
		INewspaper newspaper = new Hindu();
		switch (category) {
		case HINDU:
			newspaper = new Hindu();
			break;

		case TOI:
			newspaper = new TimesOfIndia();
			break;

		default:
			break;
		}
		return newspaper;
	}
}
