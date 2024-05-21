package main.java.bank;

public class CheckingAccount extends Account {
    // Constructeur de la classe CheckingAccount
    public CheckingAccount(String ownerName, double initialBalance) {
        super(ownerName, initialBalance); // Appelle le constructeur de la classe mère avec le nom du propriétaire et le solde initial
    }

    // Méthode pour retirer de l'argent du compte chèque
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println(amount + " euros have been withdrawn from your account.");
        }
    }
}
