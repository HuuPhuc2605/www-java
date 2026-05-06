package iuh.fit.ontap_de4.dao.Impl;

import iuh.fit.ontap_de4.dao.GiaiDauDAO;
import iuh.fit.ontap_de4.model.GiaiDau;
import iuh.fit.ontap_de4.util.ConnectDB;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GiaiDauDAOImpl implements GiaiDauDAO {

    @Override
    public List<GiaiDau> getAll() {
        List<GiaiDau> list = new ArrayList<>();
        String sql = "select * from giaidau";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps= connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                GiaiDau giaiDau = new GiaiDau();
                giaiDau.setMaGiai(rs.getInt("magiai"));
                giaiDau.setTenGiai(rs.getString("tengiai"));
                giaiDau.setDiaDiem(rs.getString("diadiem"));
                giaiDau.setNgayToChuc(new java.util.Date(rs.getDate("ngaytochuc").getTime()));
                list.add(giaiDau);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
