package Threading;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    public static void main(String[] args) {

        ReentrantLock rlock = new ReentrantLock(true);

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                rlock.lock();
                try {
                    if (rlock.isHeldByCurrentThread()) {
                        System.out.println("thread one lock obtained");
                        Thread.sleep(500);
                    }

                } catch (InterruptedException e) {
                } finally {
                    if (rlock.isHeldByCurrentThread()) {
                        rlock.unlock();
                        System.out.println("unlock by one");
                    }
                }
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                rlock.lock();
                try {
                    if (rlock.isHeldByCurrentThread()) {
                        System.out.println("thread two lock obtained");
                    }
                } finally {
                    if (rlock.isHeldByCurrentThread()) {
                        rlock.unlock();
                        System.out.println("unlock by two");
                    }
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        System.out.println("main thread");
    }
}
