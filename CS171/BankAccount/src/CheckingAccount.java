public class CheckingAccount extends BankAccount {
    private static final int NUM_FREE_TRANSACTIONS = 2; //unchanging variables are in all caps
    private static final double TRANSACTION_FEE_PERCENT = .01;
    private int num_transactions;

    //default constructor
    public CheckingAccount() {
        super();
        num_transactions = 0;
    }

    public CheckingAccount (double balance, String account_num, String routing_num, String account_holder) {
        super(balance, account_num, routing_num, account_holder);
        num_transactions = 0;
    }

    public CheckingAccount(double balance) {
        super(balance);
        num_transactions = 0;
    }

    public int getNumTransactions() {
        return num_transactions;
    }

    @Override
    public double deposit(double amount) {
        if(num_transactions > NUM_FREE_TRANSACTIONS) {
            balance -= balance*TRANSACTION_FEE_PERCENT;
        }
        num_transactions++;
        return super.deposit(amount);
    }

    @Override
    public double withdraw(double amount) {
        if(num_transactions > NUM_FREE_TRANSACTIONS) {
            balance -= balance*TRANSACTION_FEE_PERCENT;
        }
        num_transactions++;
        return super.deposit(amount);
    }
}
