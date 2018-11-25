

public class ValidatePwd  implements ModuleWork {
    //accepts user id pwd
    //declares i.e. publishes the truth "Input Received"

    static TruthState ts = new TruthState(AppData.truths.PASSWORD_VALID);

    private static String input;


    public void moduleWork(ModuleSubscrberScheduler mx) {


        if (AppData.password.equals(AppData.validPassword)) {
            mx.setResultPublisher(ts);

        }


    }
}
