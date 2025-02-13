package bankingsystem;

public class BankingSystemDemo {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Opening accounts
        bank.openAccount("ACC1001", 500.00);
        bank.openAccount("ACC1002", 1500.00);
        bank.openAccount("ACC1003", 800.00);

        // Depositing money
        bank.deposit("ACC1001", 200.00);
        bank.deposit("ACC1002", 100.00);

        // Requesting withdrawals
        bank.requestWithdrawal("ACC1001", 100.00);
        bank.requestWithdrawal("ACC1003", 900.00);  // Insufficient funds
        bank.requestWithdrawal("ACC1002", 300.00);

        // Processing withdrawals
        System.out.println("\nProcessing withdrawals...");
        bank.processWithdrawals();

        // Displaying sorted accounts by balance
        System.out.println("\nAccounts sorted by balance: " + bank.getSortedAccountsByBalance());

        // Checking balances
        System.out.println("Balance of ACC1001: $" + bank.getBalance("ACC1001"));
        System.out.println("Balance of ACC1002: $" + bank.getBalance("ACC1002"));
        System.out.println("Balance of ACC1003: $" + bank.getBalance("ACC1003"));
    }
}

