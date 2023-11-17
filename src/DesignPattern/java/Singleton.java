package DesignPattern.java;

public class Singleton {

    private static Singleton instance = null;
    private Singleton (){

    }

    public static Singleton GetInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return  instance;
    }

    //改进版
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
