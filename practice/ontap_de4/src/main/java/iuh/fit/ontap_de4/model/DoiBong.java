package iuh.fit.ontap_de4.model;

public class DoiBong {
    private int maDoi;
    private String tenDoi;
    private String hlv;
    private int thanhVien;
    private String logo;
    private GiaiDau maGiai;

    public DoiBong() {
    }

    public DoiBong(int maDoi, String tenDoi, String hlv, int thanhVien, String logo, GiaiDau maGiai) {
        this.maDoi = maDoi;
        this.tenDoi = tenDoi;
        this.hlv = hlv;
        this.thanhVien = thanhVien;
        this.logo = logo;
        this.maGiai = maGiai;
    }

    public int getMaDoi() {
        return maDoi;
    }

    public void setMaDoi(int maDoi) {
        this.maDoi = maDoi;
    }

    public String getTenDoi() {
        return tenDoi;
    }

    public void setTenDoi(String tenDoi) {
        this.tenDoi = tenDoi;
    }

    public String getHlv() {
        return hlv;
    }

    public void setHlv(String hlv) {
        this.hlv = hlv;
    }

    public int getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(int thanhVien) {
        this.thanhVien = thanhVien;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public GiaiDau getMaGiai() {
        return maGiai;
    }

    public void setMaGiai(GiaiDau maGiai) {
        this.maGiai = maGiai;
    }
}
