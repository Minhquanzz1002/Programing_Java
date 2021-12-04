package model;

public class Fraction {
    private int numerator; // tu so
    private int denominator; // mau so

    public Fraction() {
        super();
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Getter && Setter
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

    /**
     * Cong hai phan so
     * 
     * @param f phan so
     * @return phan so ket qua
     */
    public Fraction add(Fraction f) {
        int numerator = this.numerator * f.denominator + this.denominator * f.numerator;
        int denominator = this.denominator * f.denominator;
        return reduce(new Fraction(numerator, denominator));
    }

    /**
     * Tru hai phan so
     * 
     * @param f phan so
     * @return phan so ket qua
     */
    public Fraction subtract(Fraction f) {
        int numerator = this.numerator * f.denominator - this.denominator * f.numerator;
        int denominator = this.denominator * f.denominator;
        return reduce(new Fraction(numerator, denominator));
    }

    /**
     * Nhan hai phan so
     * 
     * @param f phan so
     * @return phan so ket qua
     */
    public Fraction multiply(Fraction f) {
        int numerator = this.numerator * f.numerator;
        int denominator = this.denominator * f.denominator;
        return reduce(new Fraction(numerator, denominator));
    }

    /**
     * Chia hai phan so
     * 
     * @param f phan so
     * @return phan so ket qua
     */
    public Fraction divide(Fraction f) {
        int numerator = this.numerator * f.denominator;
        int denominator = this.denominator * f.numerator;
        return reduce(new Fraction(numerator, denominator));
    }

    /**
     * Tinh mu n cua phan so
     * 
     * @param n so mu
     * @return phan so mu n
     */
    public Fraction pow(int n) {
        return reduce(new Fraction((int) Math.pow(numerator, n), (int) Math.pow(denominator, n)));
    }

    /**
     * So sanh hai phan so
     * @param f phan so
     * @return this > f: 1
     *         ,this < f: -1
     *         ,this == f: 0
     */
    public int compareTo(Fraction f) {
        final int SMALLER = -1;
        final int EQUAL = 0;
        final int LARGER = 1;
        if (this == f) {
            return EQUAL;
        }
        if (numerator * f.denominator == f.numerator * denominator) {
            return EQUAL;
        }
        if (numerator * f.denominator > f.numerator * denominator) {
            return LARGER;
        } else {
            return SMALLER;
        }
    }

    /**
     * Tra ve true neu obj la 1 phan so va co cung gia tri
     */
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            if (((Fraction) obj).numerator == numerator && ((Fraction) obj).denominator == denominator) {
                return true;
            }
        }
        return false;
    }

    public void reduce() {
        // Tim UCLN
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

    /**
     * Toi gian pha so
     * 
     * @param fraction phan so
     * @return phan so da toi gian
     */
    public Fraction reduce(Fraction fraction) {
        // Tim UCLN
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

    @Override
    public String toString() {
        return "Fraction: [numerator = " + numerator + ", denominaror = " + denominator + "]";
    }
}
