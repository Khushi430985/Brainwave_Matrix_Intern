import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            UserAccount userAccount = new UserAccount("user1", "user1", "1234");

            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (username.equals(userAccount.getUsername()) && userAccount.validatePin(pin)) {
                System.out.println("Login Successful! Welcome, " + userAccount.getAccountHolder());
                AccountOperations accountOperations = new AccountOperations(userAccount);
                accountOperations.displayMenu();
            } else {
                System.out.println("Invalid Username or PIN. Try again.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
