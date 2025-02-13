package votingsystem;

public class VotingSystemDemo {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        // Displaying Results
        System.out.println("Current Vote Count: " + votingSystem.getVoteCount());
        System.out.println("Vote Order: " + votingSystem.getVoteOrder());
        System.out.println("Sorted Results (Alphabetical): " + votingSystem.getSortedResults());
        System.out.println("Results Sorted by Votes (Descending): " + votingSystem.getResultsByVotes());
    }
}

