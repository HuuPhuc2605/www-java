package iuh.fit.ontap_de4.dao.Impl;

import iuh.fit.ontap_de4.dao.DoiBongDAO;
import iuh.fit.ontap_de4.model.DoiBong;
import iuh.fit.ontap_de4.model.GiaiDau;
import iuh.fit.ontap_de4.util.ConnectDB;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoiBongDaoImpl implements DoiBongDAO {
    private DoiBong mapDB(ResultSet rs) throws Exception {
        DoiBong doiBong = new DoiBong();
        doiBong.setMaDoi(rs.getInt("madoi"));
        doiBong.setTenDoi(rs.getString("tendoi"));
        doiBong.setHlv(rs.getString("hlv"));
        doiBong.setThanhVien(rs.getInt("thanhvien"));
        doiBong.setLogo(rs.getString("logo"));
        GiaiDau giaiDau = new GiaiDau();
        giaiDau.setMaGiai(rs.getInt("magiai"));
        doiBong.setMaGiai(giaiDau);
        return doiBong;

    }

    @Override
    public List<DoiBong> getAllDB() {
        List<DoiBong> list = new ArrayList<>();
        String sql = "select * from doibong";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapDB(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public DoiBong getBYID(int maDoi) {
        String sql = "select * from doibong where madoi=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, maDoi);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    return mapDB(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DoiBong> getByGiai(int maGiai) {
        List<DoiBong> list = new ArrayList<>();
        String sql = "select * from doibong where maGiai=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, maGiai);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapDB(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<DoiBong> getByTen(String tenDoi) {
        List<DoiBong> list = new ArrayList<>();
        String sql = "select * from doibong where tenDoi like?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, "%" + tenDoi + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapDB(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(DoiBong doiBong) {
        String sql = "update doibong set tendoi=?, hlv=?, thanhvien=?. logo=?, magiai=? where madoi=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, doiBong.getTenDoi());
            ps.setString(2, doiBong.getHlv());
            ps.setInt(3, doiBong.getThanhVien());
            ps.setString(4, doiBong.getLogo());
            ps.setInt(5, doiBong.getMaGiai().getMaGiai());
            ps.setInt(6, doiBong.getMaDoi());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
