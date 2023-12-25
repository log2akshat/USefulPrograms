/**
*
* @Author akshat singh
*
* Java program that prints odd and even numbers using two threads.
* The two threads take turns printing odd and even numbers up to a specified limit
*
**/

class EvenOddPrintUsingMultithreading {
    private static final int LIMIT = 10;
    private static int number = 1;
    private static final Object lock = new Object();

    static class EvenThread extends Thread {
        public void run() {
            while (number <= LIMIT) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                        lock.notify(); // Notify the waiting thread
                    } else {
                        try {
                            lock.wait(); // Wait for the odd thread to print
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class OddThread extends Thread {
        public void run() {
            while (number <= LIMIT) {
                synchronized (lock) {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                        lock.notify(); // Notify the waiting thread
                    } else {
                        try {
                            lock.wait(); // Wait for the even thread to print
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread evenThread = new EvenThread();
        Thread oddThread = new OddThread();

        evenThread.setName("Even Thread");
        oddThread.setName("Odd Thread");

        evenThread.start();
        oddThread.start();
    }
}

