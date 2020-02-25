package functional;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> howManyA = s -> {
          int counter = 0;

          for(int i = 0; i < s.length(); i++){
              if(s.charAt(i) == 'A'){
                  counter++;
              }

          }
            return counter;
        };
        System.out.println(howManyA.apply("AAAAAASFASVASVASQA"));

        Function<Integer, Integer> squar = x -> x * x;

        System.out.println(squar.apply(5));

        System.out.println(howManyA.andThen(squar).apply("AAAAAASFASVASVASQA"));
        Function<String, Integer> squarOfA = howManyA.andThen(squar);

        System.out.println("*******************************************" );

        System.out.println(squarOfA.apply("ABC"));

        Function<String,Integer> squareOfACompose = squar.compose(howManyA);

        System.out.println(squareOfACompose.apply("ABCDEA"));



    }
}
