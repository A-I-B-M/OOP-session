package collection;

import java.util.*;

// =========================
// 1️⃣ PAIR / CUSTOM OBJECT
// =========================
class Pair {
    int first, second;

    Pair(int f, int s) { first = f; second = s; }

    public double mean() {
        return (first + second) / 2.0;
    }

    public String toString() { return "(" + first + ", " + second + ")"; }
}

// =========================
// 2️⃣ MAIN CLASS
// =========================
public class sortByMean {
    public static void main(String[] args) {

        // =========================
        // A) SORT ARRAY BASED ON DISTANCE FROM MEAN
        // =========================
        int[] arr = {5, 2, 9, 1, 3};
        double mean = Arrays.stream(arr).average().orElse(0.0);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Mean: " + mean);

        // Sort by absolute distance from mean
        Integer[] arrBoxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrBoxed, (a,b) -> Double.compare(Math.abs(a - mean), Math.abs(b - mean)));
        System.out.println("Array sorted by distance from mean: " + Arrays.toString(arrBoxed));

        // =========================
        // B) SORT PAIRS BASED ON MEAN OF FIRST AND SECOND
        // =========================
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(2,5));
        pairs.add(new Pair(1,7));
        pairs.add(new Pair(2,3));
        pairs.add(new Pair(1,1));

        System.out.println("\nPairs Original: " + pairs);

        // Sort by mean ascending
        pairs.sort((p1,p2) -> Double.compare(p1.mean(), p2.mean()));
        System.out.println("Pairs sorted by mean (asc): " + pairs);

        // Sort by mean descending
        pairs.sort((p1,p2) -> Double.compare(p2.mean(), p1.mean()));
        System.out.println("Pairs sorted by mean (desc): " + pairs);

        // =========================
        // C) ARRAYLIST OF OBJECTS (STUDENT) BASED ON STATISTIC
        // =========================
        class Student {
            String name;
            int marks1, marks2;

            Student(String n, int m1, int m2) {
                name = n; marks1 = m1; marks2 = m2;
            }

            public double mean() { return (marks1 + marks2) / 2.0; }

            public String toString() { return name + ":(" + marks1 + "," + marks2 + ")"; }
        }

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Bappy",85,90));
        students.add(new Student("Sami",90,70));
        students.add(new Student("Anik",75,80));

        System.out.println("\nStudents Original: " + students);

        // Sort students by mean marks ascending
        students.sort(Comparator.comparingDouble(Student::mean));
        System.out.println("Students sorted by mean marks (asc): " + students);

        // Sort students by mean marks descending
        students.sort((s1,s2) -> Double.compare(s2.mean(), s1.mean()));
        System.out.println("Students sorted by mean marks (desc): " + students);
    }
}
