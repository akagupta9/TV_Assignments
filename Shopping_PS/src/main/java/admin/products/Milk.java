package admin.products;

public class Milk implements Products{
	
	private int availableQuantity;

	@Override
	public int getQuantuty() {
		// TODO Auto-generated method stub
		return availableQuantity;
	}

	@Override
	public void addProduct(int quantityToAdd) {
		availableQuantity+=quantityToAdd;
	}
	


}
