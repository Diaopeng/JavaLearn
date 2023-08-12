package effective.Java.chapter3;

import java.util.Arrays;
import java.util.*;

public class EqualsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> test = Arrays.asList("abc", "cde", "mks");
        System.out.println(test.contains("abc"));


    }
}
// exmaple of not following the symmetric : https://stackoverflow.com/questions/28621188/why-this-java-equals-method-violates-the-symmetric-implementation-rule
// a instance of String can equals to WrongEquals, but not the same in the other way
class WrongEquals {

    private final String variable;

    public WrongEquals(String variable) {
        this.variable = variable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof String) {
            return variable.equals((String) o);
        }
        if (o instanceof WrongEquals) {
            return variable.equals(((WrongEquals) o).variable);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (variable == null ? 0 : variable.hashCode());
    }
}
