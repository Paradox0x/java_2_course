package collection;import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;public class ListDemo {


    public static void main(String[] args) {

        List<String> names = new ArrayList<>(1000);   //przy LinkedList przy wielu elementach działa szybciej niż ArrayList

        names.add("Ada");
        names.add("Szymon");
        names.add("Kacper");
        System.out.println(names);        System.out.println("");
        System.out.println("Dodanie Adama za Ade");
        names.add(1, "Adam");
        System.out.println(names);        System.out.println("");
        System.out.println("Usunięcie Szymona z listy");
        names.remove(3);
        System.out.println(names);        System.out.println("");
        System.out.println("Pod indeksem 1 mamy: ");
        System.out.println(names.get(1));        System.out.println("");
        System.out.println(names.indexOf("Adam"));        System.out.println("");
        System.out.println("Podmieniam Szymona za Kacpra");
        names.set(2, "Kacper");
        System.out.println(names);        System.out.println("");

        /**
         * Usuwanie podczas przegladania kolekcji TYLKO za pomocą iteratora!!!
         *
         * Korzystanie z iteratora
         */

        Iterator<String> iterator = names.iterator();
        //sprawdz czy jest nastepny elemnt
        while (iterator.hasNext()) {
            //przejdz do nastpenego elemntu i zwroc biezacy elemnt
            String name = iterator.next();
            if (name.contains("A")) {
                //usun biezacy element
                iterator.remove();
            }
        }
        System.out.println("Po usunieciu imion powyże, w ktorych znajduje sie litera A zostaje nam: ");
        System.out.println(names);        //names = new LinkedList<>();
    }
}


