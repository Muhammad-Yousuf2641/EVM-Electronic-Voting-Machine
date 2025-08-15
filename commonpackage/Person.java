package commonpackage;

public class Person{
    // declare a variables
     protected String name;
     protected int id;

    // declaring a contructor
    public Person(String name,int id) {
        this.name=name;
        this.id=id;
    }
    // declaring a get id and getname to use in other packages without extends the person class
    public int getId() {
    return id;
}

public String getName() {
    return name;
}


    // delclaring a method display
    void display_details(){
        System.out.println("""
                           Person Details : 
                           Name: """+name +"Id: "+id);
    }
    
}