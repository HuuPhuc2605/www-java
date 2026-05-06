package iuh.fit.ontap_de4.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class GiaiDau {
    private int maGiai;
    private String tenGiai;
    private String diaDiem;
    private Date ngayToChuc;

    public GiaiDau() {
    }

    public int getMaGiai() {
        return maGiai;
    }

    public void setMaGiai(int maGiai) {
        this.maGiai = maGiai;
    }

    public String getTenGiai() {
        return tenGiai;
    }

    public void setTenGiai(String tenGiai) {
        this.tenGiai = tenGiai;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public Date getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(Date ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }
}
