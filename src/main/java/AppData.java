public class AppData {
 static String  userid;
 static String password;
 static String validUserid = "flow";
 static String validPassword ="password";

  //
  enum truths {
    START,INPUT_RECEIVED,USERID_VALID,PASSWORD_VALID,APP_LOGEDIN

  }

  //truth states

  private static AppFlowTruth[] appflows = new AppFlowTruth[]{
    new AppFlowTruth(new TruthState(truths.START), new InputData()),
    new AppFlowTruth(new TruthState(truths.INPUT_RECEIVED), new VerifyUid()),

    new AppFlowTruth(new TruthState(truths.USERID_VALID), new ValidatePwd()),

    new AppFlowTruth(new TruthState(truths.PASSWORD_VALID), new AppLogedIn()),
    new AppFlowTruth(new TruthState(truths.APP_LOGEDIN), new  ExitApp())
  };


public static ModuleWork  getNextModule(TruthState ts) {

  for(int i=0;i<appflows.length; i++ ) {
     if ( (ts.name ).equals( appflows[i].truthstate.name )) {

       return appflows[i].moduleNext;


     }
  }
  return new ExitApp();

}
}
