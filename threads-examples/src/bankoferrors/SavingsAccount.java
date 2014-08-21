package bankoferrors;

// A SavingsAccount is a kind of Account that has all the same features
// as the base account + a method for withdrawing from the balance
// According to our specification, savings accounts have no protection. 
// They cannot carry a negative balance 

class SavingsAccount extends Account {
	

	
	// According to our specification, savings accounts have no protection. 
	// You cannot carry a negative balance 
	protected double overdraftLimit = 0;
	
	
	// constructor for savings account types. 
	// Just calls the constructor in the Account superclass (which gives it a unique number)
	SavingsAccount(double bal) {
		super(bal);
	}
	

}
