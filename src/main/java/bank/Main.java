package main.java.bank;
import main.java.enums.AccountType;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // Crée un objet Scanner pour lire l'entrée de l'utilisateur depuis la console
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            System.out.print("Enter your choice: ");

            Object choice = scanner.next(); // Lit le choix de l'utilisateur
            switch (choice.toString()) {
                case "1":
                    System.out.print("1. Create an account\n");
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    System.out.print("Enter the initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    System.out.print("Choose the account type (1 for checking, 2 for savings): ");
                    int accountTypeChoice = scanner.nextInt();
                    AccountType accountType = (accountTypeChoice == 1) ? AccountType.CHECKING : AccountType.SAVINGS;
                    bank.createAccount(name, initialBalance, accountType);
                    break;
                case "2":
                    System.out.print("2. Deposit money\n");
                    System.out.print("Enter your account identifier: ");
                    String depositAccountId = scanner.next();
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAccountId, depositAmount);
                    break;
                case "3":
                    System.out.print("3. Withdraw money\n");
                    System.out.print("Enter your account identifier: ");
                    String withdrawAccountId = scanner.next();
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawAccountId, withdrawAmount);
                    break;
                case "4":
                    System.out.print("4. Display balance \n");
                    System.out.print("Enter your account identifier: ");
                    String displayAccountId = scanner.next();
                    bank.displayBalance(displayAccountId);
                    break;
                case "5":
                    System.out.print("5. Calculate interest for a savings account\n");
                    System.out.print("Enter your account identifier: ");
                    String interestAccountId = scanner.next();
                    bank.calculateInterest(interestAccountId);
                    break;
                case "6":
                    System.out.print("6. Quit\n");
                    quit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }

        scanner.close(); // Ferme l'objet Scanner pour libérer les ressources
    }
}
