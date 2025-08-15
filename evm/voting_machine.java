package evm;

public abstract class voting_machine{
    // abstracted method declaring 
    public abstract void castvote(int voterId , int candidateId);
    public abstract void displayresult(); 
}