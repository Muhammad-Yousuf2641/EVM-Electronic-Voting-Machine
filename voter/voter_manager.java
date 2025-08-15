package voter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class voter_manager{
    private List<Voter> voters;
    
    // constructor 
    public voter_manager(){
        voters=new ArrayList<>();
    }

    // method to add_voters
    public void add_voters(Voter v){
        voters.add(v);
    }

    // meothod to get_voters
    public Voter getvoter(int id) {
        Optional<Voter> opt = voters.stream()
                .filter(v -> v.getId() == id)
                .findFirst();
        return opt.orElse(null);
    }

    // method to get all voters
    public List<Voter> getallvoters(){
        return voters;
    }

    // display all voters 
    public void displayvoters(){
        System.out.println("---voters---");
            if(voters.isEmpty()){
                System.out.println("No voters registered");
            }else{
                System.out.println("Printing voters list\n ");
                for(Voter v : voters){
                    v.display_details();
                }
            }
        }
    }
