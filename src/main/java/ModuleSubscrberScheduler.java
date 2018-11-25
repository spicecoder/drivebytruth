import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ModuleSubscrberScheduler implements Flow.Subscriber<TruthState> {
    //it schedules an execution with a subscription alerady made
    //on reciving subscribed truth state it schedules another"


    private Flow.Subscription subscription;
    static ExecutorService executor = Executors.newFixedThreadPool(10);
    static SubmissionPublisher<TruthState> resultPublisher = new SubmissionPublisher<TruthState>();
    static ModuleSubscrberScheduler mdx;
    static TruthState currentTruth;
    static public String userid_input;
    static public String password_input;


    public static void main(String[] args) {
        mdx = new ModuleSubscrberScheduler();
        mdx.initiate();
    }

    public void setResultPublisher(TruthState ts) {

        resultPublisher.submit(ts);
    }

    public void initiate() {

        mdx.resultPublisher.subscribe(this);
        Runnable runnableTask = () -> {
            try {
                ModuleWork starter = AppData.getNextModule(new TruthState(AppData.truths.START));

                starter.moduleWork(mdx);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        //  ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(runnableTask);



    }


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed by in xecutor " + subscription.toString());
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(TruthState item) {
        //StarterModuleWithPublisher.resultPublisher.unsubscribe (this);

        System.out.println("response receivedin onNext" + item.name);
        subscription.request(1);

        Runnable runnableTask = () -> {
            try {
                ModuleWork moduleName = AppData.getNextModule(item);
                moduleName.moduleWork(mdx);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        //  ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(runnableTask);




    }


    @Override
    public void onError(Throwable throwable) {
        System.out.println("onComplete in onError");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete in executor");
    }
}
