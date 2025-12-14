package collection;

import java.util.*;

// =========================
// SECTION 1: PAIR / CUSTOM OBJECT
// =========================
class Pair implements Comparable<Pair> {
    int first, second;

    Pair(int f, int s) { first = f; second = s; }

    public String toString() { return "(" + first + ", " + second + ")"; }

    // Default Comparable: first asc, second asc
    @Override
    public int compareTo(Pair o) {
        if(this.first != o.first)
            return this.first - o.first;
        return this.second - o.second;
    }
}

// =========================
// SECTION 2: CUSTOM OBJECT (STUDENT)
// =========================
class Student implements Comparable<Student> {
    String name;
    int marks;

    Student(String n, int m) { name = n; marks = m; }

    public String toString() { return name + ":" + marks; }

    // Default Comparable: sort by marks ascending
    @Override
    public int compareTo(Student o) {
        return this.marks - o.marks;
    }
}

// =========================
// SECTION 3: MAIN CLASS
// =========================
public class CompareToSort {
    public static void main(String[] args) {

        // 1️⃣ NORMAL ARRAY

        int[] arr = {5,2,9,1,3};

        Arrays.sort(arr); // ascending
        System.out.println("Array Asc: " + Arrays.toString(arr));

        Integer[] arrDesc = {5,2,9,1,3};
        Arrays.sort(arrDesc, Collections.reverseOrder()); // descending
        System.out.println("Array Desc: " + Arrays.toString(arrDesc));

        // Custom comparator: even first
        Integer[] arrCustom = {5,2,9,1,3};
        Arrays.sort(arrCustom, (a,b) -> {
            if(a%2==b%2) return a-b;
            else if(a%2==0) return -1;
            else return 1;
        });
        System.out.println("Array Custom (even first): " + Arrays.toString(arrCustom));

        // =========================
        // 2️⃣ ARRAYLIST
        // =========================
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,1,7,3,6));

        Collections.sort(list); // ascending
        System.out.println("ArrayList Asc: " + list);

        list.sort(Collections.reverseOrder()); // descending
        System.out.println("ArrayList Desc: " + list);

        // Custom: even first
        list.sort((a,b) -> a%2==b%2 ? a-b : (a%2==0?-1:1));
        System.out.println("ArrayList Custom (even first): " + list);

        // =========================
        // 3️⃣ STRING ARRAY
        // =========================
        String[] strArr = {"Bappy","Sami","Anik","Rafi"};

        Arrays.sort(strArr); // alphabetical
        System.out.println("String Asc: " + Arrays.toString(strArr));

        Arrays.sort(strArr, Collections.reverseOrder()); // reverse
        System.out.println("String Desc: " + Arrays.toString(strArr));

        Arrays.sort(strArr, (s1,s2) -> s1.length() - s2.length()); // length
        System.out.println("String Custom (length asc): " + Arrays.toString(strArr));


        // 4️⃣ PAIR / CUSTOM OBJECT

        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(2,5));
        pairs.add(new Pair(1,7));
        pairs.add(new Pair(2,3));
        pairs.add(new Pair(1,1));

        // Comparable: first asc, second asc
        Collections.sort(pairs);
        System.out.println("Pairs Comparable (first asc, second asc): " + pairs);

     
        // Comparator: first asc, second desc
      
        pairs.sort(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if(p1.first != p2.first)
                    return p1.first - p2.first;
                return p2.second - p1.second;
            }
        });
        System.out.println("Pairs Comparator (first asc, second desc): " + pairs);

      
        // Lambda: second asc
        pairs.sort((p1,p2) -> p1.second - p2.second);
        System.out.println("Pairs Lambda (second asc): " + pairs);


        // 5️⃣ STUDENT OBJECTS

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Bappy",85));
        students.add(new Student("Sami",90));
        students.add(new Student("Anik",75));
        students.add(new Student("Bappy",95)); // same name, different marks

        // Comparable: marks asc
        Collections.sort(students);
        System.out.println("Students Comparable (marks asc): " + students);

        // Comparator: marks desc
        students.sort(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.marks - s1.marks;
            }
        });
        System.out.println("Students Comparator (marks desc): " + students);

        // Comparator: name asc
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("Students Comparator (name asc): " + students);

        // Multi-field: marks desc, name asc
        students.sort((s1,s2) -> {
            if(s2.marks != s1.marks) return s2.marks - s1.marks;
            return s1.name.compareTo(s2.name);
        });
        System.out.println("Students Multi-field (marks desc, name asc): " + students);
    }
}
