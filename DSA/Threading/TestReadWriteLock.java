package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;

class ShoppingCart {
    private List<String> products = new ArrayList<String>();

    public String getProduct(int i) {
        return products.get(i);
    }

    public void addProduct(String name) {
        products.add(name);
    }
}

public class TestReadWriteLock {

    public static void main(String[] args) {

        //instantiate share object
        ShoppingCart scart = new ShoppingCart();
        scart.addProduct("iphone");

        //instantiate ReentrantReadWriteLock
        ReentrantReadWriteLock rrwlock = new ReentrantReadWriteLock();

        Thread threadRead = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock rl = rrwlock.readLock();
                try {
                    //obtain read lock, so that no write occur during reading
                    rl.lock();
                    //read from shared object
                    System.out.println(scart.getProduct(0));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                } finally {
                    //release read lock
                    rl.unlock();
                }
            }
        });
        Thread threadWrite = new Thread(new Runnable() {
            @Override
            public void run() {
                //get write lock
                //lock() block current thread till it acquires write lock
                //if you don't want to block current thread, use tryLock()
                rrwlock.writeLock().lock();
                try {
                    //if tryLock() is used, check if write lock is obtained
                    if (rrwlock.isWriteLockedByCurrentThread()) {
                        //write to shared object
                        scart.addProduct("pixel");
                        System.out.println("thread write lock obtained");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                } finally {
                    if (rrwlock.isWriteLockedByCurrentThread()) {
                        //release or unlock write lock
                        rrwlock.writeLock().unlock();
                    }
                }
            }
        });

        threadRead.start();
        threadWrite.start();

        System.out.println("main thread");
    }
}
