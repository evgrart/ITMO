class Animal {
    void bark() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    void bark() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.bark();
    }
}
