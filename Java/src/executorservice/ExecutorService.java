package executorservice;


/**
 * Class ExecutorService implementation
 * Created by wajahat
 */
public class ExecutorService {

    private int numThreads;
    private Worker worker;


    public ExecutorService(int numThreads) {
        this.numThreads = numThreads;
        this.worker = new Worker(numThreads, 10);
    }

    public Future<?> submit(Callable<?> callable) {
        worker.addTask(callable);
        return null;
    }

    public void shutdown() {
        worker.shudown();
    }
}
