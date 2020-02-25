package collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
    //    Set<String> set = new HashSet<>();
        set.add("Kacper");
        set.add("Anna");
        set.add("Julia");
        System.out.println(set);
        set.add("Kacper");
        System.out.println(set);
        //czy EWA nalezy do zbioru set
        set.contains("Julia");
        set.remove("Anna");
        System.out.println(set);



    }
}