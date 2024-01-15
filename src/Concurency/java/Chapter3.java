package Concurency.java;

public class Chapter3 {
    /*
    * public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
    public void run() {
        while (!ready)
            Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
        }
    }
    * */
    // it is possible the thread will never stop, or it will print the number as 0(reordering)

}
