package admin;

import org.testng.Assert;
import org.testng.annotations.Test;

import admin.ProductsManager.ProductLists;

public class ProductManagerTest {

	private ProductsManager manager;

	@Test
	public void addAppleProductsAndValidateQuantity() {
		manager = new ProductsManager(ProductLists.APPLE);
		int initialQuantity = manager.getProductQuantity();
		manager.addProducts(50);
		Assert.assertEquals(manager.getProductQuantity(), initialQuantity + 50);
	}

	@Test
	public void addMilkProductsAndValidateQuantity() {
		manager = new ProductsManager(ProductLists.MILK);
		int initialQuantity = manager.getProductQuantity();
		manager.addProducts(40);
		Assert.assertEquals(manager.getProductQuantity(), initialQuantity + 40);
	}

	@Test
	public void addNewsPaperProductsAndValidateQuantity() {
		manager = new ProductsManager(ProductLists.NEWSPAPER);
		int initialQuantity = manager.getProductQuantity();
		manager.addProducts(10);
		Assert.assertEquals(manager.getProductQuantity(), initialQuantity + 10);
	}

}
