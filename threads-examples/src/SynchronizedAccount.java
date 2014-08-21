

public class SynchronizedAccount
{
	private double balance;

	public synchronized void withdraw(double anAmount)
	{
		if ((anAmount>0.0) && (anAmount<=balance))
			balance = balance - anAmount;
	}

	public synchronized void deposit(double anAmount)
	{
		if (anAmount>0.0)
			balance = balance + anAmount;
	}
}
