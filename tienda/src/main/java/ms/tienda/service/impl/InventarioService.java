package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.InventarioConstantes;
import ms.tienda.entity.Inventario;
import ms.tienda.repository.InventarioRepository;
import ms.tienda.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InventarioService implements IInventarioService {
    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> readAll() {
        return inventarioRepository.findAll().stream().filter(inventario -> inventario.getIsActive()!= InventarioConstantes.Filtrado).toList();
    }

    @Override
    public Inventario readById(Double id) {
        Optional<Inventario>inventarioOptional=inventarioRepository.findById(id);
        if(inventarioOptional.isPresent() && inventarioOptional.get().getIsActive()!=InventarioConstantes.Filtrado){
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
    public void delete(Double id) {
        Optional<Inventario>inventarioOptional=inventarioRepository.findById(id);
        if (inventarioOptional.isPresent()){
            Inventario inventario = inventarioOptional.get();
            inventario.setIsActive(false);
            inventarioRepository.save(inventario);
            log.info("El Item {} fue borrado",id);
        }else {
            log.error("El item no existe");
        }
    }
}
