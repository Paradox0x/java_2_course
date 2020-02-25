package functional;

import collection.User;

import java.util.function.*;

public class SupplierDemo {
    public static void main(String[] args) {

        Supplier<String> alfabet = () -> "abcdefghijklmnprstuwxyz";
        Supplier<User> emptyUser = () -> new User();

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //Bi na dwa argumenty
        IntFunction<Integer> kwadrat = x -> x * x;
        Function<Integer, Integer> squar = x -> x * x;

        System.out.println(kwadrat.apply(6));

    }
}
