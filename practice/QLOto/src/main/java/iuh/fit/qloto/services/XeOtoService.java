package iuh.fit.qloto.services;

import iuh.fit.qloto.dto.XeOtoRequest;
import iuh.fit.qloto.entities.HangXe;
import iuh.fit.qloto.entities.XeOto;
import iuh.fit.qloto.repositories.HangXeRepository;
import iuh.fit.qloto.repositories.XeOtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeOtoService {

    @Autowired
    private XeOtoRepository repo;

    @Autowired
    private HangXeRepository hangRepo;

    public List<XeOto> getAll() {
        return repo.findAll();
    }

    public XeOto save(XeOtoRequest req) {

        HangXe hang = hangRepo.findById(req.mahang).orElseThrow();

        XeOto x = new XeOto();
        x.setMaxe(req.maxe);
        x.setTenxe(req.tenxe);
        x.setGiaban(req.giaban);
        x.setDungtich(req.dungtich);
        x.setHinhanh(req.hinhanh);
        x.setHangXe(hang);
        return repo.save(x);
    }


    public void delete(String id) {
        repo.deleteById(id);
    }
}

