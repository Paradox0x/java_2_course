package stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStringApp {
    public static void main(String[] args) {
        RandomString gen = new RandomString();
        System.out.println(gen.random(6));
        //strumien liczbcalkowitych
        IntStream.range(0,100)
            .mapToObj(i -> gen.random(i) + new Random().nextInt(17))
            .forEach(System.out::println);
        //metoda tworzenia trumieni z interfejsu Stream
        randomStringStream(gen)
                .forEach(System.out::println);
        String[] arr = {"ABC", "KON", "KOT", "ZOM"};
        Arrays.stream(arr).filter(s -> s.contains("B")).forEach(System.out::println);

        //FizzBus
        System.out.println("********************************************");

        IntStream.range(0, 100)
            .mapToObj(i -> {
                String result = i + " ";
                if (i % 3 == 0){
                    result += "Fizz";
                }
                if (i % 5 == 0){
                    result += "Buzz";
                }
                return result;
            })
            .forEach(System.out::println);
        IntPredicate fizz = x -> x % 3 == 0;
        IntPredicate buzz = x -> x % 5 == 0;

        //fizzbuzz 2
        System.out.println("********************************************");

        IntStream.range(0, 100)

                .mapToObj(i -> {
                    String result = i + " ";

                    if (fizz.test(i)){
                        result += "Fizz ";
                    }
                    if (buzz.test(i)){
                        result += "Buzz ";
                    }
                    return result;
                });

        //FiizBuzz 3
        System.out.println("********************************************");

        IntStream.range(0, 100)

                .mapToObj(i -> {
                    String result = i + " ";
                    result += fizz.test(i) ? "Fizz" : "";
                    result += fizz.test(i) ? "Buzz" : "";
                    return result;
                })
        .forEach(System.out::println);

        //Grupowanie lancuchow wedlug ich dlugosci
        Map<Integer, List<String>> wordMap = randomStringStream(gen).collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(wordMap);
        System.out.println(wordMap.keySet());

        //Grupowanie lancuchow wedlug ich dlugosci i obliczenie liczby slow o tej dlugosci
        Map<Integer, Long> wordCount = randomStringStream(gen).collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));

        List<String> wordsDF = randomStringStream(gen).filter(s -> s.startsWith("d") || s.startsWith("f")).collect(Collectors.toList());
        System.out.println(wordsDF);

    }


    private static Stream<String> randomStringStream(RandomString gen) {
        return Stream.generate(() -> gen.random(3) + new Random().nextInt(17))
                .limit(1000);
    }
}
