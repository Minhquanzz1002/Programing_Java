/**
 * @Minhquanzz1002
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String name;
    private Date dob;

    public Person() {
    }

    public Person(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public Person(String name, String dob) {
        this.name = name;
        this.dob = convertStringToDate(dob);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Chuyen kieu du lieu String sang Date
     * 
     * @param dob ngay sinh dang String
     * @return ngay sinh dang Date
     */
    public Date convertStringToDate(String dob) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date convert_dob = null;
        try {
            convert_dob = sdf.parse(dob);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convert_dob;
    }

    /**
     * Chuyen kieu du lieu Date sang String
     * 
     * @return Ngay sinh dang String
     */
    public String convertDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dob);
    }

    public void outputInfo() {
        System.out.format("%30s|%20s", name, convertDateToString());
    }
}
