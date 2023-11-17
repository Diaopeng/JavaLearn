package DesignPattern.java;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
* Write a program to burn out your multicore CPU. Every core should remain as busy as possible, at all times.*/
public class Salesforce {
    public void makeCPUBusy(){
        ExecutorService executorService =
                new ThreadPoolExecutor(16, 16, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());


        ThreadMaketheCPUBusy[] threadMaketheCPUBusies = new ThreadMaketheCPUBusy[16];
        for(int i = 0;i < threadMaketheCPUBusies.length; i++){
            threadMaketheCPUBusies[i] = new ThreadMaketheCPUBusy();
            executorService.submit(threadMaketheCPUBusies[i]);

        }
        executorService.shutdown();
        //


    }
}


class ThreadMaketheCPUBusy implements Runnable{
    @Override
    public void run() {
        System.out.println("already call the method which will make the CPU busy");
    }
}