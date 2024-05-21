package test;

import main.java.bank.Bank;
import main.java.bank.CheckingAccount;
import main.java.bank.SavingsAccount;
import main.java.enums.AccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateCheckingAccount() {
        bank.createAccount("John Doe", 1000, AccountType.CHECKING);
        assertEquals(1, bank.getAccounts().size());
        assertTrue(bank.getAccounts().containsKey("1"));
        assertTrue(bank.getAccounts().get("1") instanceof CheckingAccount);
    }

    @Test
    public void testCreateSavingsAccount() {
        bank.createAccount("Alice Smith", 2000, AccountType.SAVINGS);
        assertEquals(1, bank.getAccounts().size());
        assertTrue(bank.getAccounts().containsKey("1"));
        assertTrue(bank.getAccounts().get("1") instanceof SavingsAccount);
    }

    @Test
    public void testDeposit() {
        bank.createAccount("John Doe", 1000, AccountType.CHECKING);
        bank.deposit("1", 500);
        assertEquals(1500, bank.getAccounts().get("1").getBalance());
    }

    @Test
    public void testWithdraw() {
        bank.createAccount("John Doe", 1000, AccountType.CHECKING);
        bank.withdraw("1", 500);
        assertEquals(500, bank.getAccounts().get("1").getBalance());
    }

    @Test
    public void testCalculateInterest() {
        bank.createAccount("Alice Smith", 2000, AccountType.SAVINGS);
        bank.calculateInterest("1");
        assertEquals(2100, bank.getAccounts().get("1").getBalance());
    }
}

