import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class Q {
    //int n;
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    //BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(); //Double Ended Queue: Deque where you can insert and remove elements from both ends of the queue.
    boolean valueSet = false;

    synchronized int get() {
        //System.out.println("Inside get()");
        while(!valueSet && queue.size()<=7) {
            try {
                wait(); // 2. Causes execution to suspend until Producer notifies that some data is ready. When this happens execution inside get() resumes.
            } catch (InterruptedException e) {}
        }
        //System.out.println("Consumer Thread Got: " + n);
        System.out.println("Consumer Thread Processing: " + queue);
        //System.out.println("Size of the Queue: " + queue.size());
        System.out.println("Consumer Thread Got: " + queue.element());
        valueSet = false;
        notify(); // 4. After obtaining data, notify() tells Producer that it is okay to put more data in the Queue.
        //return n;
        return queue.remove();
    }

    synchronized void put(BlockingQueue<Integer> q) {
        //System.out.println("Inside put()");
        while(valueSet) {
            try {
                Thread.sleep(1000);
                wait(); // 3. Suspends execution until Consumer has removed the item from the Queue.
            } catch (InterruptedException e) {}
        }
        //this.n = n;
        this.queue = q;
        valueSet = true;
        System.out.println("Producer Thread Put: " + q);
        notify(); // 1. When execution resumes, the next item of the data is put into the Queue and notify() is called. This tells Consumer to consume the data.
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
    //BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);

    Producer(Q q) {
        this.q = q;
        t = new Thread(this);
    }

    private int randomNumberGenerator() {
        int n = (int) (Math.random()*99);
        return n;
    }

    public void run() {
        
        while(true) {
            for(int i=0; i<10; i++) {
                queue.offer(randomNumberGenerator());
            }
            q.put(queue);
        }
    }
}


class Consumer implements Runnable {
    Q q;
    Thread t;

    Consumer(Q q) {
        this.q = q;
        t = new Thread(this);
    }

    public void run() {
        while(true) {
            q.get();
        }
    }
}

class ProducerConsumer {
    public static void main(String[] args) {
        Q q = new Q();

        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        p.t.start();
        c.t.start();
    }
}
