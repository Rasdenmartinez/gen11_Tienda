package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Productos;
import ms.tienda.model.ProductosDto;
import ms.tienda.repository.ProductosRepository;
import ms.tienda.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@Slf4j
@Service
public class ProductosService implements IProductosService {
   @Autowired
    ProductosRepository productosRepository;
    @Override
    public List<Productos> readAll() throws MiException {
       try{
        return productosRepository.findAll().stream().filter(s -> s.getIsActive() == Constantes.Filtro).toList();
       } catch(Exception e){
             throw new MiException("Error al obtener lista de productos");
             }

    }


    @Override
    public Productos readById(Integer id) throws MiException {
        try {
            Optional<Productos> productosOptional = productosRepository.findById(id);
            if (productosOptional.isPresent() && productosOptional.get().getIsActive() == Constantes.Filtro) {
                return productosOptional.get();
            } else {
                return new Productos();
            }
        }catch (Exception e){
            throw new MiException("Error al buscar id de producto");
        }
    }

    @Override
    public Productos insert(Productos productos) throws MiException {

        try {
            productos.setIsActive(Constantes.Filtro);
            productos.setFechaCreacion(LocalDateTime.now());
            return productosRepository.save(productos);
        }catch(Exception e){
            throw new MiException("Error al insertar producto");
        }
    }

    @Override
    public Productos update(Productos productos) throws MiException {
        try {
            productos.setModificacionFecha(LocalDateTime.now());
            return productosRepository.save(productos);
        }catch(Exception e){
            throw  new MiException("Error en el update de productos");
        }

    }

    @Override
    public void delete(Integer id) throws MiException {
        try {
            Optional<Productos> productosOptional = productosRepository.findById(id);
            if (productosOptional.isPresent()) {
                Productos productos = productosOptional.get();
                productos.setIsActive(Constantes.Filtro);
                productosRepository.save(productos);
                log.info(" Producto {} deleted", id);

            }

        }catch(Exception e){
            throw  new MiException("Error al Eliminar producto");
        }
    }

    @Override
    public List<Productos> NamePrecio(String name, Double precio) throws MiException {
        try {

            return productosRepository.findByNameAndPrecio(name, precio);
        }catch(Exception e){

            throw new MiException("Error al encontrar nombre y precio");
        }
    }

    @Override
    public List<ProductosDto> findProductoByDto() throws MiException {
     try {
         List<Productos> productosList = productosRepository.findByProductDto();
         return productosList.stream().map(s -> {
             ProductosDto productosDto = new ProductosDto();
             productosDto.setId(s.getId());
             productosDto.setName(s.getName());
             productosDto.setDescripcionProducto(s.getDescripcionProducto());
             productosDto.setPrecio(s.getPrecio());
             productosDto.setCategoria(s.getCategoria());
             productosDto.setStock(s.getStock());

             return productosDto;
         }).toList();
     }catch(Exception e){
         throw new MiException("Error al generar DTO");
     }
    }


}
