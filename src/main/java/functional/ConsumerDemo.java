package functional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        Consumer<String> print = System.out::print;
        Consumer<String> println = System.out::println;

        Consumer<Integer> squarToPrint = x -> System.out.println(x * x);

        Scanner scanner = new Scanner(System.in);

        print.accept("ALA");
        println.accept("BEATA");
        squarToPrint.accept(5);

        List<String> names = Arrays.asList("ala", "asd", "rteta");
        names.forEach(name -> System.out.println("  ||||||||  " + name + " ||||||| "));

        Consumer<String> howManyLetter = s -> s.length();

        names.forEach(name -> System.out.println(howManyLetter));

        names.forEach(name -> System.out.println("  ||||||||  " + name.length() + " ||||||| "));

    }

}
