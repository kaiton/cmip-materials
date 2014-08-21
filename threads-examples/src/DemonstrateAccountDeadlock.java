
import java.util.*;

class Account {
	double balance;
	int id;
	static int aCountofAccounts = 0;

	Account(double balance){
		this.balance = balance;
		this.id = aCountofAccounts++;
	}

	void withdraw(double anAmount)
	{
		if ((anAmount>0.0) && (anAmount<=balance))
			balance = balance - anAmount;
	}

	void deposit(double anAmount)
	{
		if (anAmount>0.0)
			balance = balance + anAmount;
	}

	public static void transfer(Account from, Account to, double amount){
		String threadName = Thread.currentThread().getName();
		System.out.printf("Thread %s: Transferring %s from Account %d to Account %d%n",
				threadName, amount, from.id, to.id);
		synchronized(from){
			synchronized (to) {
				from.withdraw(amount);
				to.deposit(amount);
				System.out.printf("Thread %s: Account %d BAL = %s%n", threadName, from.id, from.balance);
				System.out.printf("Thread %s: Account %d BAL = %s%n", threadName, to.id, to.balance);

			}
		}
	}
	
	public static void transferWithoutDeadlocks(Account from, Account to, double amount){
		Account first = from;
		Account second = to;
		if (from.id < to.id) {
	          // Swap them
			first = to;
	        second = from;
	      }
			
		String threadName = Thread.currentThread().getName();
		System.out.printf("Thread %s: Transferring %s from Account %d to Account %d%n",
				threadName, amount, from.id, to.id);
		synchronized(first){
			synchronized (second) {
				from.withdraw(amount);
				to.deposit(amount);
				System.out.printf("Thread %s: Account %d BAL = %s%n", threadName, from.id, from.balance);
				System.out.printf("Thread %s: Account %d BAL = %s%n", threadName, to.id, to.balance);

			}
		}
	}
}


class DemonstrateAccountDeadlock {
	private static final int NUM_THREADS = 20;
	private static final int NUM_ACCOUNTS = 5;
	private static final int NUM_ITERATIONS = 1000;
	
	
	public static void simpleTransfer(String[] args){
		final Account firstAccount = new Account(100);
		final Account secondAccount = new Account(100);
		new Thread(
			new Runnable() {
				public void run() { 
					Account.transfer(firstAccount, secondAccount, 50);
				}
		}).start();
		
		new Thread(
				new Runnable() {
					public void run() { 
						Account.transfer(secondAccount, firstAccount, 23);
					}
			}).start();
	}
	
	public static void lookMomNoDeadlocks(String[] args){
		final Random rnd = new Random();
		final Account[] accounts = new Account[NUM_ACCOUNTS];
	
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(100);
		}
		
		class TransferThread extends Thread {
			public void run() {
				for (int i=0; i<NUM_ITERATIONS; i++) {
					int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
					int toAcct = rnd.nextInt(NUM_ACCOUNTS);
					double amount = rnd.nextInt(100);
					Account.transferWithoutDeadlocks(accounts[fromAcct], accounts[toAcct], amount);
				}
			}
		}
		for (int i = 0; i < NUM_THREADS; i++)
			new TransferThread().start();
	}
	
	public static void multiThreadTransfer(String[] args) {
		final Random rnd = new Random();
		final Account[] accounts = new Account[NUM_ACCOUNTS];
	
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(100);
		}
		
		class TransferThread extends Thread {
			public void run() {
				for (int i=0; i<NUM_ITERATIONS; i++) {
					int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
					int toAcct = rnd.nextInt(NUM_ACCOUNTS);
					double amount = rnd.nextInt(100);
					Account.transfer(accounts[fromAcct], accounts[toAcct], amount);
				}
			}
		}
		for (int i = 0; i < NUM_THREADS; i++)
			new TransferThread().start();
	}
	
	public static void main(String[] args){
		//multiThreadTransfer(args);
		//lookMomNoDeadlocks(args);
	}
}
