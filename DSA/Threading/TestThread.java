package Threading;

public class TestThread extends Thread {
    String name;

    public TestThread(String name) {
        this.name = name;
    }

    public void run() {
        int n = 5;
        try {
            while (n > 0) {
                System.out.println(this.name + " running " + n);
                Thread.sleep(100);
                n--;
            }
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }

    }


    public static void main(String[] args) {
        TestThread thread1 = new TestThread("MyThread1");
        TestThread thread2 = new TestThread("MyThread2");
        TestThread thread3 = new TestThread("MyThread3");

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException exp) {
            System.err.println("Exception occurred");
        }

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException exp) {
            System.err.println("Exception occurred");
        }

        thread3.start();

    }
}
