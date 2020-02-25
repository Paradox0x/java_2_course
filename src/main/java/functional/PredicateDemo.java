package functional;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> isNull = s -> s == null;
        Predicate<String> isNull2 = Objects::isNull;
        Predicate<String> isNotNull = isNull.negate();

        System.out.println(isNull.test("abc"));
        System.out.println(isNotNull.test("abc"));
        System.out.println(isNull2.test("abc"));

        Predicate<String> hasOnlyDigits = s -> {for(int i=0; i < s.length(); i++){
        if(!Character.isDigit((s.charAt(i)))){
            return false;
            }
        }
        return true;

        };
        /*
        Predicate<String> hasValidLenght = s -> {
            if(s.length() == 11){
                return true;
            }
            return false;
        };

         */
        Scanner scanner = new Scanner(System.in);



        Predicate<String> hasValidLenght = s -> s.length() == 11;
        Predicate<String> isValidPesel = isNotNull.and(hasOnlyDigits.and(hasOnlyDigits));

        if (isValidPesel.test(scanner.next())){

            System.out.println("pesel poprawny");
        } else
            {
            System.out.println("Pesel niepoprawny");
        }

    }
}
