
abstract class Account implements Transactional
{
	// a distinct number for each account in our system
	protected int number;
	
	// the balance for this specific account
	protected double balance;
	
	// a static (belonging to the class, not the instance) int for tracking 
	// the number of Account objects (and subclasses) in our system. 
	// this is a basic implementation that uses  consecutive numbers
	private static int currentAccountNumber = 0;
	 
	
	// Constructor. Takes the balance that the account should be initially set to
	// Also generates and stores a new account number.
	public Account(double bal)
	{
		this.balance = bal;
		this.number = ++currentAccountNumber;
	}
	
	
	// return the current balance. We've protected the balance instance variable so this is needed
	// to provide access to callers outside the class/object
	public double balanceInquiry(){
		return this.getBalance();
	}
	
	
	public double getBalance(){
		return this.balance;
	}
	// account numbers are also protected so provide an accessor for that as well.
	public int getNumber(){
		return this.number;
	}
	
	
}
