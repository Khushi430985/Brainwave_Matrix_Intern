import java.util.Scanner;

public class AccountOperations {
    private final UserAccount userAccount;

    public AccountOperations(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                final String result = switch (option) {
                    case 1 -> {
                        userAccount.checkBalance();
                        yield "Checked Balance";
                    }
                    case 2 -> {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                    
                        if (depositAmount <= 0) {
                            System.out.println("Invalid deposit amount. Please enter a positive value.");
                            yield "Invalid Deposit";  
                        } else {
                            userAccount.deposit(depositAmount);
                            yield "Deposited";
                        }
                    }      
                    case 3 -> {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        userAccount.withdraw(withdrawalAmount);
                        yield "Withdrew";
                    }
                    case 4 -> {
                        userAccount.printTransactionHistory();
                        yield "Transaction History";
                    }
                    case 5 -> {
                        System.out.println("Thank you for using the ATM!");
                        yield "Exit";
                    }
                    default -> {
                        yield "Invalid Option";
                    }
                };
                System.out.println(result);
                if (option == 5) return;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
