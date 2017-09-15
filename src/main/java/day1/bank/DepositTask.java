package day1.bank;

public class DepositTask implements Runnable
{
  BankAccountUnsynchronized acc;
  public DepositTask(BankAccountUnsynchronized a)
  {
    acc = a;
  }
  @Override
  public void run()
  {
    try
    {
      for (int i = 1 ; i< 30 ;i++ ) 
      {
        acc.deposit(100);
        Thread.sleep(1);
      }
    }
    catch (InterruptedException e) {}
  }
}