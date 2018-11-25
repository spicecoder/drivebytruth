public class AppLogedIn  implements ModuleWork{
  //accepts user id pwd
  //declares i.e. publishes the truth "Input Received"

 static  TruthState ts = new TruthState(AppData.truths.APP_LOGEDIN);

  private static String input;


  public void moduleWork(ModuleSubscrberScheduler mx) {





    int n = 42 ;
    System.out.println("Fibonacci on logged in:" + fib(n));

    mx.setResultPublisher(ts);





  }
  static int fib(int n)
  {
    if (n <= 1)
      return n;
    return fib(n-1) + fib(n-2);
  }


}
