abstract class Account implements Transactional {
	// a distinct number for each account in our system
	protected int number;
	
	// the balance for this specific account
	protected double balance;
	
	protected double overdraftLimit;
	
	// a static (belonging to the class, not the instance) int for tracking 
	// the number of Account objects (and subclasses) in our system. 
	// this is a basic implementation that uses  consecutive numbers
	private static int currentAccountNumber = 0;
	 
	
	// Constructor. Takes the balance that the account should be initially set to
	// Also generates and stores a new account number.
	public Account(double bal) {
		this.balance = bal;
		this.number = ++currentAccountNumber;
	}
	
	
	abstract protected double getOverdraftLimit();
	
	public double withdraw(double amount)  throws InvalidTransaction {
		if(amount <= 0) {
			throw new IllegalArgumentException("Transactions must be > 0");
		}
		if( (this.balance - amount) >= this.getOverdraftLimit()) {
			this.balance -= amount;
			return amount;
		} else {
			throw new InvalidTransaction("Transaction amount exceeds balance");
		}
	}

	public void deposit(double amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("Transactions must be > 0");
		}
		this.balance += amount;
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
