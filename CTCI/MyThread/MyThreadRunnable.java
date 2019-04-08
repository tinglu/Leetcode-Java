package MyThread;

public class MyThreadRunnable implements Runnable {
    public int count = 0;

    public void run() {
        System.out.println("MyThreadRunnable starting");
        try {
            while (count < 2) {
                System.out.println("before -- " + count);
                Thread.sleep(200);
                count++;
                System.out.println("after -- " + count);
            }
        } catch (InterruptedException exe) {
            System.out.println("MyThreadRunnable interrupted");
        }
        System.out.println("MyThreadRunnable terminating");
    }

    public static void main(String[] args) {
        MyThreadRunnable instance = new MyThreadRunnable();
        Thread thread = new Thread(instance);
        thread.start();

        while (instance.count != 2) {
            try {
                System.out.println("try count -- " + instance.count);
                Thread.sleep(100);
                System.out.println("try count -- " + instance.count);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
