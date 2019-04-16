package Threading;

class MyRunnable implements Runnable {
    String name;
    final Employee employee;

    public MyRunnable(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    public void run() {
        System.out.println("\n" + this.name + " starting");

        synchronized (employee) {
            employee.someAction(this.name);
        }

//        int n = 5;
//        try {
//            while (n > 0) {
//                System.out.println(this.name + " running " + n);
//                Thread.sleep(100);
//                n--;
//            }
//        } catch (InterruptedException exp) {
//            exp.printStackTrace();
//        }
        System.out.println(this.name + " terminating");
    }
}

public class TestRunnable {

    public static void main(String[] args) {
        Employee e1 = new Employee("E1", 88);
        MyRunnable run1 = new MyRunnable("Run1", e1);
        MyRunnable run2 = new MyRunnable("Run2", e1);
        MyRunnable run3 = new MyRunnable("Run3", e1);

//        run1.run();
//        run2.run();

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        Thread t3 = new Thread(run3);

        t3.start();
        try {
            t3.join();
        } catch (InterruptedException exp) {
            System.out.println("interrupt");
        }

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException exp) {
            System.out.println("interrupt");
        }

        t1.start();
    }
}