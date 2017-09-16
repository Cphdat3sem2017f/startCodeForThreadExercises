package day2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

  
  public static void main(String[] args) throws InterruptedException {
    //This represent the Queue in the exercise-figure. Observe the size of the Queue
    ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(5);
    
    ExecutorService es = Executors.newCachedThreadPool();
    //Create and start four producers (P1-P4 in the exercise-figure)
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
     
    //Create and start single consumer (C1 in the exercise-figure)
    RandomNumberConsumer consumer = new RandomNumberConsumer(numbers);
    es.execute(consumer);    
    
    es.shutdown();
    es.awaitTermination(10, TimeUnit.SECONDS);
    
    System.out.println("Total of all random numbers: " + consumer.getSumTotal());
    System.out.println("Number of random numbers below 50: " + consumer.getBelow50().size());
    System.out.println("Number of random numbers >= 50: " + consumer.getAboveOr50().size());
  }
}
