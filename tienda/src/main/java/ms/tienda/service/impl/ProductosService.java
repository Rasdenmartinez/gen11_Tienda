package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.ProductosConstantes;
import ms.tienda.entity.Productos;
import ms.tienda.model.ResponseDelete;
import ms.tienda.repository.ProductosRepository;
import ms.tienda.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductosService implements IProductosService {
    @Autowired
    ProductosRepository productosRepository;

    @Override
    public List<Productos> readAll() {
        List<Productos> productosList = productosRepository.findAll().stream().filter(productos -> productos.getIsActive()!= ProductosConstantes.Filtrado).toList();
        return productosList;
    }

    @Override
    public Productos readById(Double id) {
        Optional<Productos> productosOptional = productosRepository.findById(id);
        if (productosOptional.isPresent() && productosOptional.get().getIsActive()!=ProductosConstantes.Filtrado){
            return productosOptional.get();
        }
        return new Productos();
    }

    @Override
    public Productos insert(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public Productos update(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public void delete(Double id) {
        productosRepository.deleteById(id);
    }
}
