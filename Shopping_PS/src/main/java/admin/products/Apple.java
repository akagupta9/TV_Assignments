package admin.products;

public class Apple implements Products {
	
	private int availableQuantity;
	
	@Override
	public void addProduct(int quantityToAdd) {
		availableQuantity+=quantityToAdd;
	}

	@Override
	public int getQuantuty() {
		return availableQuantity;
	}
}
