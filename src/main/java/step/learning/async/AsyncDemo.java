package step.learning.async;

import java.util.concurrent.CountDownLatch;

public class AsyncDemo {
    private final CountDownLatch latch1 = new CountDownLatch(1);
    private final CountDownLatch latch2 = new CountDownLatch(2);

    public void run() {
        System.out.println("AsyncDemo");

        Thread thread1 = new Thread(() -> {
            System.out.println("1 start");
            try {
                latch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 finish");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("2 start");
            latch1.countDown();
            System.out.println("2 finish");
            latch2.countDown();
        });

        Thread thread3 = new Thread(() -> {
            try {
                latch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3 start");
            System.out.println("3 finish");
            latch2.countDown();
        });

        Thread finalThread = new Thread(() -> {
            try {
                latch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("final");
        });

        thread1.start();
        thread2.start();
        thread3.start();
        finalThread.start();
    }
}
