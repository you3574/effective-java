package item14;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

//�ڵ� 14-1 ��ü ���� �ʵ尡 �ϳ����� ���� (90��)
public final class CaseInsensitiveString
     implements Comparable<CaseInsensitiveString> {
 private final String s;

 public CaseInsensitiveString(String s) {
     this.s = Objects.requireNonNull(s);
 }

 // ������ equals �޼��� (56��)
 @Override
 public boolean equals(Object o) {
     return o instanceof CaseInsensitiveString &&
             ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
 }

 @Override
 public int hashCode() {
     return s.hashCode();
 }

 @Override
 public String toString() {
     return s;
 }

 // �ڹٰ� �����ϴ� ���ڸ� ����� Ŭ������ ���Ѵ�.
 public int compareTo(CaseInsensitiveString cis) {
     return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
 }

 public static void main(String[] args) {
     Set<CaseInsensitiveString> s = new TreeSet<>();

     String[] args2 = {"B","A","D"};

     for (String arg : args2)
         s.add(new CaseInsensitiveString(arg));

     System.out.println(s);
 }
}