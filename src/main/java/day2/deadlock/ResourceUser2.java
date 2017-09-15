package day2.deadlock;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResourceUser2 extends Thread {

  ResourceContainer resource;

  ResourceUser2(ResourceContainer r) {
    resource = r;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      try {
        System.out.println(Thread.currentThread().getName()+ " Get resource NUMBERS");
        List<Integer> numbers = resource.getResourceNumbers();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);
        Thread.sleep(1);//Simulate that using the resource takes som time 
        System.out.println(Thread.currentThread().getName()+ " Get resource WORDS");
        List<String> words = resource.getResourceWords();
        words.add("Jens");
        words.add("Henrik");
        words.add("Lone");
        System.out.println(Thread.currentThread().getName() + " Done with resources");
      } catch (InterruptedException ex) {
        Logger.getLogger(ResourceUser2.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        resource.releaseResourceWords();
        resource.releaseResourceNumbers();
      }
      
    }
  }
}
