package admin.products;

public class NewsPaper implements Products {

	private int availableQuantity;

	@Override
	public int getQuantuty() {
		return availableQuantity;
	}

	@Override
	public void addProduct(int quantityToAdd) {
		availableQuantity += quantityToAdd;
	}
}
