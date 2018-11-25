import java.util.Scanner;


public class InputData implements ModuleWork {
    //accepts user id pwd
    //declares i.e. publishes the truth "Input Received"

    static TruthState ts = new TruthState(AppData.truths.INPUT_RECEIVED);

    private static String input;


    public void moduleWork(ModuleSubscrberScheduler mx) {
// get valid uid pwd ,compare ,false  show pwd invalid
        System.out.println("......Input UserID.....");
        Scanner keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        AppData.userid = input;
        System.out.println(".....Input Pwd.....");

        keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        AppData.password = input;

        mx.setResultPublisher(ts);
    }

}