package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.InventarioConstantes;
import ms.tienda.entity.Inventario;
import ms.tienda.exceptions.ResponseNotFound;
import ms.tienda.model.ResponseDelete;
import ms.tienda.model.ResponseInventario;
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
    public List<ResponseInventario> readAll() {
        List<Inventario>inventarioList=inventarioRepository.findAll().stream().filter(inventario -> inventario.getIsActive()!=InventarioConstantes.Filtrado).toList();
        if (inventarioList.isEmpty()){
            log.error("La consulta no arrojo ningun resultado");
            throw new ResponseNotFound("La consulta no arrojo ningun resultado");
        }
        return inventarioList.stream().map(inventario -> {
            ResponseInventario responseInventario = new ResponseInventario();
            responseInventario.setId(inventario.getId());
            responseInventario.setProductoId(inventario.getProductoId());
            responseInventario.setStock(inventario.getStock());
            return responseInventario;
        }).toList();
    }

    @Override
    public ResponseInventario readById(Double id) {
        Optional<Inventario>inventarioOptional=inventarioRepository.findById(id);
        if(inventarioOptional.isPresent() && inventarioOptional.get().getIsActive()==InventarioConstantes.Filtrado){
            log.error("El elemento {} no existe",id);
            throw new ResponseNotFound("El elemento " + id + " no existe");
        }

        if (inventarioOptional.isEmpty()){
            log.error("El elemento {} no existe",id);
            throw new ResponseNotFound("El elemento " + id + " no existe");
        }

        if (inventarioOptional.isPresent() && inventarioOptional.get().getIsActive()!=InventarioConstantes.Filtrado){
            Inventario inventario = inventarioOptional.get();
            ResponseInventario responseInventario = new ResponseInventario();
            responseInventario.setId(inventario.getId());
            responseInventario.setProductoId(inventario.getProductoId());
            responseInventario.setStock(inventario.getStock());
            log.info("Consulta exitosa");
            return responseInventario;
        }
        return new ResponseInventario();
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
    public ResponseDelete delete(Double id) {
        Optional<Inventario>inventarioOptional=inventarioRepository.findById(id);
        if (inventarioOptional.isPresent() && inventarioOptional.get().getIsActive()==InventarioConstantes.Filtrado){
            log.error("El elemento {} no existe",id);
            throw new ResponseNotFound("El elemento " + id + " no existe");
        }

        if (inventarioOptional.isEmpty()){
            log.error("El elemento {} no existe",id);
            throw  new ResponseNotFound("El elemento " + id + " no existe");
        }

        if (inventarioOptional.isPresent()){
            Inventario inventario = inventarioOptional.get();
            inventario.setIsActive(false);
            inventarioRepository.save(inventario);
            ResponseDelete responseDelete = new ResponseDelete();
            responseDelete.setId(inventario.getId());
            responseDelete.setMensaje("Elemento borrado exitosamente");
            log.info("Elemento {} borrado exitosamente", id);
            return responseDelete;
        }
        return new ResponseDelete();
    }
}
