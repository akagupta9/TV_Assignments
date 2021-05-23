package user;

import admin.SubscriptionManager;
import admin.services.MonthName;
import admin.services.WeekDay;
import admin.products.NewsPapers.NewspaperCategory;

public class Customer {

	private String name;
	private SubscriptionManager manager;

	public Customer(String name, NewspaperCategory category, SubscriptionManager manager) {
		this.name = name;
		this.manager = manager;
	}

	public double getTotalBill() {
		return manager.getPrice();
	}

	public double getTotalBill(WeekDay day) {
		return manager.getPrice(day);
	}

	public double getTotalBill(MonthName month) {
		return manager.getPrice(month);
	}

}
