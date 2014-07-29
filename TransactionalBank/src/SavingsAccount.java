class SavingsAccount extends Account implements Transactional{

	protected double overdraftLimit = 0;
			
	// constructor for savings account types. 
	// Just calls the constructor in the Account superclass (which gives it a unique number)
	SavingsAccount(double bal) {
		super(bal);
	}
	
	protected double getOverdraftLimit(){
		return this.overdraftLimit;
	}
}
