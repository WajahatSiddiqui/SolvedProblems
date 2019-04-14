package lock;

/**
 * Class Lock using wait and notify
 * Created by wajahat
 */
public class MyLock {
    private Object object = new Object();
    private static volatile boolean isLocked = false;

    MyLock() {}

    public void lock() {
        //if (isLocked) return;
        synchronized (object) {
            try {
                object.wait();
                isLocked = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void unLock() {
        //if (!isLocked) return;
        synchronized (object) {
            object.notify();
            isLocked = false;
        }
    }
}
