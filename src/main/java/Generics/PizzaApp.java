package Generics;

public class PizzaApp {
    public static void main(String[] args) {
        PizzaBox<Pizza> box = new PizzaBox<>(new PepperoniPizza(10));
        PizzaBox<HawaiiPizza> box1 = new PizzaBox<>(new HawaiiPizza(12));


    }
}
