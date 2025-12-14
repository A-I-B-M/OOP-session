class Student {
    String name;
    int age;

    // Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println(name + " is " + age + " years old.");
    }
}   

public class basic {
    public static void main(String[] args) {
        Student s1 = new Student("Bappy", 22);
        s1.display();
    }
}
