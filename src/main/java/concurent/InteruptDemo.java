package concurent;

import java.util.Scanner;

public class InteruptDemo {
    public static void main(String[] args) {
        Thread task = new Thread(() -> {
            int counter = 0;
           while (!Thread.currentThread().isInterrupted()){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
               counter++;
           }
           if (counter > 10) {
               System.out.println("sukces: " + counter);
           } else {
               System.out.println("porazka: " + counter);
           }
        });

        task.start();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("quit"));
        //przerwanie tasku
        task.interrupt();

    }
}
