package Concurency.java.Chapter5;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchroCollection {
    Vector<Integer> vector = new Vector<>();
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer,  Integer> syncmap = Collections.synchronizedMap(map);

    List<Integer> syncList = Collections.synchronizedList(new ArrayList<Integer>());
    List<Integer> concunList =  new CopyOnWriteArrayList<>();

    public void test(){
        for(int i: syncList){
            // do something
        }
    }
    // it will possible throw ConcurrentModificationException
}
