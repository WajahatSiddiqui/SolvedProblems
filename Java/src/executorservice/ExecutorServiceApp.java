package executorservice;

/**
 * Class Class to run custom executor service
 * Created by wajahat
 */
public class ExecutorServiceApp {

    private ExecutorService executorService = Executors.newThreadPoolExecutor(2);

    private static class MyCallable implements Callable<Integer> {
        private int taskId;
        public MyCallable(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public Integer call() {
            System.out.println("TaskId: " + taskId + " Started to work !!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return taskId;
        }
    }

    public void process(int numTasks) {
        for (int i = 0; i < numTasks; i++) {
            executorService.submit(new MyCallable(i+1));
        }
        executorService.shutdown();
    }

    public static void main(String args[]) {
        ExecutorServiceApp app = new ExecutorServiceApp();
        app.process(10);
    }

    public void testExecutorService() {
        process(10);
    }
}
