package concurent;

//Metoda definiowania wyjatku jako klasy potomenej po klasie Thread

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.concurrent.Task;

class TaskThread extends Thread{

    @Override
    public void run() {
        int count = 10;
        while(count-- > 0){
            try {
                Thread.sleep(1000);
                System.out.println("Hello from thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("KONIEC");
    }
}

public class ThreadApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread.sleep(1000);
        System.out.println("END");

        //uruchomienie watku z klasy TaskThread
        TaskThread taskThread = new TaskThread();

        System.out.println("PO UTWORZENIU:  " + taskThread.getState());
        System.out.println("START WATKU");
        taskThread.start();
        Thread.sleep(500);
        System.out.println("PO STARCIE:  " + taskThread.getState());
        taskThread.join();
        System.out.println("KONIEC PRACY WATKU:  " + taskThread.getState());

        //Tworzenie wyjatku z wykorzystaniem lambdy
        new Thread(() -> {
            System.out.println("Hello from L A M B D A...");
        }).start();
    }
}

//Metoda definiowania przy pomocy interfejsu Runnable
class TaskRunnable implements Runnable{

    public void run() {

        int count = 10;
        while(count-- > 0){
            try {
                Thread.sleep(1000);
                System.out.println("Hello from runnable");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("KONIEC");
    }
}

class TaskRunnable2 implements Runnable{

    public void run() {

        int count = 10;
        while(count-- > 0){
            try {
                Thread.sleep(1000);
                System.out.println("Hello from runnable");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("KONIEC");
    }
}

