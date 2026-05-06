package iuh.fit.qloto.entities;

import jakarta.persistence.*;

@Entity
@Table(name="hangxe")
public class HangXe {
    @Id
    @Column(name="MAHANG", length=5)
    private String mahang;
    private String tenhang;

}