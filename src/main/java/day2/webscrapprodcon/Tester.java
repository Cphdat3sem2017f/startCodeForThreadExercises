
package day2.webscrapprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jsoup.nodes.Document;

public class Tester {
  
  public static void main(String[] args) throws InterruptedException {

    //The list of URL's that must be processed. This is Q1 in the exercise figure
    ArrayBlockingQueue<String> urls = new ArrayBlockingQueue(40);
    
    urls.add("http://www.fck.dk");
    urls.add("http://www.google.com");
    urls.add("http://politiken.dk");
    urls.add("https://cphbusiness.mrooms.net/");
    //TODO: Add some more URL's of your own choice

    //Holds the Documents produced by the producers. This is Q2 in the exercise figure
    ArrayBlockingQueue<Document> producedDocuments = new ArrayBlockingQueue(10);
   
    ExecutorService es = Executors.newCachedThreadPool();
    //Create and start the four Producers (P1-P4)
    es.execute(new DocumentProducer(urls, producedDocuments)); 
    es.execute(new DocumentProducer(urls, producedDocuments)); 
    es.execute(new DocumentProducer(urls, producedDocuments)); 
    es.execute(new DocumentProducer(urls, producedDocuments)); 
    
    //Create and start the single Consumer Thead (P1)
    es.execute(new DocumentConsumer(producedDocuments)); 
    
    es.shutdown();
    es.awaitTermination(5,TimeUnit.SECONDS);
    System.out.println("Closing Down");
    
  }
}
