package item26;

import java.util.List;
import java.util.ArrayList;

public class TypeTest {
    private static void addtoObjList(final List<Object> list, final Object o) {
        list.add(o);
    }
    
    private static <T> void addToGenericList(final List<T> list, final T o) {
        list.add(o);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "kimtaeng";    
        // List<Object> 이므로 incompatible types 오류
        addToGenericList(list, s);

        // Okay!
        addToGenericList(list, s);
    }
}