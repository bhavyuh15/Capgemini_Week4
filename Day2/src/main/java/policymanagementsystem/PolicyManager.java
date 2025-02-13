package policymanagementsystem;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    // Storage
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>();

    // Add Policy
    public void addPolicy(Policy policy) {
        // Store in HashMap
        policyMap.put(policy.getPolicyNumber(), policy);

        // Store in LinkedHashMap
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);

        // Store in TreeMap by Expiry Date
        expiryDateMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve by Policy Number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> expiring = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate limitDate = today.plusDays(30);

        // Get all keys (expiry dates) within the next 30 days
        expiryDateMap.subMap(today, true, limitDate, true).values().forEach(expiring::addAll);

        return expiring;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        // Get all expired dates
        Set<LocalDate> expiredDates = expiryDateMap.headMap(today, false).keySet();

        for (LocalDate date : expiredDates) {
            List<Policy> expiredPolicies = expiryDateMap.get(date);
            for (Policy policy : expiredPolicies) {
                policyMap.remove(policy.getPolicyNumber());
                orderedPolicyMap.remove(policy.getPolicyNumber());
            }
        }

        // Remove expired dates from TreeMap
        expiredDates.forEach(expiryDateMap::remove);
    }

    // List all policies in insertion order
    public List<Policy> listAllPoliciesInOrder() {
        return new ArrayList<>(orderedPolicyMap.values());
    }
}

