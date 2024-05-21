package main.java.bank;

public abstract class Account {
    // Attributs de la classe Account
    private String accountId; // Identifiant du compte
    private String ownerName; // Nom du propriétaire du compte
    protected double balance; // Solde du compte

    // Constructeur de la classe Account
    public Account(String ownerName, double initialBalance) {
        this.ownerName = ownerName; // Initialise le nom du propriétaire du compte
        this.balance = initialBalance;
    }

    // Méthode pour déposer de l'argent dans le compte
    public void deposit(double amount) {
        balance += amount;
        System.out.println( amount + " euros have been deposited into your account.");
    }

    // Méthode abstraite pour retirer de l'argent du compte (Implémentée dans les sous-classes)
    public abstract void withdraw(double amount);

    // Méthode pour obtenir le solde du compte
    public double getBalance() {
        return balance;
    }
}
