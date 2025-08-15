package candidate;
import java.util.ArrayList;
import java.util.List;

public class candidate_manager{
    // declaring a list of candidate objects
    private List<Candidate> candilist;

    // constructor
    public candidate_manager(){
        // initializing the list of candidate objects
        candilist = new ArrayList<>();
    }

    // method to add candidate by setter method 
    public void add_candidate(Candidate candi){
        // adding candidate to the list
        candilist.add(candi);
        System.out.println("Candidate Added Successfully"+candi);
        return;

    }

    // methtod to get candidate data 
    public Candidate getcandidatebyID(int candi_id){
        // iterating through the list of candidate objects
        for(Candidate c : candilist){
             if (c.getId() == candi_id) { // 'id' comes from Person
                System.out.println("Candidate found: " + c.getName() +
                 " (ID: " + c.getId());
                return c;
            }
        }
        System.out.println("No candidate found with ID: " + candi_id);
        return null;
    }

    // method to display all candidates
    public List<Candidate> getallcandidates(){
        return candilist;
    }

     // method to display all candidates
    public void display_all_candidates() {
        
        if (candilist.isEmpty()) {
            System.out.println("No candidates in the list.");
        } 
        else {
            System.out.println("List of Candidates:");
            for (Candidate c : candilist) {
                System.out.println("ID: " + c.getId() + ", Name: " + c.getName() +
                                   ", Party: " + c.party_name +
                                   ", Votes: " + c.getvotecount());
            }
        }
    }
}

