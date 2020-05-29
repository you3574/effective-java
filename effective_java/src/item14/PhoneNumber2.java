package item14;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Comparator.comparingInt;

// PhoneNumber�� ���� �� �ְ� �����. (91-92��)
public final class PhoneNumber2 implements Cloneable, Comparable<PhoneNumber2> {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber2(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "�����ڵ�");
        this.prefix = rangeCheck(prefix, 999, "�����Ƚ�");
        this.lineNum = rangeCheck(lineNum, 9999, "������ ��ȣ");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber2))
            return false;
        PhoneNumber2 pn = (PhoneNumber2) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * �� ��ȭ��ȣ�� ���ڿ� ǥ���� ��ȯ�Ѵ�.
     * �� ���ڿ��� "XXX-YYY-ZZZZ" ������ 12���ڷ� �����ȴ�.
     * XXX�� ���� �ڵ�, YYY�� �����Ƚ�, ZZZZ�� ������ ��ȣ��.
     * ������ �빮�ڴ� 10���� ���� �ϳ��� ��Ÿ����.
     * <p>
     * ��ȭ��ȣ�� �� �κ��� ���� �ʹ� �۾Ƽ� �ڸ����� ä�� �� ���ٸ�,
     * �տ������� 0���� ä��������. ������ ������ ��ȣ�� 123�̶��
     * ��ȭ��ȣ�� ������ �� ���ڴ� "0123"�� �ȴ�.
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    // �ڵ� 14-3 ���� ���� �޼��带 Ȱ���� ���� (92��)
    private static final Comparator<PhoneNumber2> COMPARATOR =
            comparingInt((PhoneNumber2 pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber2 pn) {
        return COMPARATOR.compare(this, pn);
    }

    private static PhoneNumber2 randomPhoneNumber() {
        Random rnd = ThreadLocalRandom.current();
        return new PhoneNumber2((short) rnd.nextInt(1000),
                (short) rnd.nextInt(1000),
                (short) rnd.nextInt(10000));
    }

    public static void main(String[] args) {
        NavigableSet<PhoneNumber2> s = new TreeSet<PhoneNumber2>();
        for (int i = 0; i < 10; i++)
            s.add(randomPhoneNumber());
        System.out.println(s);
    }
}