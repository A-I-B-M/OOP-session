
class Student {
    private String name; // private -> safe
    private int age;

    // Getter and Setter
    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Bappy");
        s.setAge(20);

        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
