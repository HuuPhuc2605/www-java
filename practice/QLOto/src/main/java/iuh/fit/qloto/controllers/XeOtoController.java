package iuh.fit.qloto.controllers;

import iuh.fit.qloto.dto.XeOtoRequest;
import iuh.fit.qloto.entities.XeOto;
import iuh.fit.qloto.services.XeOtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/xeoto")
@CrossOrigin
public class XeOtoController {

    @Autowired
    private XeOtoService service;

    @GetMapping
    public List<XeOto> getAll() {         return service.getAll();
    }

    @PostMapping
    public XeOto create(@RequestBody XeOtoRequest x) {         return service.save(x);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {         service.delete(id);
    }
}
