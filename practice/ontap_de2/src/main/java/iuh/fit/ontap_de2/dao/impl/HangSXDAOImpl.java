package iuh.fit.ontap_de2.dao.impl;

import iuh.fit.ontap_de2.dao.HangSXDAO;
import iuh.fit.ontap_de2.model.HangSX;
import iuh.fit.ontap_de2.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HangSXDAOImpl implements HangSXDAO {
    @Override
    public List<HangSX> getAllHangSX() {
        List<HangSX> list = new ArrayList<>();
        String sql = "select * from hangsx";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HangSX hangSX = new HangSX();
                hangSX.setMaHang(rs.getInt("mahang"));
                hangSX.setTenHang(rs.getString("tenhang"));
                hangSX.setQuocGia(rs.getString("quocgia"));
                list.add(hangSX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
