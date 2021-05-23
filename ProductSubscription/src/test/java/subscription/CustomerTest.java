package subscription;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import admin.SubscriptionManager;
import admin.services.WeekDay;
import admin.products.NewsPapers.NewspaperCategory;
import user.Customer;

public class CustomerTest {

	SubscriptionManager hinduManager;
	SubscriptionManager toiManager;

	@BeforeClass
	public void updatePrice() {
		hinduManager = new SubscriptionManager(NewspaperCategory.HINDU);
		toiManager = new SubscriptionManager(NewspaperCategory.TOI);
		hinduManager.setDailySubscriptionPrice(WeekDay.MONDAY, 4.5);
	}

	@Test
	public void validateDailyBill() {
		Customer customer = new Customer("Akanksha", NewspaperCategory.HINDU, hinduManager);
		double price = customer.getTotalBill(WeekDay.MONDAY);
		Assert.assertEquals(price, 4.5);
	}

	@Test
	public void validateWeeklyBill() {
		Customer customer = new Customer("Akanksha", NewspaperCategory.TOI, toiManager);
		double price = customer.getTotalBill();
		Assert.assertEquals(price, 28.5);
	}

	@Test
	public void validateWeeklyBillForHindu() {
		Customer customer = new Customer("Akanksha", NewspaperCategory.HINDU, hinduManager);
		double price = customer.getTotalBill();
		Assert.assertEquals(price, 22.5);
	}

}
