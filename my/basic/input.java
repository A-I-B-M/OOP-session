import java.util.Scanner;   // for input
import java.util.Vector;    // for Vector collection

public class input {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input n
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        String dummy = sc.nextLine(); // consume the newline
        boolean f = sc.hasNextLine();

        // Vector to store numbers
        Vector<Integer> vec = new Vector<>();

        // Take 5 numbers
        int [] arr = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            int x = sc.nextInt();
            vec.add(x);
            arr[i] = sc.nextInt();
        }

        // Output
        System.out.println("Value of n: " + n);
        System.out.println("Vector elements:");

        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i) + " ");
        }

        sc.close();
    }
}
