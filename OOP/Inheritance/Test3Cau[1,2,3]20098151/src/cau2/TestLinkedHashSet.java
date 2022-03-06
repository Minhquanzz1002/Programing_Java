package cau2;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Product> qlSP = new LinkedHashSet<>();
        Product[] sp = new Product[2];
        sp[0] = new Product();
        sp[1] = new Product();
        sp[0].nhapSanPham();
        sp[1].nhapSanPham();
        qlSP.add(sp[0]);
        qlSP.add(sp[1]);
        System.out.println("----------------------------------------------------------------------");
        Iterator<Product> list = qlSP.iterator();
        while (list.hasNext()) {
            Product x = list.next();
            System.out.print(x);
        }

    }
}
