package Feature.Collectiontest;
import java.util.*;
public class Listtest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("0");
        String[] arr = list.toArray(new String[0]);
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.remove(10);
        System.out.println(set.size());
    }


}
