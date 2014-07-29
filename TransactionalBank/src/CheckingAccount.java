

class CheckingAccount extends Account implements Transactional {
	
	// According to our specification, savings accounts have no protection. 
	// You cannot carry a negative balance 
	protected double overdraftLimit = -100;
	
	// constructor for checking account types. 
	// Just calls the constructor in the Account superclass (which gives it a unique number)
	CheckingAccount(double bal) {
		super(bal);
	}
	
	protected double getOverdraftLimit(){
		return this.overdraftLimit;
	}
	
}
