package user;

import admin.ProductsManager.ProductLists;
import services.EWallet;
import services.ShoppingCart;

public class Customer {

	public EWallet customerwallet;
	public String name;
	public ShoppingCart cart;
	public double shoppingPrice;
	

	public Customer(String name, double initialBalance) {
		this.name = name;
		this.customerwallet = new EWallet(this.name, initialBalance);
		this.cart = new ShoppingCart();
	}

	public void addItemToCart(ProductLists productName, int quantity) {
		cart.addProduct(productName, quantity);
		shoppingPrice = cart.getTotalPrice();
	}

	public void removeItemFromCart(ProductLists productName, int quantity) {
		cart.removeProduct(productName, quantity);
		shoppingPrice = cart.getTotalPrice();
	}

	public double getTotalShoppingPrice() {
		return shoppingPrice;
	}

	public void doPayment(double balance) {
		customerwallet.withdrawBalance(balance);
	}

	public double checkEwalletBalance() {
		return customerwallet.getCurrentBalance();
	}

	public void depositBalanceToWallet(double balanceToDeposit) {
		customerwallet.depositBalance(balanceToDeposit);
	}

}
