package executorservice;

/**
 * Class Executors Factory Class
 * Created by wajahat
 */
public class Executors {

    public static ExecutorService newThreadPoolExecutor(int numThreads) {
        return new ExecutorService(numThreads);
    }
}
