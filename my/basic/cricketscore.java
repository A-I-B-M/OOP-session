import java.util.Scanner;
import java.util.ArrayList;

// Player class (Encapsulation)
class Player {
    private String name;
    private int runs;

    // Constructor
    Player(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    String getName() {
        return name;
    }

    void addRuns(int r) {
        runs += r;
    }

    void display() {
        System.out.println("Player: " + name + " | Runs: " + runs);
    }
}

// Main class
public class cricketscore {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Player> team = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== CRICKET SCORE MENU =====");
            System.out.println("1. Add Player");
            System.out.println("2. Add Runs");
            System.out.println("3. Display Scorecard");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                sc.nextLine();
                System.out.print("Enter Player Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Initial Runs: ");
                int runs = sc.nextInt();

                team.add(new Player(name, runs));
                System.out.println("Player added successfully.");

            } else if (choice == 2) {
                sc.nextLine();
                System.out.print("Enter Player Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Runs to Add: ");
                int r = sc.nextInt();

                for (Player p : team) {
                    if (p.getName().equalsIgnoreCase(name)) {
                        p.addRuns(r);
                        System.out.println("Runs updated.");
                    }
                }

            } else if (choice == 3) {
                System.out.println("\n--- SCORECARD ---");
                for (Player p : team) {
                    p.display();
                }

            } else if (choice == 4) {
                System.out.println("Match Ended.");

            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}


