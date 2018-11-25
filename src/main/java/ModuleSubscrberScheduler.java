import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ModuleSubscrberScheduler implements Flow.Subscriber<TruthState> {

    private Flow.Subscription subscription;
    static ExecutorService executor = Executors.newFixedThreadPool(10);
    static SubmissionPublisher<TruthState> resultPublisher = new SubmissionPublisher<TruthState>();
    static ModuleSubscrberScheduler mdx;

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

        executor.execute(runnableTask);


    }


    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(TruthState item) {

        subscription.request(1);

        Runnable runnableTask = () -> {
            try {
                ModuleWork moduleName = AppData.getNextModule(item);
                moduleName.moduleWork(mdx);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

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
