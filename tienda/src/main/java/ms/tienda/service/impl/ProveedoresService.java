package ms.tienda.service.impl;

import ms.tienda.entity.Proveedores;
import ms.tienda.repository.ProveedoresRepository;
import ms.tienda.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProveedoresService implements IProveedoresService {
    @Autowired
    ProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> readAll() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Proveedores readById(Long id) {
        Optional<Proveedores>proveedoresOptional=proveedoresRepository.findById(id);
        if (proveedoresOptional.isPresent()) {
            return proveedoresOptional.get();
        }else {
            return new Proveedores();
        }
    }

    @Override
    public Proveedores insert(Proveedores proveedor) {

        return proveedoresRepository.save(proveedor);
    }

    @Override
    public Proveedores update(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        proveedoresRepository.deleteById(id);
    }
}
