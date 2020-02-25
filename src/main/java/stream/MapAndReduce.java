package stream;

import collection.User;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndReduce {
    public static void main(String[] args) {
        int suma = IntStream.generate(() ->
                new Random().nextInt(100))
                .limit(1000)
                .reduce(0,(accu,i) -> accu + i);
        System.out.println(suma);
        final double x = 5.0;
        double result = DoubleStream.of(4.0, 2.5, 1.0)
            .reduce(0.0,(accu, factor) -> accu + factor * x);
        System.out.println(result);

        //z listy wierszy opisujacych uzytkownika chcemy otrzymac
        List<String> usersAsStr = Arrays.asList("ola 2690-10-10","adam 1770-02-02","szymon 2000-01-01","szymonom");

        List<Optional<User>> OptionalUsers = usersAsStr.stream()
                .map(line -> {
                    String[] tokens = line.split(" ");
                    if (tokens.length == 2) {
                        String name = tokens[0];
                        LocalDate date = LocalDate.parse(tokens[1]);
                        User user = new User(name, date);
                        return Optional.of(user);
                    }
                    return Optional.empty();
                })

                .map(o -> (Optional<User>) o)
                .collect(Collectors.toList());
        System.out.println(OptionalUsers);

        System.out.println("************************************");

        List<User> users = usersAsStr.stream()
                .map(line -> {
                    String[] tokens = line.split(" ");
                    if (tokens.length == 2) {
                        String name = tokens[0];
                        LocalDate date = LocalDate.parse(tokens[1]);
                        User user = new User(name, date);
                        return user;
                    }
                    return null;
                })



                .filter(Objects::nonNull) //usuwanie nulli
                .collect(Collectors.toList());


        users.stream().filter(u -> u.getName().startsWith("s")).forEach(System.out::println);

        System.out.println("************************************");

        //filtracja listy z Optional<User>
        OptionalUsers.stream().filter(o -> o.filter(u -> u.getName().startsWith("s")).isPresent()).forEach(System.out::println);

        Optional<User> findAny =users.stream().findAny();
        System.out.println(findAny);

        System.out.println("123214124".chars().allMatch(Character::isDigit));

        List<User> team = Arrays.asList(new User("Kierownik", LocalDate.parse("1969-05-03")), new User("nieKierownik", LocalDate.parse("1888-08-29")));
        Stream.of(users,team).flatMap(u -> u.stream().filter(user -> user.getName().length() < 5)).forEach(System.out::print);



    }
}
