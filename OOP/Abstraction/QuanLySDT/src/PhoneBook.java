import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook extends Phone {
    private ArrayList<String> phoneList;

    public PhoneBook() {
        phoneList = new ArrayList<>();
    }

    @Override
    void insertPhone(String name, String phone) {
        if (phoneList.isEmpty()) {
            phoneList.add(name + ", " + phone);
            return;
        }
        for (String p : phoneList) {
            if (p.contains(name + ",")) {
                if (p.contains(phone)) {
                    phoneList.set(phoneList.indexOf(p), p + ":" + phone);
                    return;
                }
            }
        }
        phoneList.add(name + ", " + phone);
    }

    @Override
    void removePhone(String name) {
        if (phoneList.isEmpty()){
            System.out.print("Danh ba rong!");
            return;
        }
        for (String pl : phoneList) {
            if (pl.contains(name + ",")) {
                phoneList.remove(pl);
                System.out.println("Xoa thanh cong!");
                break;
            }
        }
    }

    @Override
    void searchPhone(String name) {
        if (phoneList.isEmpty()) {
            System.out.println("Danh ba rong!");
            return;
        }
        for (String p : phoneList) {
            if (p.contains(name + ",")) {
                System.out.println(p);
            }
        }
    }

    @Override
    void sort() {
        if (phoneList.isEmpty()) {
            System.out.println("Danh ba trong!");
            return;
        }
        Collections.sort(phoneList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        showList();
    }

    @Override
    void updatePhone(String name, String new_phone) {
        int size = phoneList.size();
        for (int i = 0; i < size; i++) {
            if (phoneList.get(i).contains(name + ",")) {
                phoneList.set(i, name + ", " + new_phone);
                System.out.println("Update thanh cong!");
                break;
            }
        }
        System.out.println("Khong tim thay!");
    }

    public void showList() {
        if (phoneList.isEmpty()){
            System.out.println("Danh ba rong");
            return;
        }
        for (String pl : phoneList) {
            System.out.println(pl);
        }
    }

    public ArrayList<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<String> phoneList) {
        this.phoneList = phoneList;
    }
}
