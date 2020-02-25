package collection;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetUserApp {
    public static void main(String[] args) {

        /** Wlasne klasy musze miec zdefiniowane
         * Metode equals i hashCode jesli uzywamy kolecji typu set, hash
         * interfejs Comaprable jesli uzywamy kolecji TreeSet, TreeMap
         * dla zbioru TreeSet o unikalnosci decyduje comapreTo!!!
         */
        Set<User> users = new TreeSet<>();
        users.add(new User("ada", LocalDate.of(2000, 10, 10)));
        users.add(new User("ada", LocalDate.of(2000, 10, 10)));
        users.add(new User("ada", LocalDate.of(2000, 10, 10)));
        System.out.println(users);
        System.out.println("*******************");
        users.add(new User("adam", LocalDate.of(2002, 12, 13)));
        System.out.println(users);

    }
}
