package admin.products.newspaper;

public class Hindu implements INewsPaper{
	
	private double subscriptionPrice ;

	@Override
	public double getSubScriptionPrice() {
		return subscriptionPrice;
	}

	@Override
	public void setSubScriptionPrice(double price) {
		this.subscriptionPrice = price;
	}

}
