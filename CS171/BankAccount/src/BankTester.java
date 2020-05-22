public class BankTester
{
    public static void main(String[] args){
        BankAccount ba = new BankAccount();
        System.out.println(ba.getBalance());
        System.out.println(ba.getAccountNum());

        BankAccount ba1 = new BankAccount(100);
        System.out.println(ba1.getBalance());
        System.out.println(ba1.getAccountNum());

        ba.deposit(10); // dad gives you $10
        ba.deposit(400); // you get a job, first month salary = 400
        ba.deposit(400); // second month salary
        System.out.println("Balance so far = " + ba.getBalance());

        // you quit your job...
        ba.withdraw(20); // you buy groceries
        ba.withdraw(700); // maybe an iPhone...?
        System.out.println("Balance after groceries and iphone = " + ba.getBalance() + "\n");
        ba.withdraw(1000); // oops
        System.out.println("Balance = " + ba.getBalance());

        // // you're almost broke, but you're donating money to a friend
        // BankAccount friendAcct = new BankAccount();
        // ba.transfer(50, friendAcct );
        // System.out.println("Balance after transfer = " + ba.getBalance() + "\n");

        // CheckingAccount ca = new CheckingAccount(300);
        // ca.deposit(30);
        // ca.withdraw(150);
        // ca.deposit(200);
        // ca.deposit(100);
        // ca.withdraw(20);
        // System.out.println("\nCheckingAccount balance BEFORE fee deduction = " + ca.getBalance());
        // // monthly fee deduction
        // ca.deductFees();
        // System.out.println("CheckingAccount balance AFTER fee deduction = " + ca.getBalance());


        // 1: create a savings account with balance $2000
        SavingsAccount sa = new SavingsAccount((2000));
        // 2: print balance
        System.out.println("Balance is: " + sa.getBalance());
        // 3: get interest rate
        System.out.println("Interest Rate: " + sa.getIntRate());
        // 4: change interest rate to 15%
        sa.setIntRate(.15);
        // 5: add interest to balance and print new balance
        sa.add_interest();
    }

}
