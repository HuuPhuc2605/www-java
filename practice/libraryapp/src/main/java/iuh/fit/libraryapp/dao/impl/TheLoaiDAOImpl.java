package iuh.fit.libraryapp.dao.impl;

import iuh.fit.libraryapp.dao.TheLoaiDAO;
import iuh.fit.libraryapp.model.Sach;
import iuh.fit.libraryapp.model.TheLoai;
import iuh.fit.libraryapp.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAOImpl implements TheLoaiDAO {
    @Override
    public List<TheLoai> getAll() {
        List<TheLoai> list = new ArrayList<>();
        String sql = "SELECT * FROM TheLoai";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                TheLoai theLoai = new TheLoai();
                theLoai.setMaTL(rs.getInt("MATL"));
                theLoai.setTenTL(rs.getString("TenTL"));
                theLoai.setMoTa(rs.getString("Mota"));


                list.add(theLoai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TheLoai findByID(int id) {
        return null;
    }
}
