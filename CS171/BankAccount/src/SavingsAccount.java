public class SavingsAccount extends BankAccount {
    private double interest_rate;

    public SavingsAccount() {
        super(); //must declare "super"s first because you have to create the skeleton of the constructor first before editing intricacies
        interest_rate = .02;
    }

    public SavingsAccount(double balance) {
        super(balance);
        interest_rate = .02;
    }

    public SavingsAccount(double balance, double int_rate) {
        super(balance);
        interest_rate = int_rate;
    }

    public double getIntRate() {
        return interest_rate;
    }

    public void setIntRate(double interest) {
        interest_rate = interest;
    }

    public void add_interest() {
        //balance += balance*interest_rate;
        super.deposit(balance*interest_rate); //same as above
    }
}
