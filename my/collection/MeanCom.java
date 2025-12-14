package collection;
import java.util.*;   // Import all collection utilities

// ==================================================
// SECTION 1: ARRAY SORT USING STATIC PROPERTY
// ==================================================
class StaticArraySort {

    // 🔹 Static variable: shared for whole class
    static double mean;

    // 🔹 Static method to calculate mean of array
    static void calculateMean(int[] arr) {
        int sum = 0;

        // Calculate sum
        for (int x : arr)
            sum += x;

        // Store mean in static variable
        mean = (double) sum / arr.length;
    }
}

// ==================================================
// SECTION 2: PAIR CLASS (CUSTOM OBJECT)
// ==================================================
class Pair {
    int a, b;

    // 🔹 Static flag / rule (can control sorting logic globally)
    static boolean sortByMean = true;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // 🔹 Static method to compute mean of a Pair
    static double mean(Pair p) {
        return (p.a + p.b) / 2.0;
    }

    // For clean printing
    public String toString() {
        return "(" + a + "," + b + ")";
    }
}

// ==================================================
// SECTION 3: STUDENT CLASS (OBJECT SORTING)
// ==================================================
class Student {
    String name;
    int m1, m2;

    // 🔹 Static property: common rule for all students
    static int PASS_MARK = 80;

    Student(String n, int m1, int m2) {
        name = n;
        this.m1 = m1;
        this.m2 = m2;
    }

    // 🔹 Static method: calculate average marks
    static double average(Student s) {
        return (s.m1 + s.m2) / 2.0;
    }

    public String toString() {
        return name + "(" + m1 + "," + m2 + ")";
    }
}

// ==================================================
// MAIN CLASS
// ==================================================


public class MeanCom {
    public static void main(String[] args) {

        // ==================================================
        // 1️⃣ ARRAY SORT USING STATIC MEAN
        // ==================================================
        int[] arr = {5, 2, 9, 1, 3};

        // Calculate mean using static method
        StaticArraySort.calculateMean(arr);

        // Convert int[] → Integer[] (needed for Comparator)
        Integer[] boxed = Arrays.stream(arr)
                                .boxed()
                                .toArray(Integer[]::new);

        // 🔹 Sort based on distance from STATIC mean
        Arrays.sort(boxed, (x, y) ->
            Double.compare(
                Math.abs(x - StaticArraySort.mean),
                Math.abs(y - StaticArraySort.mean)
            )
        );

        System.out.println("Array sorted by distance from static mean:");
        System.out.println(Arrays.toString(boxed));
        System.out.println("Static Mean = " + StaticArraySort.mean);
        System.out.println();

        // ==================================================
        // 2️⃣ PAIR SORT USING STATIC METHOD
        // ==================================================
        ArrayList<Pair> pairs = new ArrayList<>();

        pairs.add(new Pair(2, 8));
        pairs.add(new Pair(1, 1));
        pairs.add(new Pair(4, 6));
        pairs.add(new Pair(5, 5));

        // 🔹 Sort by mean (ascending)
        pairs.sort((p1, p2) ->
            Double.compare(
                Pair.mean(p1),   // static method call
                Pair.mean(p2)
            )
        );

        System.out.println("Pairs sorted by static mean (asc):");
        System.out.println(pairs);

        // 🔹 Sort by mean (descending)
        pairs.sort((p1, p2) ->
            Double.compare(
                Pair.mean(p2),
                Pair.mean(p1)
            )
        );

        System.out.println("Pairs sorted by static mean (desc):");
        System.out.println(pairs);
        System.out.println();

        // ==================================================
        // 3️⃣ STUDENT SORT USING STATIC RULE
        // ==================================================
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Bappy", 85, 90));
        students.add(new Student("Sami", 70, 75));
        students.add(new Student("Anik", 90, 95));
        students.add(new Student("Rafi", 60, 65));

        // 🔹 Custom sorting logic:
        // 1. PASS students first
        // 2. Then sort by average marks (descending)
        students.sort((s1, s2) -> {

            // Check pass/fail using STATIC PASS_MARK
            boolean pass1 = Student.average(s1) >= Student.PASS_MARK;
            boolean pass2 = Student.average(s2) >= Student.PASS_MARK;

            // If one passed and other failed
            if (pass1 != pass2)
                return pass1 ? -1 : 1;  // pass comes first

            // If both same category → compare by average marks
            return Double.compare(
                Student.average(s2),
                Student.average(s1)
            );
        });

        System.out.println("Students sorted using static PASS_MARK rule:");
        System.out.println(students);
    }    
}
