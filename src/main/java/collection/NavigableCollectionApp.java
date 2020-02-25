package collection;

import java.util.*;

public class NavigableCollectionApp {
    public static void main(String[] args) {
        NavigableMap<Integer, String> words = new TreeMap<>();

        words.put(4, "kot");
        words.put(2, "java");
        words.put(3, "kon");
        words.put(6, "laptop");

        System.out.println(words.lowerKey(3));
        System.out.println(words.tailMap(4));

        //kolekcje puste
        // emptyList nic nie zawiera ale zajmuje duzo wiecej pamieci niz list
        List<String> emptyList = new ArrayList<>();
        List<String> list = Collections.EMPTY_LIST;

        emptyList = Collections.singletonList("jeden element");
        emptyList.add("janusz");
        System.out.println(emptyList);
        System.out.println(list.size());





    }
}
