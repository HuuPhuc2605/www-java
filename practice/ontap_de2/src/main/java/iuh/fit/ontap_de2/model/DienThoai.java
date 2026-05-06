package iuh.fit.ontap_de2.model;
//-- Bảng Hãng sản xuất
//CREATE TABLE HANGSX (
//        MAHANG INT PRIMARY KEY AUTO_INCREMENT,
//        TENHANG VARCHAR(100) NOT NULL,
//QUOCGIA VARCHAR(50)
//);
//
//        -- Bảng Điện thoại
//CREATE TABLE DIENTHOAI (
//        MADT INT PRIMARY KEY AUTO_INCREMENT,
//        TENDT VARCHAR(100) NOT NULL,
//GIABAN DECIMAL(12,2),
//BONHO VARCHAR(50),
//MAHANG INT,
//FOREIGN KEY (MAHANG) REFERENCES HANGSX(MAHANG)
//        );

public class DienThoai {
    private int maDT;
    private String tenDT;
    private double giaBan;
    private String boNho;
    private String anhDT;
    private  HangSX maHang;

    public DienThoai(int maDT, String tenDT, double giaBan, String boNho, String anhDT, HangSX maHang) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.giaBan = giaBan;
        this.boNho = boNho;
        this.anhDT = anhDT;
        this.maHang = maHang;
    }

    public DienThoai() {
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getBoNho() {
        return boNho;
    }

    public void setBoNho(String boNho) {
        this.boNho = boNho;
    }

    public String getAnhDT() {
        return anhDT;
    }

    public void setAnhDT(String anhDT) {
        this.anhDT = anhDT;
    }

    public HangSX getMaHang() {
        return maHang;
    }

    public void setMaHang(HangSX maHang) {
        this.maHang = maHang;
    }
}
