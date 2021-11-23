public class Teacher extends Person {
    private int id;
    private int luongMotGio;
    private int soGioDayTrongThang;

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLuongMotGio() {
        return luongMotGio;
    }

    public void setLuongMotGio(int luongMotGio) {
        this.luongMotGio = luongMotGio;
    }

    public int getSoGioDayTrongThang() {
        return soGioDayTrongThang;
    }

    public void setSoGioDayTrongThang(int soGioDayTrongThang) {
        this.soGioDayTrongThang = soGioDayTrongThang;
    }

    // @Override
    // public void inputInfo() {

    // }

    @Override
    public void showInfo() {

    }
}
