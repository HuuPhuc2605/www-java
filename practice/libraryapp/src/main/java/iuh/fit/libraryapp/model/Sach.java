package iuh.fit.libraryapp.model;

public class Sach {
    private  int maSach;
    private  String tenSach;
    private String tacGia;
    private  float giaTien;
    private String hinhAnh;
    private TheLoai maTL;

    public Sach() {
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public TheLoai getMaTL() {
        return maTL;
    }

    public void setMaTL(TheLoai maTL) {
        this.maTL = maTL;
    }
}
