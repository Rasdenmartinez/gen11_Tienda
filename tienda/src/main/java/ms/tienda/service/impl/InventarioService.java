package ms.tienda.service.impl;

import ms.tienda.entity.Inventario;
import ms.tienda.repository.InventarioRepository;
import ms.tienda.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService implements IInventarioService {
    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> readAll() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario readById(Long id) {
        Optional<Inventario>inventarioOptional=inventarioRepository.findById(id);
        if(inventarioOptional.isPresent()){
            return inventarioOptional.get();
        }else {
            return new Inventario();
        }
    }

    @Override
    public Inventario insert(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario update(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public void delete(Long id) {
        inventarioRepository.deleteById(id);
    }
}
