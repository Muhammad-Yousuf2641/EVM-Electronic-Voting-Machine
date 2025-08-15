package candidate;
import commonpackage.Person; //invoked a package common

public class Candidate extends Person{ 
// declaring a variables
String party_name;
private int votecount; // access by get and set method only
    
    // constructor
    public Candidate(String name ,int id, String party_name) {
        
        // calling the constructor of parent class
        super(name , id); 
        this.party_name = party_name;
        this.votecount=0;
    }

    //method to increament vote 
    public void set_increamentvote(){
        votecount++;
    }

    // method to get votecount
    public int getvotecount(){
        return votecount;
    }

      public String getParty() {
        return party_name;
    }

    // method to display_details
    public void displayDetails() {
        System.out.println("Candidate ID: " + id + 
        " | Name: " + name +
        " | Party: " + party_name + 
        " | Votes: " + votecount);
    }}
