package iuh.fit.libraryapp.dao;

import iuh.fit.libraryapp.model.Sach;

import java.util.List;

public interface SachDAO {
    List<Sach> getAll();
    Sach getByID(int id);
    List<Sach> getByTheLoai(int maTL);
    List<Sach> getByName(String name);
    boolean update(Sach sach);

}
