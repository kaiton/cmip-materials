

public class AssignmentTestAccounts
{
  public static void main(String[] args)
  {
    // create a checking account
    CheckingAccount checkingAccount = new CheckingAccount(0);
    SavingsAccount savingsAccount = new SavingsAccount(0);

    // deposit money into both accounts
    boolean resultOfCheckingDeposit = checkingAccount.deposit(100);
    boolean resultOfSavingsDeposit = savingsAccount.deposit(100);

    // report
    System.out.println("Checking Account: " + checkingAccount.balanceInquiry());
    System.out.println("Savings Account : " + savingsAccount.balanceInquiry());

    // attempt to withdraw from each account
    boolean resultOfCheckingWithdrawal = checkingAccount.withdraw(150);

    // did this succeed or fail?
    if (resultOfCheckingWithdrawal)
    {
      System.out.println("Successfully withdrew 150 from checking account (Account #" + checkingAccount.getNumber() + ") Balance is: " + checkingAccount.balanceInquiry() );
    }
    else
    {
      System.out.println("Unsuccessful withdrawal of 150 from checking account (Account #" + checkingAccount.getNumber() + ")Balance is: " + checkingAccount.balanceInquiry() );
    }

    // attempt to withdraw from each account
    boolean resultOfSavingsWithdrawal = savingsAccount.withdraw(150);

    // did this succeed or fail?
    if (resultOfSavingsWithdrawal)
    {
      System.out.println("Successfully withdrew 150 from savings account (Account #" + savingsAccount.getNumber() + "). Balance is: " + savingsAccount.balanceInquiry() );
    }
    else
    {
      System.out.println("Unsuccessful withdrawal of 150 from savings account (Account #" + savingsAccount.getNumber() + ").  Balance is: " + savingsAccount.balanceInquiry() );
    }		
  }
}
