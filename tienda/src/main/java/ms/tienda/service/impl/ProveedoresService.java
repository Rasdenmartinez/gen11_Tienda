package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.ProveedoresConstantes;
import ms.tienda.entity.Proveedores;
import ms.tienda.repository.ProveedoresRepository;
import ms.tienda.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class ProveedoresService implements IProveedoresService {
    @Autowired
    ProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> readAll() {
        return proveedoresRepository.findAll().stream().filter(proveedores -> proveedores.getIsActive()!= ProveedoresConstantes.Filtrado).toList();
    }

    @Override
    public Proveedores readById(Double id) {
        Optional<Proveedores>proveedoresOptional=proveedoresRepository.findById(id);
        if (proveedoresOptional.isPresent() && proveedoresOptional.get().getIsActive()!= ProveedoresConstantes.Filtrado) {
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
    public void delete(Double id) {
        Optional<Proveedores>proveedoresOptional=proveedoresRepository.findById(id);
        if (proveedoresOptional.isPresent()){
            Proveedores proveedor = proveedoresOptional.get();
            proveedor.setIsActive(false);
            proveedoresRepository.save(proveedor);
            log.info("Proveedor {} borrado",id);
        }else {
            log.error("El proveedor no existe");
        }
    }
}
