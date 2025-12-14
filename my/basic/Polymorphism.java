
// Method Overriding example in Java

class Animal {
    void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    void sound() { System.out.println("Bark"); }
}



// Polymorphism example in Java
class Calculator {
    int add(int a, int b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("Polymorphism example");
        Calculator calc = new Calculator();
        System.out.println("Sum of 2 numbers: " + calc.add(5, 10));
        System.out.println("Sum of 3 numbers: " + calc.add(5, 10, 15));
        

        // Method Overriding demonstration
        Animal myDog = new Dog();
        myDog.sound(); // Outputs: Bark
        Animal myAnimal = new Animal();
        myAnimal.sound(); // Outputs: Animal sound
    }    
}