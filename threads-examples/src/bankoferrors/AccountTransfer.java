package bankoferrors;

class AccountTransfer {
	public static void transfer(Account from, Account to, double amount){
		System.out.printf("---------TRANSFER REPORT BEGIN ($%s)-------------%n", amount);
		System.out.printf("(BEFORE) FROM Account %d BAL = %s%n", from.number, from.balance);
		System.out.printf("(BEFORE)   TO Account %d BAL = %s%n", to.number, to.balance);
		from.withdraw(amount);
		to.deposit(amount);
		System.out.printf("(AFTER)  FROM Account %d BAL = %s%n", from.number, from.balance);
		System.out.printf("(AFTER)    TO Account %d BAL = %s%n", to.number, to.balance);
		System.out.println("---------TRANSFER REPORT END---------------");
	}
	
	public static void syncedTransfer(Account from, Account to, double amount){
		synchronized(from){
			synchronized (to) {
				System.out.printf("---------TRANSFER REPORT BEGIN ($%s)-------------%n", amount);
				System.out.printf("(BEFORE) FROM Account %d BAL = %s%n", from.number, from.balance);
				System.out.printf("(BEFORE)   TO Account %d BAL = %s%n", to.number, to.balance);
				from.withdraw(amount);
				to.deposit(amount);
				System.out.printf("(AFTER)  FROM Account %d BAL = %s%n", from.number, from.balance);
				System.out.printf("(AFTER)    TO Account %d BAL = %s%n", to.number, to.balance);
				System.out.println("---------TRANSFER REPORT END---------------");
			}
		}
	}
	
	
	public static void main(String[] args){
		final double startingBalance = 100;
		final SavingsAccount sa = new SavingsAccount(startingBalance);
		final CheckingAccount ca = new CheckingAccount(startingBalance);
		//AccountTransfer.transfer(ca, sa, 25);
		
		
		Thread one = new Thread(
				new Runnable() {
					public void run() { 
						double balance = ca.getBalance();
						double transferAmount = startingBalance - balance + 10;
						AccountTransfer.syncedTransfer(ca, sa, transferAmount);
					}
			});

		Thread two = new Thread(
				new Runnable() {
					public void run() { 
						double balance = ca.getBalance();
						double transferAmount = startingBalance - balance + 10;
						AccountTransfer.syncedTransfer(ca, sa, transferAmount);
					}
			});
		
		one.start();
		two.start();
		
		try {
			one.join();
			two.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---------FINAL BALANCES---------------");
		System.out.printf("FROM Account %d BAL = %s%n", ca.number, ca.balance);
		System.out.printf("  TO Account %d BAL = %s%n", sa.number, sa.balance);
	}
}

