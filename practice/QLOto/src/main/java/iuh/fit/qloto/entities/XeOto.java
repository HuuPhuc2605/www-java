package iuh.fit.qloto.entities;

import jakarta.persistence.*;

@Entity
@Table(name="xeoto")
public class XeOto {
    @Id
    private String maxe;
    private String tenxe;
    private Double giaban;
    private Float dungtich;
    private String hinhanh;
    @ManyToOne
    @JoinColumn(name = "MAHANG")
    private HangXe hangXe;

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public Double getGiaban() {
        return giaban;
    }

    public void setGiaban(Double giaban) {
        this.giaban = giaban;
    }

    public Float getDungtich() {
        return dungtich;
    }

    public void setDungtich(Float dungtich) {
        this.dungtich = dungtich;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public HangXe getHangXe() {
        return hangXe;
    }

    public void setHangXe(HangXe hangXe) {
        this.hangXe = hangXe;
    }
}