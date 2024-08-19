package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Productos;
import ms.tienda.repository.PedidosRepository;
import ms.tienda.repository.ProductosRepository;
import ms.tienda.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class ProductosService implements IProductosService {
   @Autowired
    ProductosRepository productosRepository;
    @Override
    public List<Productos> nomreadAll() {

        return productosRepository.findAll().stream().filter(s-> s.getIs_Active()!=Constantes.Filtro).toList();
    }

    @Override
    public Productos readById(Long id) {
        Optional<Productos> productosOptional = productosRepository.findById(id);
        if(productosOptional.isPresent() && productosOptional.get().getIs_Active()!=Constantes.Filtro){
        return productosOptional.get();
        }else{
            return new Productos();
        }

    }

    @Override
    public Productos insert(Productos productos) {
        productos.setIs_Active(!Constantes.Filtro);
        return productosRepository.save(productos);
    }

    @Override
    public Productos update(Productos productos) {
        return productosRepository.save(productos);
    }

    @Override
    public void delete(Long id) {
        Optional<Productos> productosOptional = productosRepository.findById(id);
        if(productosOptional.isPresent()){
            Productos productos = productosOptional.get();
            productos.setIs_Active(Constantes.Filtro);
            productosRepository.save(productos);
            log.info(" Producto {} deleted", id);

        }
        {log.error("El id producto no existe");}

    }


}
