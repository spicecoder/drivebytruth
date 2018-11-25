public class ExitApp implements ModuleWork {
    //accepts user id pwd
    //declares i.e. publishes the truth "Input Received"

    static TruthState ts = new TruthState("application loged in");

    private static String input;


    public void moduleWork(ModuleSubscrberScheduler mx) {


        {
           System.exit(42);

        }


    }
}
