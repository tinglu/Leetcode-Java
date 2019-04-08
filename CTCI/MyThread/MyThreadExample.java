package MyThread;

class MyThread extends Thread {
    int count = 0;

    public void run() {
        System.out.println("Thread starting");
        try {
            while (count < 2) {
                Thread.sleep(200);
                System.out.println("In Thread, count is "+count);
                count++;
            }
        }catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread terminating");
    }
}

public class MyThreadExample extends Thread {
    public static void main(String[] args) {
        MyThread instance = new MyThread();
        instance.start();

        while (instance.count != 2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
