import candidate.Candidate;
import candidate.candidate_manager;
import evm.EVM_system;
import java.util.Scanner;
import voter.Voter;
import voter.voter_manager;

public class main {
    public static void main(String[] args) {
        candidate_manager cm = new candidate_manager();
        voter_manager vm = new voter_manager();
        EVM_system evm = new EVM_system(cm, vm);

        // Sample data 
        cm.add_candidate(new Candidate("AlTAF HUSSAIN", 0001, "MQM"));
        cm.add_candidate(new Candidate("IMRAN KHAN", 0002, "PTI"));
        cm.add_candidate(new Candidate("NAWAZ SHAREEF", 0003, "PMLN"));
        cm.add_candidate(new Candidate("NAEEM UR REHMAN", 0004, "JAMAT ISLAMI"));
        cm.add_candidate(new Candidate("RAFIQ AHMED", 0005, "Independent"));

        vm.add_voters(new Voter("Abdullah", 100));
        vm.add_voters(new Voter("Fatima", 101));
        vm.add_voters(new Voter("Usman", 102));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- EVM Menu ---");
            System.out.println("1. Display Candidates");
            System.out.println("2. Display Voters");
            System.out.println("3. Cast Vote");
            System.out.println("4. Display Results");
            System.out.println("5. Register Candidate");
            System.out.println("6. Register Voter");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e);
                continue;
            }

            switch (choice) {
                case 1:
                    cm.display_all_candidates();
                    break;
                case 2:
                    vm.displayvoters();
                    break;
                case 3:
                    System.out.print("Enter Voter ID: ");
                    int voterId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Candidate ID: ");
                    int candidateId = Integer.parseInt(sc.nextLine());
                    evm.castvote(voterId, candidateId);
                    break;
                case 4:
                    evm.displayResults();
                    break;
                case 5:
                    System.out.print("Enter candidate name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter candidate ID (int): ");
                    int cid = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter party: ");
                    String party = sc.nextLine();
                    cm.add_candidate(new Candidate(cname, cid, party));
                    System.out.println("Candidate added.");
                    break;
                case 6:
                    System.out.print("Enter voter name: ");
                    String vname = sc.nextLine();
                    System.out.print("Enter voter ID (int): ");
                    int vid = Integer.parseInt(sc.nextLine());
                    vm.add_voters(new Voter(vname, vid));
                    System.out.println("Voter registered.");
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting EVM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
