package bankoferrors;

// A CheckingAccount is a kind of Account that has all the same features
// as the base account + method for withdrawing from the balance

class CheckingAccount extends Account {
	

	
	// According to our specification, savings accounts have no protection. 
	// You cannot carry a negative balance 
	protected double overdraftLimit = -100;
	
	// constructor for checking account types. 
	// Just calls the constructor in the Account superclass (which gives it a unique number)
	CheckingAccount(double bal) {
		super(bal);
	}
	
	// allow for withdrawals but only if the result would not exceed the overdraft limit
	public boolean withdraw(double amount) {
		if( (this.balance - amount) >= this.overdraftLimit) {
			this.balance -= amount;
			return true;
		} else {
			return false;
		}
	}
}
