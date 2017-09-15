package day1.bank;

public class WithdrawTask implements Runnable
{
  BankAccountUnsynchronized acc;
  public WithdrawTask(BankAccountUnsynchronized a)
  {
    acc = a;
  }
  public void run()
  {
    try
    {
      for (int i = 1 ;i< 30 ;i++ ) 
      {
        acc.withdraw(100);
        Thread.sleep(1);
      }
    }
   catch (InterruptedException e) {}
  }
}
