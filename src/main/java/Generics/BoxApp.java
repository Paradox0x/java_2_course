package Generics;

import java.util.Optional;

public class BoxApp {
    public static void main(String[] args) {
        Box<String> StringBox = new Box<>();
        System.out.println(StringBox.isEmpty());
        StringBox.setContent("Hello");
        System.out.println(StringBox.isEmpty());
        System.out.println(StringBox.getContent());
        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(4);
        int a = 4;
        integerBox.setContent(a);
        Optional <String> stringOptional = Optional.empty();
        System.out.println(stringOptional.isPresent());
        String str = "H i p i h i o i p";
        stringOptional = Optional.of(str);
        System.out.println(stringOptional.isPresent());

        stringOptional = Optional.ofNullable(null);
        System.out.println(stringOptional.isPresent());

        System.out.println(LastWord("ala ma kota a kot ma ale ale ala woli kopara").orElse("Nie ma ostatniej sowy!!"));
    }
    static Optional<String> LastWord(String str){
        if (str == null || str.isEmpty()){
            return Optional.empty();
        }
        String[] words = str.split(" ");
        return Optional.of(words[words.length - 1]);
    }
}
