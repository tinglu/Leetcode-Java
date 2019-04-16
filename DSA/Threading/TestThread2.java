package Threading;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void someAction(String threadname) {
        System.out.println("=== " + threadname + " calling " + this.name);
    }

}

class MyThread extends Thread {
    String name;
    final Employee employee;

    public MyThread(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    synchronized void decreaseAge() {
        this.employee.age--;
        System.out.println("\n" + this.name + " calling... " + employee.name + " age: " + this.employee.age);
    }

    void increaseAge() {
        System.out.println("\n" + this.name + " calling... before" + employee.name + " age: " + this.employee.age);
        synchronized (this.employee) {
            this.employee.age++;
            System.out.println("\n" + this.name + " calling... after" + employee.name + " age: " + this.employee.age);
        }
    }


    public void run() {
        System.out.println("\n" + this.name + " starting");
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
        System.out.println(this.name + " terminating");
    }
}

public class TestThread2 {
    public static void main(String[] args) {
        // Same object
        Employee lisa = new Employee("Lisa", 32);
        MyThread thread1 = new MyThread("MyThread1", lisa);
        MyThread thread2 = new MyThread("MyThread2", lisa);

        thread1.start();
        thread2.start();

//        thread1.decreaseAge();
//        thread1.decreaseAge();
//        thread2.decreaseAge();
//        thread2.decreaseAge();


        // Different object
//        Employee Ann = new Employee("Ann", 10);
//        Employee Bob = new Employee("Bob", 100);
//        MyThread thread3 = new MyThread("MyThread-Ann ", Ann);
//        MyThread thread4 = new MyThread("MyThread-Bob ", Bob);
//
//        thread3.start();
//        thread4.start();
//
//        thread4.decreaseAge();
//        thread3.decreaseAge();
//        thread4.decreaseAge();
//        thread3.decreaseAge();


        // synchronised object
//        Employee jenny = new Employee("Jenny", 55);
//        MyThread thread1 = new MyThread("MyThread1", jenny);
//        MyThread thread2 = new MyThread("MyThread2", jenny);
//
//        thread1.start();
//        thread2.start();
//
//        thread1.increaseAge();
//        thread2.increaseAge();
//        thread1.increaseAge();
//        thread2.increaseAge();
    }
}