package collection;

import java.util.*;

// ==================================================
// STUDENT CLASS
// ==================================================
class Student {

    int id;
    String name;
    int m1, m2, m3;

    // ✅ Constructor (matches object creation)
    Student(int id, String name, int m1, int m2, int m3) {
        this.id = id;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    // Calculate total marks
    int total() {
        return m1 + m2 + m3;
    }

    // Calculate average marks
    double average() {
        return total() / 3.0;
    }

    // Display student object
    @Override
    public String toString() {
        return id + " " + name + " (" + m1 + "," + m2 + "," + m3 + ")";
    }
}

// ==================================================
// MAIN CLASS
// ==================================================
public class objSort {

    public static void main(String[] args) {

        // Create list of students
        ArrayList<Student> students = new ArrayList<>();

        // Add students
        students.add(new Student(1, "Bappy", 85, 90, 88));
        students.add(new Student(2, "Sami", 70, 75, 72));
        students.add(new Student(3, "Anik", 90, 95, 92));
        students.add(new Student(4, "Rafi", 60, 65, 68));
        students.add(new Student(5, "Bappy", 85, 90, 80));

        // ==================================================
        // 1️⃣ SORT BY TOTAL MARKS (ASCENDING)
        // ==================================================
        students.sort((s1, s2) -> s1.total() - s2.total());
        System.out.println("1. Total Marks Ascending:");
        System.out.println(students);
        System.out.println();

        // ==================================================
        // 2️⃣ SORT BY TOTAL MARKS (DESCENDING)
        // ==================================================
        students.sort((s1, s2) -> s2.total() - s1.total());
        System.out.println("2. Total Marks Descending:");
        System.out.println(students);
        System.out.println();

        // ==================================================
        // 3️⃣ SORT BY AVERAGE MARKS (ASCENDING)
        // ==================================================
        students.sort(Comparator.comparingDouble(Student::average));
        System.out.println("3. Average Marks Ascending:");
        System.out.println(students);
        System.out.println();

        // ==================================================
        // 4️⃣ SORT BY AVERAGE MARKS (DESCENDING)
        // ==================================================
        students.sort((s1, s2) ->
                Double.compare(s2.average(), s1.average()));
        System.out.println("4. Average Marks Descending:");
        System.out.println(students);
        System.out.println();

        // ==================================================
        // 5️⃣ SORT BY HIGHEST SUBJECT MARK (ASCENDING)
        // ==================================================
        students.sort((s1, s2) -> {
            int max1 = Math.max(s1.m1, Math.max(s1.m2, s1.m3));
            int max2 = Math.max(s2.m1, Math.max(s2.m2, s2.m3));
            return max1 - max2;
        });
        System.out.println("5. Highest Subject Mark Ascending:");
        System.out.println(students);
        System.out.println();

        // ==================================================
        // 6️⃣ SORT BY LOWEST SUBJECT MARK (DESCENDING)
        // ==================================================
        students.sort((s1, s2) -> {
            int min1 = Math.min(s1.m1, Math.min(s1.m2, s1.m3));
            int min2 = Math.min(s2.m1, Math.min(s2.m2, s2.m3));
            return min2 - min1;
        });
        System.out.println("6. Lowest Subject Mark Descending:");
        System.out.println(students);
        System.out.println();

        // ==================================================
        // 7️⃣ SORT BY PASS/FAIL THEN TOTAL MARKS
        // ==================================================
        final int PASS_MARK = 80;

        students.sort((s1, s2) -> {
            boolean pass1 = s1.average() >= PASS_MARK;
            boolean pass2 = s2.average() >= PASS_MARK;

            // Pass students first
            if (pass1 != pass2)
                return pass1 ? -1 : 1;

            // Same result → higher total first
            return s2.total() - s1.total();
        });
        System.out.println("7. Pass/Fail then Total:");
        System.out.println(students);
        System.out.println();

        // ==================================================
        // 8️⃣ SORT BY TOTAL MARKS THEN NAME
        // ==================================================
        students.sort((s1, s2) -> {
            if (s1.total() != s2.total())
                return s2.total() - s1.total(); // total desc
            return s1.name.compareTo(s2.name); // name asc
        });
        System.out.println("8. Total Desc then Name:");
        System.out.println(students);
    }
}
