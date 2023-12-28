/**
*
* @author: Akshat Singh
*
* Printing odd and even numbers using the Producer-Consumer pattern with Java's BlockingQueue.
* The even and odd numbers are produced by two separate threads and consumed by a third thread,
* ensuring synchronization between the producers and the consumer
*
*/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class NumberProducer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int limit;
    private final int remainder;

    public NumberProducer(BlockingQueue<Integer> queue, int limit, int remainder) {
        this.queue = queue;
        this.limit = limit;
        this.remainder = remainder;
    }

    @Override
    public void run() {
        try {
            for (int i = remainder; i <= limit; i += 2) {
                queue.put(i);
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class NumberConsumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public NumberConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = queue.take();
                System.out.println(Thread.currentThread().getName() + ": " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class EvenOddPrintUsingProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        int limit = 10;

        Thread producerEven = new Thread(new NumberProducer(queue, limit, 0));
        Thread producerOdd = new Thread(new NumberProducer(queue, limit, 1));
        Thread consumer = new Thread(new NumberConsumer(queue));

        producerEven.setName("Even Producer Thread");
        producerOdd.setName("Odd Producer Thread");
        consumer.setName("Consumer Thread");

        producerEven.start();
        producerOdd.start();
        consumer.start();
    }
}

