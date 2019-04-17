package Threading;

import java.util.concurrent.ThreadLocalRandom;

class Data {
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted - send");
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted - receive");
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}

class Sender implements Runnable {
    private Data data;

    // standard constructors
    public Sender(Data data) {
        this.data = data;
    }

    public void run() {
        String[] packets = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        for (String packet : packets) {
            System.out.println(">>> sending " + packet);
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted - sender");
            }
        }
    }
}

class Receiver implements Runnable {
    private Data load;
    String receiver;

    // standard constructors
    public Receiver(Data load, String receiver) {
        this.load = load;
        this.receiver = receiver;
    }

    public void run() {
        System.out.println("====== " + this.receiver + " running ");
        for (String receivedMessage = load.receive();
             !"End".equals(receivedMessage);
             receivedMessage = load.receive()) {

            System.out.println("--- " + this.receiver + " receiving " + receivedMessage);
            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted - receiver");
            }
        }
    }
}


public class InterThreads {

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data, "one"));
        Thread receiver2 = new Thread(new Receiver(data, "two"));

        sender.start();
        receiver.start();
//        receiver2.start();
    }

}
