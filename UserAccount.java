import java.util.ArrayList;

public class UserAccount {
    private final String accountHolder;
    private final String username;
    private final String pin;
    private double balance;
    private final ArrayList<String> transactionHistory;

    public UserAccount(String accountHolder, String username, String pin) {
        this.accountHolder = accountHolder;
        this.username = username;
        this.pin = pin;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposit Successful! New Balance: " + balance);
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Withdrawal Successful! New Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getUsername() {
        return username;
    }
}
