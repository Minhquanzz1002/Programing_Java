package cau2;

public class Test {
    private static int luongCaoNhat = 0;

    /**
     * kiem tra nhan vien thuoc cong ty khong. Tinh ca "nhan vien" va "quan ly"
     * @param dsNV danh sach nhan vien
     * @param dsQuanLy danh sach quan ly
     */
    public static void kiemTraNhanVien(Employee[] dsNV, Manager[] dsQuanLy) {
        Employee e = new Employee(new Person("", 0, ""), 0);
        System.out.println("Nhap thong tin nhan vien can kiem tra.");
        e.inputEmployee();
        boolean result = e.kiemTraTonTai(dsNV, dsQuanLy);
        if (result) {
            System.out.println("Day la nhan vien cong ty.");
        } else {
            System.out.println("Day khong phai nhan vien cong ty.");
        }
    }

    /**
     * tinh luong cao nhat toan cty gom ca "nhan vien" va "quan ly"
     * @param dsNV danh sach nhan vien
     * @param dsQuanLy danh sach quan ly
     */
    public static void setLuongCaoNhat(Employee[] dsNV, Manager[] dsQuanLy) {
        luongCaoNhat = dsNV[0].getSalary();
        for (int i = 1; i < dsNV.length; i++) {
            if (luongCaoNhat < dsNV[i].getSalary()) {
                luongCaoNhat = dsNV[i].getSalary();
            }
        }
        for (int i = 0; i < dsQuanLy.length; i++) {
            if (luongCaoNhat < dsQuanLy[i].getSalary()) {
                luongCaoNhat = dsQuanLy[i].getSalary();
            }
        }
    }

    /**
     * In ra cac nhan vien co luong cao nhat. Gom ca "nhan vien" va "quan ly"
     * @param dsNV
     * @param dsQuanLy
     */
    public static void inCacNhanVienCoLuongCaoNhat(Employee[] dsNV, Manager[] dsQuanLy) {
        setLuongCaoNhat(dsNV, dsQuanLy);
        for (int i = 1; i < dsNV.length; i++) {
            if (luongCaoNhat == dsNV[i].getSalary()) {
                System.out.println(dsNV[i].getDetail());
            }
        }
        for (int i = 0; i < dsQuanLy.length; i++) {
            if (luongCaoNhat == dsQuanLy[i].getSalary()) {
                System.out.println(dsQuanLy[i].getDetail());
            }
        }
    }

    /**
     * Tinh luong toan cong ty gom ca "nhan vien" va "quan ly"
     * @param dsNV danh sach nhan vien
     * @param dsQuanLy danh sach quan ly
     * @return tong luong
     */
    public static int tongLuongToanCongTy(Employee[] dsNV, Manager[] dsQuanLy) {
        int tongLuong = 0;
        for (Employee employee : dsNV) {
            tongLuong += employee.getSalary();
        }
        for (Manager manager : dsQuanLy) {
            tongLuong += manager.getSalary();
        }
        return tongLuong;
    }

    /**
     * Dem so nhan vien dam nhiem vai tro tro ly
     * @param dsNV danh sach nhan vien
     * @param dsQuanLy danh sach quan ly
     * @return so luong tro ly
     */
    public static int demSoTroLy(Employee[] dsNV, Manager[] dsQuanLy) {
        int dem = 0;
        for (int i = 0; i < dsNV.length; i++) {
            for (int j = 0; j < dsQuanLy.length; j++) {
                if ((dsNV[i].id).equals(dsQuanLy[j].getAssistant().id) == true) {
                    dem++;
                    break;
                }
            }
        }
        return dem;
    }

    public static void main(String[] args) {
        Person[] dsNguoi = new Person[20];
        Employee[] dsNV = new Employee[10];
        Manager[] dsQuanLy = new Manager[5];

        dsNguoi[0] = new Person("Duyen", 1990, "20098151");
        dsNguoi[1] = new Person("Ha", 1992, "20098152");
        dsNguoi[2] = new Person("Tuyen", 2002, "20098153");
        dsNguoi[3] = new Person("Ngoc", 2002, "20098154");
        dsNguoi[4] = new Person("Kieu", 2002, "20098155");
        dsNguoi[5] = new Person("Linh", 2002, "20098156");
        dsNguoi[6] = new Person("Hoa", 2002, "20098157");
        dsNguoi[7] = new Person("Tuan", 2002, "20098158");
        dsNguoi[8] = new Person("Le", 2002, "20098159");
        dsNguoi[9] = new Person("Manh", 2002, "20098160");
        dsNguoi[10] = new Person("Nam", 1990, "20098161");
        dsNguoi[11] = new Person("Vera", 1988, "20098162");
        dsNguoi[12] = new Person("Minh", 1989, "20098163");
        dsNguoi[13] = new Person("Davis", 1993, "20098164");
        dsNguoi[14] = new Person("Hung", 1980, "20098165");
        dsNguoi[15] = new Person("Ngan", 2002, "20098166");
        dsNguoi[16] = new Person("Xuan", 1999, "20098167");
        dsNguoi[17] = new Person("Manh", 2001, "20098168");
        dsNguoi[18] = new Person("An", 2000, "20098169");
        dsNguoi[19] = new Person("Anh", 2000, "20098170");

        dsNV[0] = new Employee(dsNguoi[0], 9000000);
        dsNV[1] = new Employee(dsNguoi[1], 3000000);
        dsNV[2] = new Employee(dsNguoi[2], 5500000);
        dsNV[3] = new Employee(dsNguoi[3], 11000000);
        dsNV[4] = new Employee(dsNguoi[4], 10500000);
        dsNV[5] = new Employee(dsNguoi[5], 15000000);
        dsNV[6] = new Employee(dsNguoi[6], 6000000);
        dsNV[7] = new Employee(dsNguoi[7], 14000000);
        dsNV[8] = new Employee(dsNguoi[8], 12000000);
        dsNV[9] = new Employee(dsNguoi[9], 13000000);

        dsQuanLy[0] = new Manager(dsNguoi[10], 30000000, dsNV[0]);
        dsQuanLy[1] = new Manager(dsNguoi[11], 20000000, dsNV[5]);
        dsQuanLy[2] = new Manager(dsNguoi[12], 20000000, dsNV[5]);
        dsQuanLy[3] = new Manager(dsNguoi[13], 20000000, dsNV[5]);
        dsQuanLy[4] = new Manager(dsNguoi[14], 30000000, dsNV[4]);

        System.out.println("So nhan vien kim tro ly trong cty: "
                + demSoTroLy(dsNV, dsQuanLy));
        System.out.println("\n---------------------------------------------------------------");
        kiemTraNhanVien(dsNV, dsQuanLy);
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Tong luong cua tat ca nhan vien trong cty: "
                + tongLuongToanCongTy(dsNV, dsQuanLy));
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Cac nhan vien co luong cao nhat trong cty.");
        System.out.format("%30s|%10s|%10s|%10s%n", "Ten nhan vien", "Nam sinh", "Gioi tinh", "Luong");
        inCacNhanVienCoLuongCaoNhat(dsNV, dsQuanLy);
    }
}
