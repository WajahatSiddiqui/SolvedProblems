package lock;

/**
 * Class Custom Lock Class
 * Created by wajahat
 */
public class MyLockReentrant {

    private Object lock = new Object();
    private static volatile int lockHoldCount = 0;
    private static volatile long threadId;

    MyLockReentrant() {}

    private long getThreadId() {
        return Thread.currentThread().getId();
    }

    public void lock() {
        synchronized (lock) {
            if (lockHoldCount > 0 && threadId == getThreadId()) {
                lockHoldCount++;
                return;
            }
            try {
                lock.wait();
                lockHoldCount++;
                threadId = getThreadId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void unLock() {
        synchronized (lock) {
            if (lockHoldCount == 0) throw new IllegalStateException("invalid state");
            lockHoldCount--;
            if (lockHoldCount == 0) {
                lock.notify();
            }
        }
    }

    public boolean tryLock() {
        if (lockHoldCount == 0) {
            lock();
            return true;
        } else {
            return false;
        }
    }
}
