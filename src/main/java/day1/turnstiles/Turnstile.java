package day1.turnstiles;

public class Turnstile implements Runnable{
  private final TurnstileCounter counter;
  //This represents the "local" counts done by a specific turnstille instance
  //Not really used in the exercise
  private int count;

  final int COUNT_MAX = 1000;

  Turnstile(TurnstileCounter c) {
    counter = c;
  }

  public int getCount() {
    return count;
  }

  @Override
  public void run() {
    for (int i = 0; i < COUNT_MAX; i++) {
      counter.incr();
      count++;
    }
  }
  
}
