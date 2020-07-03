package item17;

//������ ��ſ� ���� ���͸��� �̿��Ͽ� �Һ� Ŭ������ ���� �� �ִ�.
public class Complex2 {
    // Ŭ������ final�� ����.

    private final double realNumber2; // �Ǽ���
    private final double imaginaryNumber2; // �����

    // �����ڰ� private
    private Complex2(double realNumber2, double imaginaryNumber2) {
        this.realNumber2 = realNumber2;
        this.imaginaryNumber2 = imaginaryNumber2;
    }

    public static Complex2 valueOf(double re, double im) {
        return new Complex2(re, im);
    }

    // ...����
}
