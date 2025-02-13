package votingsystem;

import java.util.*;

public class VotingSystem {
    // HashMap to store votes (Candidate -> Votes)
    private Map<String, Integer> voteCount;

    // LinkedHashMap to maintain order of voting
    private Map<String, Integer> voteOrder;

    public VotingSystem() {
        voteCount = new HashMap<>();
        voteOrder = new LinkedHashMap<>();
    }

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        // Update vote count in HashMap
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);

        // Record the vote in LinkedHashMap to maintain order
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }

    // Get current vote count
    public Map<String, Integer> getVoteCount() {
        return new HashMap<>(voteCount);
    }

    // Get voting order
    public Map<String, Integer> getVoteOrder() {
        return new LinkedHashMap<>(voteOrder);
    }

    // Get sorted results (alphabetical order)
    public Map<String, Integer> getSortedResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        return sortedResults;
    }

    // Get results sorted by votes (descending order)
    public Map<String, Integer> getResultsByVotes() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(voteCount.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        LinkedHashMap<String, Integer> sortedByVotes = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedByVotes.put(entry.getKey(), entry.getValue());
        }
        return sortedByVotes;
    }
}

