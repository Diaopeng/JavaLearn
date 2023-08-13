package Feature.lambda;

import java.io.Console;

public class Lambdatest {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abcd";
        System.out.println(a.compareTo(b));

        // 常规接口实现
        SeaAnimal seaAnimal = new SeaAnimal();
        seaAnimal.eat();

        //匿名内部类
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("Anonymous class implementing eat()");
            }
        };
        animal.eat();

        // Lambda expression
        Animal animal1 = () -> System.out.println("Lambda Expression implementing eat()");
        animal1.eat();
    }

}

 interface Animal{
    public void eat();
}

class SeaAnimal implements  Animal{
    @Override
    public void eat() {
        System.out.println("SeaAnimal class implementing eat()");
    }
}
