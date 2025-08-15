package evm;
import candidate.Candidate;
import candidate.candidate_manager;
import java.util.*;
import voter.Voter;
import voter.voter_manager;
public class EVM_system extends voting_machine{
    
    private candidate_manager candidatemanager;
    private voter_manager votermanager;

    // contructor
    public EVM_system(candidate_manager cm , voter_manager vm ){
        this.candidatemanager = cm ;
        this.votermanager = vm ;
    };

    @Override
    public void castvote(int voterId , int candidateId ){
        Voter voterobj = votermanager.getvoter(voterId);

        if(voterobj == null){
             System.out.println("Voter with ID " + voterId + " not found.");
            return;
        }
        if(voterobj.checkvoted()){
            System.out.println("Voter with ID " + voterId + " has already voted.");
            return;
        }

        
        Candidate candidateobj = (Candidate) candidatemanager.getcandidatebyID(candidateId);
        
        if(candidateobj == null){
             System.out.println("candidate with ID " + candidateId + " not found.");
            return;
        }
        
        candidateobj.set_increamentvote();
        voterobj.markvoted();
        System.out.println("Vote cast successfully for candidate " + candidateobj.getName() + " by voter " + voterobj.getName());
    }



    public void displayResults() {
        List<candidate.Candidate> list = new ArrayList<>(candidatemanager.getallcandidates());
        if (list.isEmpty()) {
            System.out.println("No candidates to display results.");
            return;
        }

        System.out.println("---- Election Results ----");
        int maxVotes = -1;
        for (Candidate c : list) {
            System.out.println(c.getName() + " (" + c.getParty() + ") - Votes: " + c.getvotecount());
            if (c.getvotecount() > maxVotes) {
                maxVotes = c.getvotecount();
            }
        }

        // Determine winners (handle ties)
        List<Candidate> winners = new ArrayList<>();
        for (Candidate c : list) {
            if (c.getvotecount() == maxVotes) {
                winners.add(c);
            }
        }

        if (maxVotes == 0) {
            System.out.println("No votes cast yet.");
        } else if (winners.size() == 1) {
            Candidate winner = winners.get(0);
            System.out.println("Winner: " + winner.getName() + " (" + winner.getParty() + ") with " + winner.getvotecount() + " votes.");
        } else {
            System.out.println("It's a tie between:");
            for (Candidate win : winners) {
                System.out.println("- " + win.getName() + " (" + win + ") with " 
                + win.getvotecount() + " votes.");
            }
        }
    }

    @Override
    public void displayresult() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

