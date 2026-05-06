package iuh.fit.libraryapp.dao.impl;

import iuh.fit.libraryapp.dao.SachDAO;
import iuh.fit.libraryapp.model.Sach;
import iuh.fit.libraryapp.model.TheLoai;
import iuh.fit.libraryapp.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SachDAOImpl implements SachDAO {
    private Sach mapSach(ResultSet rs) throws Exception {
        Sach s = new Sach();
        s.setMaSach(rs.getInt("MASACH"));
        s.setTenSach(rs.getString("TENSACH"));
        s.setTacGia(rs.getString("TACGIA"));
        s.setGiaTien(rs.getFloat("GIATIEN"));
        s.setHinhAnh(rs.getString("HINHANH"));
        TheLoai tl = new TheLoai();
        tl.setMaTL(rs.getInt("MATL"));
        s.setMaTL(tl);
        return s;
    }

    @Override
    public List<Sach> getAll() {
        List<Sach> list = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapSach(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Sach getByID(int id) {
        String sql = "SELECT * FROM Sach where maSach = ?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapSach(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sach> getByTheLoai(int maTL) {
        List<Sach> list = new ArrayList<>();
        String sql = "SELECT * FROM Sach where maTL=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, maTL);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapSach(rs));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Sach> getByName(String name) {
        List<Sach> list = new ArrayList<>();
        String sql = "SELECT * FROM Sach where tensach like  ?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapSach(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(Sach sach) {
        String sql = "update sach set tensach=?, tacgia=?, giatien=?, hinhanh=?, matl=? where masach=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getTacGia());
            ps.setFloat(3, sach.getGiaTien());
            ps.setString(4, sach.getHinhAnh());
            ps.setInt(5, sach.getMaTL().getMaTL());
            ps.setInt(6, sach.getMaSach());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
