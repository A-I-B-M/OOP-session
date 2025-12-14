// Importing all utility classes
import java.util.*;


public class HashSetDemo {

    public static void main(String args[])
    {
        // Creating an object of Set class
        // Declaring object of Integer type
        Set<Integer> a = new HashSet<Integer>();

        // Adding all elements to List
        a.addAll(Arrays.asList(
                1, 2, 3, 6, 7, 8));

        a.add(100);
        a.add(200);

        // Again declaring object of Set class
        // with reference to HashSet
        Set<Integer> b = new HashSet<Integer>();

        b.addAll(Arrays.asList(
                1, 2, 3, 5, 10, 20));

        // looping over hashset
        for (Integer aElement : a) {
            System.out.println(aElement);
        }

        // removing from the hashset
        a.remove(200);

        // Iterating through the hashset
        Iterator<Integer> aIt = a.iterator();
        while (aIt.hasNext()){
            System.out.println(aIt.next());
        }


        // To find union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<Integer>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
    }
}
