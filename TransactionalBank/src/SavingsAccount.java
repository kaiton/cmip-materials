

class SavingsAccount extends Account implements Transactional{
	

	
	// According to our specification, savings accounts have no protection. 
	// You cannot carry a negative balance 
	protected double overdraftLimit = 0;
	
	
	// constructor for savings account types. 
	// Just calls the constructor in the Account superclass (which gives it a unique number)
	SavingsAccount(double bal) {
		super(bal);
	}
	
	// withdraw funds but check to ensure that the result would not be less than zero
	// return false and don't allow withdrawals in that case
	public boolean withdraw(double amount) {
		if( (this.balance - amount) >= this.overdraftLimit) {
			this.balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deposit(double amount) {
		if(amount > 0) {
			this.balance += amount;
			return true;
		} else {
			return false;
		}
	}
}
