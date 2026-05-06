package iuh.fit.ontap_de2.dao;

import iuh.fit.ontap_de2.model.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> getAllDienThoai();
    DienThoai getByID(int id);
    List<DienThoai> getByHang(int maHang);
    List<DienThoai> getByName(String tenDT);
    boolean update(DienThoai dienThoai);
    boolean add(DienThoai dienThoai);
    boolean delete(int maDt);
}
