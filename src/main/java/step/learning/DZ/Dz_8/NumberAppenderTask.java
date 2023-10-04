package step.learning.DZ.Dz_8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberAppenderTask implements Runnable {
    private static final StringBuffer result = new StringBuffer();
    private static final Lock lock = new ReentrantLock();
    private final int number;

    public NumberAppenderTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            result.append(number);
            System.out.println("Appended " + number + " by " + Thread.currentThread().getName());
            if (result.length() == 10) {
                System.out.println("Final Result: " + result.toString());
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new NumberAppenderTask(i));
        }
        executorService.shutdown();
    }
}