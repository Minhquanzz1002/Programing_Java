package phanso;

public class Test {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(10, 5);
        Fraction fraction2 = new Fraction(3, 2);
        fraction1.add(fraction2).display();
        fraction1.sub(fraction2).display();
        fraction1.mul(fraction2).display();
        fraction1.div(fraction2).display();
    }
}
