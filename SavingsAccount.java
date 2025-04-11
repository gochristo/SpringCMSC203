public class SavingsAccount extends BankAccount {

    double rate = 0.025;
    int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String name, double balance) {

        super(name, balance);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;

    }

    public SavingsAccount (SavingsAccount account, double balance) {

        super(account, balance);
        this.savingsNumber = (account.savingsNumber + 1);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;

    }

    public void postInterest(){
        double interest = (this.getBalance()*rate) / 12 ;
        this.setBalance(this.getBalance() + interest);
    }

    public String getAccountNumber() {
        return accountNumber;
    }



}
