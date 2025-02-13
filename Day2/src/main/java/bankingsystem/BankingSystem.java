package bankingsystem;

import java.util.*;

public class BankingSystem {
    // HashMap to store customer accounts (AccountNumber -> Balance)
    private Map<String, Double> accounts;

    // Queue to process withdrawal requests
    private Queue<String> withdrawalRequests;

    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalRequests = new LinkedList<>();
    }

    // Open a new account
    public void openAccount(String accountNumber, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
        } else {
            accounts.put(accountNumber, initialBalance);
            System.out.println("Account opened: " + accountNumber + " with balance: $" + initialBalance);
        }
    }

    // Deposit money
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
            System.out.println("Deposited $" + amount + " to account: " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Request withdrawal (added to queue)
    public void requestWithdrawal(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalRequests.add(accountNumber + ":" + amount);
            System.out.println("Withdrawal request of $" + amount + " from account: " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Process withdrawal requests in order
    public void processWithdrawals() {
        while (!withdrawalRequests.isEmpty()) {
            String request = withdrawalRequests.poll();
            String[] parts = request.split(":");
            String accountNumber = parts[0];
            double amount = Double.parseDouble(parts[1]);

            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Processed withdrawal of $" + amount + " from account: " + accountNumber);
            } else {
                System.out.println("Insufficient funds for account: " + accountNumber);
            }
        }
    }

    // Get sorted accounts by balance (ascending order)
    public Map<String, Double> getSortedAccountsByBalance() {
        TreeMap<String, Double> sortedAccounts = new TreeMap<>(Comparator.comparingDouble(accounts::get));
        sortedAccounts.putAll(accounts);
        return sortedAccounts;
    }

    // Get account balance
    public double getBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }
}

