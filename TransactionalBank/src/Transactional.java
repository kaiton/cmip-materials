
interface Transactional {
	boolean deposit(double amount);
	boolean withdraw(double amount);
	double balanceInquiry();
}