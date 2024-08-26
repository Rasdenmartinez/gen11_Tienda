package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Productos;
<<<<<<< HEAD
import ms.tienda.repository.PedidosRepository;
=======
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
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

<<<<<<< HEAD
        return productosRepository.findAll().stream().filter(s-> s.getIs_Active()!=Constantes.Filtro).toList();
=======
        return productosRepository.findAll().stream().filter(s-> s.getIsActive()!=Constantes.Filtro).toList();
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
    }

    @Override
    public Productos readById(Long id) {
        Optional<Productos> productosOptional = productosRepository.findById(id);
<<<<<<< HEAD
        if(productosOptional.isPresent() && productosOptional.get().getIs_Active()!=Constantes.Filtro){
=======
        if(productosOptional.isPresent() && productosOptional.get().getIsActive()!=Constantes.Filtro){
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
        return productosOptional.get();
        }else{
            return new Productos();
        }

    }

    @Override
    public Productos insert(Productos productos) {
<<<<<<< HEAD
        productos.setIs_Active(!Constantes.Filtro);
=======
        productos.setIsActive(!Constantes.Filtro);
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
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
<<<<<<< HEAD
            productos.setIs_Active(Constantes.Filtro);
=======
            productos.setIsActive(Constantes.Filtro);
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
            productosRepository.save(productos);
            log.info(" Producto {} deleted", id);

        }
        {log.error("El id producto no existe");}

    }
<<<<<<< HEAD
=======

    @Override
    public List<Productos> NamePrecio(String name, Double precio) {
        return productosRepository.findByNameAndPrecio(name, precio);
    }


>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
}
