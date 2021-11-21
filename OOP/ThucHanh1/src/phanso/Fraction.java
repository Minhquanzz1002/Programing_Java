package phanso;

public class Fraction {
    private int numerator; // tu so
    private int denominator; // mau so

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction add(Fraction fraction) {
        int numerator = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction sub(Fraction fraction) {
        int numerator = this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction mul(Fraction fraction) {
        int numerator = this.numerator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction div(Fraction fraction) {
        int numerator = this.numerator * fraction.denominator;
        int denominator = this.denominator * fraction.numerator;
        return new Fraction(numerator, denominator);
    }

    public void display() {
        if (numerator * denominator < 0) {
            System.out.println("-" + Math.abs(numerator) + "/" + Math.abs(denominator));
        } else {
            System.out.println(Math.abs(numerator) + "/" + Math.abs(denominator));
        }
    }

    public void reduce() {
        // Tim uscln
        int a = numerator;
        int b = denominator;
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }

        // Toi gian phan so
        numerator /= b;
        denominator /= b;
    }

    public Fraction reduce(Fraction fraction) {
        // Tim uscln
        int a = fraction.numerator;
        int b = fraction.denominator;
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }

        // Toi gian phan so
        fraction.numerator /= b;
        fraction.denominator /= b;
        return fraction;
    }
}
