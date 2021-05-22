package admin.products.bookandperiodic.newspape.subscriptions;

import admin.products.newspaper.INewsPaper;

public interface IFequency {

	public void setNewsPaperPrice(double price, INewsPaper newspaper);
	public double getNewsPaperPrice(INewsPaper newspaper);
}
