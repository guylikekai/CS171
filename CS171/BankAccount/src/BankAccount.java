public class BankAccount {
    protected double balance;
    protected String account_num;
    protected String routing_num;
    protected String account_holder;

    //default constructor
    public BankAccount() {
        balance = 0;
        account_num = "";
        routing_num = "";
        account_holder = "";
    }

    //alternate constructor
    public BankAccount(double balance, String account_num, String routing_num, String account_holder) {
        this.balance = balance;
        this.account_num = account_num;
        this.routing_num = routing_num;
        this.account_holder = account_holder;
    }

    //alternate constructor
    public BankAccount(double balance) {
        //this();
        //this.balance = balance;

        this(balance, "", "", "");
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNum(){
        return account_num;
    }

    public String getRoutingNum(){
        return routing_num;
    }

    public String getAccountHolder(){
        return account_holder;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }


}