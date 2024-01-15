package Concurency.java;

import java.util.concurrent.*;
import java.util.*;

public class Chapter6 {
    // executor vs excutorservice
    private static final Executor executor = Executors.newFixedThreadPool(3);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
       // testExecutor();
        testExecutorService();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Asynchronous callable");
                return "Callable Result";
            }
        });
        System.out.println(future.get());
        executorService.shutdownNow();

        CompletionService<String> completionService = new ExecutorCompletionService<>(Executors.newFixedThreadPool(4));
        completionService.submit(new testCallable(12000, "mmm"));
        completionService.submit(new testCallable(5000, "xxx"));
        completionService.submit(new testCallable(2000, "yyy"));
        completionService.submit(new testCallable(8000, "kkk"));
        for(int i = 0;i < 4; i++){
            System.out.println(completionService.take().get());
        }



        
    }


    public static void testExecutorService(){
        for(int i = 0;i < 3; i++){
            Runnable testRun = new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i < 10; i++){
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    }
                }
            };
            executorService.submit(testRun);
        }
    }

    public static void testExecutor() {


        for(int i = 0;i < 3; i++){
            Runnable  testExecutor = new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i < 10; i++){
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    }
                }
            };
            executor.execute(testExecutor);
        }

    }


    // ExecutorCompletionService





}

class testCallable implements Callable<String> {
    private long milli;
    private String name;
    public testCallable(long milli, String name){
        this.milli = milli;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("name: " + name);
        Thread.sleep(milli);
        return name + "after " + milli + " call back";
    }
}
