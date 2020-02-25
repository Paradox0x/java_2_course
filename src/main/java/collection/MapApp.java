package collection;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapApp {
    public static void main(String[] args) {
        Map<String, User> users = new TreeMap<>();
        User user = new User("ada", LocalDate.of(2000,10, 20));
        users.put("ada", user);
        users.put("karol", new User("karol", LocalDate.of(2010,7,2)));
        users.put("arnold", new User("arnold", LocalDate.of(2010,7,2)));

        System.out.println(users);
        users.put("karol", user);
        System.out.println("=====================================");
        System.out.println(users);
        System.out.println("=====================================");
        System.out.println(users.containsKey("karol"));
        System.out.println("=====================================");
        users.remove("karol");
        System.out.println(users);
        users.put("bogdan", new User("bogdan", LocalDate.of(2002, 10, 20)));
        System.out.println("=====================================");

        for(Map.Entry<String, User> entry: users.entrySet()){
            System.out.println("Klucz =" + entry.getKey() + ", wartosc=" + entry.getValue());
        }

    }
}
