package bankoferrors;
class Account 
{
	
	private double overdraftLimit = 0;
	
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
		this.number = generateAccountNumber();
	}
	
	// generates a new account number by incrementing currentAccountNumber
	// Since this is done whenever the Account() constructor is called,
	// all the classes that extend Account and call super() will get a new
	// number and we can track how many accounts of all kinds are in the system
	private static int generateAccountNumber()
	{
		return ++currentAccountNumber;
	}
	
	// method for taking a deposit and returning true/false if successful.
	// by hiding the `balance` variable as protected all calls to affect the 
	// balance must come through methods like this. Here we guard against negative 
	// deposits (which would really be withdrawals in disguise) by checking the amount first
	public synchronized boolean deposit(double amount)
	{
		if(amount > 0) {
			this.balance += amount;
			return true;
		} else {
			return false;
		}
	}
	
	// return the current balance. We've protected the balance instance variable so this is needed
	// to provide access to callers outside the class/object
	public synchronized double getBalance(){
		return this.balance;
	}
	
	// account numbers are also protected so provide an accessor for that as well.
	public int getNumber(){
		return this.number;
	}
	
	// withdraw funds but check to ensure that the result would not be less than zero
	// return false and don't allow withdrawals in that case
	public synchronized boolean withdraw(double amount) {
		if( (this.balance - amount) >= this.overdraftLimit) {
			this.balance -= amount;
			return true;
		} else {
			return false;
		}
	}
}