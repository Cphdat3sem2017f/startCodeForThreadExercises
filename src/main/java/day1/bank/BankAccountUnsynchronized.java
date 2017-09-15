package day1.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// NOT THREADSAFE
public class BankAccountUnsynchronized {

  private double balance;
  private final Lock lock = new ReentrantLock();

  public BankAccountUnsynchronized() {
    balance = 0;
  }

  public void deposit(double amount) {
//    double newBalance = balance + amount;
//    balance = newBalance;  
    balance += amount;
   }

  public void withdraw(double amount) {
//    double newBalance = balance - amount;
//    balance = newBalance;
     balance -= amount;
   }

  public double getBalance() {
    return balance;
  }
}