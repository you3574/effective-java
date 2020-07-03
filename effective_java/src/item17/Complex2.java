package item17;

//생성자 대신에 정적 팩터리를 이용하여 불변 클래스를 만들 수 있다.
public class Complex2 {
    // 클래스에 final이 없다.

    private final double realNumber2; // 실수부
    private final double imaginaryNumber2; // 허수부

    // 생성자가 private
    private Complex2(double realNumber2, double imaginaryNumber2) {
        this.realNumber2 = realNumber2;
        this.imaginaryNumber2 = imaginaryNumber2;
    }

    public static Complex2 valueOf(double re, double im) {
        return new Complex2(re, im);
    }

    // ...생략
}
