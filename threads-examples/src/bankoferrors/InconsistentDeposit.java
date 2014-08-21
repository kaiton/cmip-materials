package bankoferrors;
import java.util.*;

class InconsistentDeposit {
	static Account account = new Account();
	
	static class Account {
		int balance = 0;
		int getBalance(){
			return this.balance;
		}
		
		void setBalance(int newBalance){
			this.balance = newBalance;
		}
	}
	
	static void deposit(int amount) {
		int x = account.getBalance();   
		x += amount;            
		account.setBalance(x);  
	}
	
	static int getBalance() {
		return account.getBalance();   
	}
	
	public static void main(String[] args){
		final int numThreads = 10;
		final int numDepositsPerThread = 10;
		final Random rnd = new Random();
		class DepositThread extends Thread {
			public void run() {
				for(int i = 0 ; i < numDepositsPerThread; i++)
					try {
						Thread.sleep(rnd.nextInt(100));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					InconsistentDeposit.deposit(50);
			}
		}
		
		final ArrayList<DepositThread> threads = new ArrayList<DepositThread>();

		for (int i = 0; i < numThreads; i++) {
			DepositThread dt = new DepositThread();
			threads.add(dt);
			
			dt.start();
		}
			
		for(DepositThread dt : threads)
			try {
				dt.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Account balance = " + InconsistentDeposit.getBalance());
		
	}

}
