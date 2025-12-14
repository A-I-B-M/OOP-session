import java.util.Scanner;
import java.util.ArrayList;

// Bank Account class (Encapsulation)
class BankAccount {
    private int accountNo;
    private String name;
    private double balance;

    // Constructor
    BankAccount(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    // Getter
    int getAccountNo() {
        return accountNo;
    }

    // Deposit
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful.");
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Display
    void display() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

// Main class
public class banking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display All Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Account No: ");
                int acc = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                double bal = sc.nextDouble();

                accounts.add(new BankAccount(acc, name, bal));
                System.out.println("Account created successfully.");

            } else if (choice == 2) {
                System.out.print("Enter Account No: ");
                int acc = sc.nextInt();

                for (BankAccount b : accounts) {
                    if (b.getAccountNo() == acc) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        b.deposit(amt);
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter Account No: ");
                int acc = sc.nextInt();

                for (BankAccount b : accounts) {
                    if (b.getAccountNo() == acc) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        b.withdraw(amt);
                    }
                }

            } else if (choice == 4) {
                for (BankAccount b : accounts) {
                    b.display();
                    System.out.println("------------------");
                }

            } else if (choice == 5) {
                System.out.println("Thank you for using Bank System.");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
