package Feature.thread;

import java.util.concurrent.*;

public class Mythread implements  Runnable{

    // Runable vs Callable
    @Override
    public void run() {
        synchronized (this){
            for(int i = 0;i < 2; i++){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

    }

    public static void main(String[] args) {



        Callable<String> callable = new  Callable<String> (){
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("Thread_ID" + Thread.currentThread());
                return "Hello World";
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(callable);

        try{
            System.out.println(future.get());
        }
        catch (ExecutionException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        executorService.shutdown();

        Mythread thread = new Mythread();
        Thread A = new Thread(thread, "A");
        Thread B = new Thread(thread, "B");
        A.start();
        B.start();

    }









}
