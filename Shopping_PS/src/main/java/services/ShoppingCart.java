package services;

import admin.ProductsManager;
import admin.ProductsManager.ProductLists;

public class ShoppingCart {

	public double totalPrice;
	public double itemPrice;
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void initPrice(ProductLists productName) {
		switch (productName) {
		case APPLE:
			this.itemPrice = ProductsManager.APPLE_PRICE;
			break;

		case MILK:
			this.itemPrice = ProductsManager.MILK_PRICE;
			break;

		case NEWSPAPER:
			this.itemPrice = ProductsManager.NEWSPAPER_PRICE;
			break;
		}
	}

	public void addProduct(ProductLists productName, int quantity) {
		initPrice(productName);
		this.totalPrice += (itemPrice) * quantity;
	}
	
	public void removeProduct(ProductLists productName , int quantity) {
		initPrice(productName);
		this.totalPrice -= (itemPrice) * quantity;
	}
	
	public void doPaymentCheckout(EWallet customerWallet) {
		customerWallet.withdrawBalance(totalPrice);
	}

}
