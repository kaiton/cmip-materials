public class AssignmentTestAccounts {
	
	public static void main(String[] args) {
		
		double initialAccountBalance = 100;
		Account[] accounts = {new SavingsAccount(initialAccountBalance), new CheckingAccount(initialAccountBalance)};
    
		for(Account account : accounts){	
			try {
				System.out.println(account.getClass().getSimpleName() + " balance:= $" + account.balanceInquiry());
				account.deposit(20);
				System.out.println(account.getClass().getSimpleName() + " balance:= $" + account.balanceInquiry());
				double amountWithdrew = account.withdraw(125);
				System.out.println(account.getClass().getSimpleName() + " balance:= $" + account.balanceInquiry());
			} catch (IllegalArgumentException e) {
				System.out.println(account.getClass().getSimpleName() + "=>  " + e);
			} catch (InvalidTransaction e) {
				System.out.println(account.getClass().getSimpleName() + "=> " + e);
			} finally {
				System.out.println("Finally, " + account.getClass().getSimpleName() + " balance:= $" + account.balanceInquiry());
				System.out.println();
			}
		}
	}
}