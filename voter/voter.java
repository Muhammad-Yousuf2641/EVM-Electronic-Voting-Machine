package voter;
import commonpackage.Person;

public class Voter extends Person{

private boolean hasvoted ;

    // constructor 
    public Voter(String name , int id ){
        super(name,id);
        this.hasvoted = false;
    }

    // method markvoted 
    public void markvoted(){
        this.hasvoted = true ;
        return;
    }

    // method to chek if voter hasvoted or not 
    public boolean checkvoted(){
        if(hasvoted==true){
            return true ;
        }
        else{
            // System.out.println("Cast your vote!");
        }
        return false ;
        
    }


    // method to display voter 
    public void display_details() {
    System.out.println("\nVoter Details:\n");
    System.out.println(" ID: " + this.id);
    System.out.println(" Name: " + this.name);
    System.out.println(" Has Voted: " + this.hasvoted);
}

}
