package user;

import java.util.ArrayList;
import java.util.List;

import admin.SubscriptionType;
import admin.products.NewsPapers.NewspaperCategory;

public class Customer {

	private String name;
	private List<NewspaperCategory> listToSubscibe;
	private SubscriptionType subscriptionType;

	public Customer(String name,SubscriptionType subscriptionType, List<NewspaperCategory> categories) {
		this.name = name;
		listToSubscibe = new ArrayList<>();
		this.listToSubscibe = categories;	
		this.subscriptionType = subscriptionType;
	}

	
	private void calculatePrice() {
		
	}
	
}
