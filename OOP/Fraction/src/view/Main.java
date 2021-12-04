package view;

import model.Fraction;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(5, 6);
        Fraction f2 = new Fraction(5, 6);
        System.out.println(f1.add(f2));
        System.out.println(f1.subtract(f2));
        System.out.println(f1.multiply(f2));
        System.out.println(f1.divide(f2));
        System.out.println(f1.equals(f2));
        System.out.println(f1.pow(3));
        System.out.println(f1.compareTo(f2));
    }
}
