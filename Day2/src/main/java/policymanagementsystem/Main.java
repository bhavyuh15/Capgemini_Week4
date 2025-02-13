package policymanagementsystem;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Adding policies
        manager.addPolicy(new Policy("P001", "Alice", LocalDate.of(2025, 3, 15)));
        manager.addPolicy(new Policy("P002", "Bob", LocalDate.of(2025, 2, 25)));
        manager.addPolicy(new Policy("P003", "Alice", LocalDate.of(2025, 2, 20)));
        manager.addPolicy(new Policy("P004", "Charlie", LocalDate.of(2025, 1, 15)));  // Expired

        // Retrieve by policy number
        System.out.println("Retrieve P002: " + manager.getPolicyByNumber("P002"));

        // Policies expiring in the next 30 days
        System.out.println("Expiring in next 30 days: " + manager.getExpiringPolicies());

        // Policies by holder
        System.out.println("Policies for Alice: " + manager.getPoliciesByHolder("Alice"));

        // List all policies in insertion order
        System.out.println("All Policies (Insertion Order): " + manager.listAllPoliciesInOrder());

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("After removing expired: " + manager.listAllPoliciesInOrder());
    }
}

