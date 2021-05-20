package admin;

import admin.products.Apple;
import admin.products.Milk;
import admin.products.NewsPaper;
import admin.products.Products;

public class ProductsManager {

	public enum ProductLists {
		APPLE, NEWSPAPER, MILK
	}

	private Products product;
	private ProductLists productName;

	public static double APPLE_PRICE = 20.0;
	public static double MILK_PRICE = 30.0;
	public static double NEWSPAPER_PRICE = 10.0;

	public ProductsManager(ProductLists productName) {
		this.productName = productName;
		init();
	}

	public void init() {
		switch (this.productName) {
		case APPLE:
			this.product = new Apple();
			break;

		case MILK:
			this.product = new Milk();
			break;

		case NEWSPAPER:
			this.product = new NewsPaper();
			break;

		default:
			break;
		}
	}

	public void addProducts(int quantityToAdd) {
		product.addProduct(quantityToAdd);
	}

	public int getProductQuantity() {
		return product.getQuantuty();
	}
}
