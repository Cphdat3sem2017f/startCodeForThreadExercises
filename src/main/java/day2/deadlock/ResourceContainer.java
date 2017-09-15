package day2.deadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ResourceContainer {

  private final Lock lock1 = new ReentrantLock();
  private final Lock lock2 = new ReentrantLock();
  List<String> words = new ArrayList();
  List<Integer> numbers = new ArrayList();
  
  
  public List<String> getResourceWords() {
      lock1.lock();
      return words;
  }
  
  public void releaseResourceWords() {
     lock1.unlock();
  }
  
  public List<Integer> getResourceNumbers() {
      lock2.lock();
      return numbers;
  }
  
  public void releaseResourceNumbers() {
    lock2.unlock();
  }

}