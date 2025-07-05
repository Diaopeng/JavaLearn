package Feature.lambda;

import java.io.Console;
import java.util.*;

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



    class Solution {
        public int maxSum(int[] nums) {
            List<Integer>[] list = new List[10];
            for(int num: nums){
                int max = 0;
                int cur = num;
                while(cur != 0){
                    int digit = cur % 10;
                    max = Math.max(max, digit);
                    cur /= 10;
                }
                if(list[max] == null){
                    list[max] = new ArrayList<>();
                }
                list[max].add(num);
            }
            int res = -1;
            for(int i = 1;i <= 9; i++){
                Collections.sort(list[i], (a, b) ->(b - a));
                if(list[i].size() >= 2){
                    res  = Math.max(res, list[i].get(0) + list[i].get(1));
                }
            }
            return res;
        }
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
