package item26;

import java.util.ArrayList;
import java.util.List;

public class TypeTest2 {
    public static void main(String[] args) {
        List raw = new ArrayList<String>(); // Okay!
        List<?> wildcard = new ArrayList<String>(); // Okay!
            
        raw.add("Hello"); // Okay! ������ rawŸ����~
        System.out.println(raw);
        wildcard.size(); // Okay! ���׸� Ÿ�Կ� ������ ����
        wildcard.clear(); // Okay! ���׸� Ÿ�Կ� ������ ����
    }
}