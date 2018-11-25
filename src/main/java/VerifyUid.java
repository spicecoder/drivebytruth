

public class VerifyUid implements ModuleWork {
    //accepts user id pwd
    //declares i.e. publishes the truth "Input Received"

    static TruthState ts = new TruthState(AppData.truths.USERID_VALID);

    private static String input;


    public void moduleWork(ModuleSubscrberScheduler mx) {


        if (AppData.userid.equals(AppData.validUserid)) {
            mx.setResultPublisher(ts);

        }


    }
}
