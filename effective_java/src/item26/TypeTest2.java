package item26;

import java.util.ArrayList;
import java.util.List;

public class TypeTest2 {
    public static void main(String[] args) {
        List raw = new ArrayList<String>(); // Okay!
        List<?> wildcard = new ArrayList<String>(); // Okay!
            
        raw.add("Hello"); // Okay! 하지만 raw타입은~
        System.out.println(raw);
        wildcard.size(); // Okay! 제네릭 타입에 의존성 없음
        wildcard.clear(); // Okay! 제네릭 타입에 의존성 없음
    }
}