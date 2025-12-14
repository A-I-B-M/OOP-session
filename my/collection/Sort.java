package collection;

import java.util.*; // All collections, comparator, arrays

// =========================
// SECTION 1: PAIR CLASS
// =========================
class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// =========================
// MAIN CLASS
// =========================
public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // SECTION 2: SORT NORMAL ARRAY

        int[] arr = {5, 2, 9, 1, 3};
        // Ascending
        Arrays.sort(arr);
        System.out.println("Normal Array Ascending: " + Arrays.toString(arr));

        // Descending
        Integer[] arrDesc = {5, 2, 9, 1, 3}; // use Integer wrapper
        Arrays.sort(arrDesc, Collections.reverseOrder());
        System.out.println("Normal Array Descending: " + Arrays.toString(arrDesc));


        
        // // SECTION 3: SORT ARRAYLIST

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 1, 7, 3, 6));

        // Ascending
        Collections.sort(list);
        System.out.println("ArrayList Ascending: " + list);

        // Descending
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("ArrayList Descending: " + list);

     
        // SECTION 4: SORT STRING ARRAY
       
        String[] strArr = {"Bappy", "Sami", "Anik", "Rafi"};

        Arrays.sort(strArr); // alphabetical
        System.out.println("String Array Ascending: " + Arrays.toString(strArr));

        Arrays.sort(strArr, Collections.reverseOrder());
        System.out.println("String Array Descending: " + Arrays.toString(strArr));


        // SECTION 5: SORT PAIR ARRAYLIST
   
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(2, 5));
        pairs.add(new Pair(1, 7));
        pairs.add(new Pair(2, 3));
        pairs.add(new Pair(1, 1));

        // Sort by first ascending, then second ascending
        Collections.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.first != p2.first)
                    return p1.first - p2.first; // ascending first
                else
                    return p1.second - p2.second; // ascending second
            }
        });
        System.out.println("Pair List Sorted (first asc, second asc): " + pairs);

        // Sort by first ascending, second descending
        Collections.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.first != p2.first)
                    return p1.first - p2.first;
                else
                    return p2.second - p1.second;
            }
        });
        System.out.println("Pair List Sorted (first asc, second desc): " + pairs);

        // Lambda version: sort by second ascending
        pairs.sort((p1, p2) -> p1.second - p2.second);
        System.out.println("Pair List Sorted by second ascending (lambda): " + pairs);

        // SECTION 6: SORT CUSTOM OBJECTS
        class Student {
            String name;
            int marks;
            Student(String n, int m) { name = n; marks = m; }
            public String toString() { return name + ":" + marks; }
        }

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Bappy", 85));
        students.add(new Student("Sami", 90));
        students.add(new Student("Anik", 75));

        // Sort by marks descending
        students.sort((s1, s2) -> s2.marks - s1.marks);
        System.out.println("Students sorted by marks desc: " + students);

        // Sort by name ascending
        students.sort((s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println("Students sorted by name asc: " + students);

        sc.close();
    }
}

