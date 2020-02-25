package concurent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Counter{
    private int counter = 0;

    public int get(){
        return counter;
    }

    synchronized public void inc(int value){
        counter += value;
    }

}

class Player implements Runnable {
    private Counter teamCounter;

    public Player(Counter teamCounter) {
        this.teamCounter = teamCounter;
    }

    @Override
    public void run() {
        int iteration = 100;
        while (iteration-- > 0){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            teamCounter.inc(1);

        }
    }
}


public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter teamCounter = new Counter();

        //typ atomowy ktorego metody sa nieprzerywane przez inne watki
        AtomicInteger counter = new AtomicInteger();

        List<Thread> players = new ArrayList<>();
        int number = 10;
        while (number-- > 0){
            players.add(new Thread(new Player(teamCounter)));
        }
        for(Thread player: players){
            player.start();
        }
        Thread.sleep(1000);
        System.out.println("Team scoore: " + teamCounter.get());
    }
}
