

class CheckingAccount extends Account implements Transactional {
	
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
	
	// method for taking a deposit and returning true/false if successful.
	// by hiding the `balance` variable as protected all calls to affect the 
	// balance must come through methods like this. Here we guard against negative 
	// deposits (which would really be withdrawals in disguise) by checking the amount first
	public boolean deposit(double amount) {
		if(amount > 0) {
			this.balance += amount;
			return true;
		} else {
			return false;
		}
	}
}
