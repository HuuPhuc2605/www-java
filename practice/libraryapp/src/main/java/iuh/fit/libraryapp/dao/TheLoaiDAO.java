package iuh.fit.libraryapp.dao;

import iuh.fit.libraryapp.model.TheLoai;

import java.util.List;

public interface TheLoaiDAO {
    List<TheLoai> getAll();
    TheLoai findByID(int id);
}
