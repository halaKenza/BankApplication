package main.java.bank;

public class SavingsAccount extends Account {
    // Constante pour stocker le montant maximum autorisé pour un retrait
    private static final double MAX_WITHDRAWAL_AMOUNT = 1000;

    // Constructeur de la classe SavingsAccount
    public SavingsAccount(String ownerName, double initialBalance) {
        // Appelle le constructeur de la classe mère avec le nom du propriétaire et le solde initial
        super(ownerName, initialBalance);
    }

    // Méthode pour retirer de l'argent du compte d'épargne
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else if (amount > MAX_WITHDRAWAL_AMOUNT) {
            System.out.println("Withdrawal amount exceeds maximum limit per period.");
        } else {
            balance -= amount;
            System.out.println(amount + " euros have been withdrawn from your account.");
        }
    }

    // Méthode pour ajouter les intérêts au compte d'épargne
    public void addInterest() {
        double interest = balance * 0.05; // 5% interest rate
        balance += interest; // Ajoute les intérêts au solde du compte
        System.out.println("Interest for this month is " + interest + " euros.");
    }
}
