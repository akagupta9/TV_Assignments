package admin.products.bookandperiodic.newspape.subscriptions;

import admin.products.newspaper.INewsPaper;
import admin.services.Calender.WeekDay;

public class Daily implements IFequency {

	private WeekDay day;
	private double subscriptionPice;

	public Daily(WeekDay day) {
		this.day = day;
	}

	@Override
	public void setNewsPaperPrice(double price, INewsPaper newspaper) {
		newspaper.setSubScriptionPrice(price);
	}

	@Override
	public double getNewsPaperPrice(INewsPaper newspaper) {
		return newspaper.getSubScriptionPrice();
	}

}
