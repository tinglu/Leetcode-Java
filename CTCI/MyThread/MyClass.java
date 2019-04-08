package MyThread;

public class MyClass extends Thread {

    private String name;
    private MyObject myObj;

    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    public void run() {
//        myObj.foo(name);
        if (name.equals("1")) MyObject.fun1(name);
        else if (name.equals("2")) MyObject.fun2(name);
    }

    public static void main(String[] args) {
        /* Difference references - both threads can call MyObject.foo() */
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        MyClass thread1 = new MyClass(obj1, "1");
        MyClass thread2 = new MyClass(obj2, "2");
        thread1.start();
        thread2.start();


        /* Same reference to obj. Only one will be allowed to call foo, * and the other will be forced to wait. */
        MyObject obj = new MyObject();
        MyClass thread3 = new MyClass(obj, "3");
        MyClass thread4 = new MyClass(obj, "4");
        thread3.start();
        thread4.start();
    }
}

class MyObject {
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + ".foo(): starting");
            Thread.sleep(300);
            System.out.println("Thread " + name + ".foo(): ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }


    public static synchronized void fun1(String name) {
        try {
            System.out.println("Thread " + name + ".fun1(): starting");
            Thread.sleep(300);
            System.out.println("Thread " + name + ".fun1(): ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }

    public static synchronized void fun2(String name) {
        try {
            System.out.println("Thread " + name + ".fun2(): starting");
            Thread.sleep(300);
            System.out.println("Thread " + name + ".fun2(): ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }
}