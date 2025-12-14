
class Person {
    String name;
    int age;
}

class Student extends Person {
    int rollNo;

    void display() {
        System.out.println(name + " " + age + " " + rollNo);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Bappy";
        s.age = 20;
        s.rollNo = 22;
        s.display();
    }
}
