public class CheckingAccount extends BankAccount {

    final static double FEE = 0.15;

    public CheckingAccount(String name, double amount) {
        super(name, amount);
        this.setAccountNumber(this.getAccountNumber() + "-10");
    }

    public boolean withdraw (double amount) {
        amount += FEE;
        if(super.withdraw(amount)){
            return true;
        }else{
            return false;
        }
    }

}
