package annotation;

public class Test1 {
    public static void main(String[] args) {
        Parent p = new Child("Alex");
        p.showInfo();
    }
}

class Parent {
    String name;

    public Parent(String name) {
        this.name = name;
    }


    void showInfo() {
        System.out.println("Its Parent class, name = " + name);
    }
}

class Child extends Parent {

    public Child(String name) {
        super(name);
    }

    @Override
    void showInfo() {
        System.out.println("Its Child class, name = " + name);
    }
}