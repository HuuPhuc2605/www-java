package iuh.fit.ontap_de2.model;

public class HangSX {
    private int maHang;
    private String tenHang;
    private String quocGia;

    public HangSX() {
    }

    public HangSX(int maHang, String tenHang, String quocGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.quocGia = quocGia;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
}
