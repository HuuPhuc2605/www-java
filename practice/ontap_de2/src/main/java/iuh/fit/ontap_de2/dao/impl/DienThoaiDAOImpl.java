package iuh.fit.ontap_de2.dao.impl;

import iuh.fit.ontap_de2.dao.DienThoaiDAO;
import iuh.fit.ontap_de2.model.DienThoai;
import iuh.fit.ontap_de2.model.HangSX;
import iuh.fit.ontap_de2.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private DienThoai mapDT(ResultSet rs) throws Exception {
      DienThoai d = new DienThoai();
               d.setMaDT(rs.getInt("madt"));
                d.setTenDT(rs.getString("tendt"));
                d.setGiaBan(rs.getDouble("giaban"));
                d.setBoNho(rs.getString("bonho"));
                d.setAnhDT(rs.getString("anhDT"));
                HangSX hangSX = new HangSX();
                hangSX.setMaHang(rs.getInt("maHang"));
                d.setMaHang(hangSX);
                return  d;
    }

    @Override
    public List<DienThoai> getAllDienThoai() {
        List<DienThoai> list = new ArrayList<>();
        String sql = "select * from dienthoai";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapDT(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public DienThoai getByID(int id) {

        String sql = "select * from dienthoai where madt=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapDT(rs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DienThoai> getByHang(int maHang) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "select * from dienthoai where mahang=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, maHang);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapDT(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<DienThoai> getByName(String tenDT) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "select * from dienthoai where tendt like ?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, "%" + tenDT + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapDT(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(DienThoai dienThoai) {
        String sql = "update dienthoai set tendt=?, giaban=?, bonho=?,anhdt=?, mahang=? where madt=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, dienThoai.getTenDT());
            ps.setDouble(2, dienThoai.getGiaBan());
            ps.setString(3, dienThoai.getBoNho());
            ps.setString(4, dienThoai.getAnhDT());
            ps.setInt(5, dienThoai.getMaHang().getMaHang());
            ps.setInt(6, dienThoai.getMaDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(DienThoai dienThoai) {
        String sql = "insert into dienthoai(tendt, giaban, bonho, anhdt, mahang) values(?,?,?,?,?)";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, dienThoai.getTenDT());
            ps.setDouble(2, dienThoai.getGiaBan());
            ps.setString(3, dienThoai.getBoNho());
            ps.setString(4, dienThoai.getAnhDT());
            ps.setInt(5, dienThoai.getMaHang().getMaHang());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int maDt) {
        String sql = "delete from dienthoai where madt=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, maDt);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}




