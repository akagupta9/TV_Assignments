package admin.products.bookAndPrediocals.newspapers;

import java.util.HashMap;

import admin.services.MonthName;
import admin.services.WeekDay;

public interface INewspaper {

	public void setDailyDefaultPrice();

	public void setMonthlyDefaultPrice();

	public HashMap<WeekDay, Double> getDefaultDailyPrice();

	public HashMap<MonthName, Double> getDefaultMonthlyPrice();

	public void updateDailyPrice(WeekDay day, double price);

	public void updateMonthlyPrice(MonthName day, double price);

	public double getDailyPrice(WeekDay day);

	public double getWeeklyPrice();

	public double getMonthlyPrice(MonthName monthname);
}
