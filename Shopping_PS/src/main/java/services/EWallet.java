package services;

public class EWallet {
	
	public String customerName;
	public double balance;
	
	public EWallet(String customerName , double initialBalance){
		this.customerName = customerName;
		this.balance = initialBalance;
	}

	public void depositBalance(double balanceToAdd) {
		balance += balanceToAdd;
	}
	
	public void withdrawBalance(double balanceToAdd) {
		balance -= balanceToAdd;
	}
	
	public double getCurrentBalance() {
		return balance;
	}

}
