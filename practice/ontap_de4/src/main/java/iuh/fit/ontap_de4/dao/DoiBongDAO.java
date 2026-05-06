package iuh.fit.ontap_de4.dao;

import iuh.fit.ontap_de4.model.DoiBong;
import iuh.fit.ontap_de4.model.GiaiDau;

import java.util.List;

public interface DoiBongDAO {
    List<DoiBong> getAllDB();
    DoiBong getBYID(int maDoi);
    List<DoiBong> getByGiai(int maGiai);
    List<DoiBong> getByTen(String tenDoi);
    boolean update(DoiBong doiBong);
}
