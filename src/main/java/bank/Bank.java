package main.java.bank;

import main.java.enums.AccountType;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    // Attribut pour stocker les comptes de la banque
    private Map<String, Account> accounts;

    // Constructeur de la classe Bank
    public Bank() {
        accounts = new HashMap<>(); // Initialise la map des comptes de la banque
    }

    // Méthode pour obtenir la map des comptes de la banque
    public Map<String, Account> getAccounts() {
        return accounts;
    }

    // Méthode pour créer un compte dans la banque
    public void createAccount(String name, double initialBalance, AccountType type) {
        String accountId = generateAccountId();
        // Crée un nouveau compte en fonction du type spécifié
        Account account = type == AccountType.CHECKING ? new CheckingAccount(name, initialBalance) : new SavingsAccount(name, initialBalance);
        accounts.put(accountId, account); // Ajoute le nouveau compte à la map des comptes de la banque
        // Affiche un message pour indiquer que le compte a été créé avec succès
        if (type == AccountType.CHECKING) {
            System.out.println("Checking account created successfully. Account ID: " + accountId);
        } else {
            System.out.println("Savings account created successfully. Account ID: " + accountId);
        }
    }

    // Méthode pour effectuer un dépôt sur un compte spécifié
    public void deposit(String accountId, double amount) {
        if (accounts.containsKey(accountId)) {
            accounts.get(accountId).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Méthode pour effectuer un retrait sur un compte spécifié
    public void withdraw(String accountId, double amount) {
        if (accounts.containsKey(accountId)) {
            accounts.get(accountId).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Méthode pour afficher le solde d'un compte spécifié
    public void displayBalance(String accountId) {
        if (accounts.containsKey(accountId)) {
            System.out.println("Your balance is " + accounts.get(accountId).getBalance() + " euros");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Méthode privée pour générer un nouvel identifiant de compte
    private String generateAccountId() {
        return String.valueOf(accounts.size() + 1);

    }

    // Méthode pour calculer les intérêts d'un compte d'épargne spécifié
    public void calculateInterest(String accountId) {
        if (accounts.containsKey(accountId)) {
            Account account = accounts.get(accountId);
            // Vérifie si le compte est un compte d'épargne
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                savingsAccount.addInterest();
            } else {
                System.out.println("Interest calculation is only applicable to savings accounts.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

}
