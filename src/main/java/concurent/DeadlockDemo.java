package concurent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


public class DeadlockDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Counter counterA = new Counter();
        Counter counterB = new Counter();
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        //bezpieczna wielowatkowa lista
        final List<String> list = Collections.synchronizedList(new ArrayList<>());
       // list = Collections.synchronizedList(list);
        List<String> listOnlyRead = new ArrayList<>();
        //lista niemodyfikowalna
        listOnlyRead = Collections.unmodifiableList(listOnlyRead);

        Runnable task1 = () -> {
            int count = 10;
            while (count-- > 0){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockA.lock();
                lockB.lock();

                counterA.inc(2);
                counterB.inc(1);

                lockA.unlock();
                lockB.unlock();
                System.out.println("TASK 1: " + count);

                list.add("JAK POWIESZ SZYMON TO POWIELA");
                System.out.println(list);

              //  listOnlyRead.add("nie dodasz bo readonly");



            }
        };

        Runnable task2 = () -> {
            int count = 10;
            while (count-- > 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockA.lock();
                lockB.lock();

                counterA.inc(2);
                counterB.inc(1);

                lockA.unlock();
                lockB.unlock();
                System.out.println("TASK 2: " + count);
            }
        };
        service.execute(task1);
        service.execute(task2);
        service.shutdown();
    }
}
