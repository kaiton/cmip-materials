interface Transactional {
	void deposit(double amount);
	double withdraw(double amount) throws InvalidTransaction;
	double balanceInquiry();
}