package user;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import admin.ProductsManager;
import admin.ProductsManager.ProductLists;

public class CustomerTest {
	
	Customer customer ;
	ProductsManager manager;
	
	@BeforeClass
	public void fillProductInventory() {
		manager = new ProductsManager(ProductLists.APPLE);
		manager.addProducts(100);
		
		manager = new ProductsManager(ProductLists.MILK);
		manager.addProducts(100);
		
		manager = new ProductsManager(ProductLists.NEWSPAPER);
		manager.addProducts(100);
	}

	
	@Test
	public void AddAndvalidateeWalletBalance() {
		customer = new Customer("Customer 1", 1000);
		double initialBalance = customer.checkEwalletBalance();
		customer.depositBalanceToWallet(200);
		Assert.assertEquals(customer.checkEwalletBalance(), (double)(initialBalance+200));
	}
	
	@Test
	public void addAndRemoveItemsToCart() {
		customer = new Customer("Customer 1", 1000);
		customer.addItemToCart(ProductLists.APPLE, 2);
		customer.addItemToCart(ProductLists.MILK, 2);
		double totalPayment = customer.getTotalShoppingPrice();
		Assert.assertEquals((int)totalPayment, 100);
		
		customer.removeItemFromCart(ProductLists.APPLE, 1);
		totalPayment = customer.getTotalShoppingPrice();
		Assert.assertEquals((int)totalPayment, 80);
	}
	
	@Test
	public void validateItemsCheckout() {
		customer = new Customer("Customer 1", 1000);
		customer.addItemToCart(ProductLists.APPLE, 2);
		customer.addItemToCart(ProductLists.MILK, 2);
		double totalPayment = customer.getTotalShoppingPrice();
		customer.doPayment(totalPayment);
		double ewalletBalance = customer.checkEwalletBalance();
		Assert.assertEquals((int)ewalletBalance, 900);
	}
		
}
