package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Productos;
import ms.tienda.model.DeleteDto;
import ms.tienda.model.ProductosDto;
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
    public List<Productos> readAll() {
        return productosRepository.findAll().stream().filter(s -> s.getIsActive() == Constantes.Filtro).toList();
    }

    @Override
    public Productos readById(Double id) throws MiException {
        Optional<Productos> productosOptional = productosRepository.findById(id);
        if(productosOptional.isPresent() && productosOptional.get().getIsActive()==Constantes.Filtro){
           return productosOptional.get();
        }
        return new Productos();
    }

    @Override
    public Productos insert(Productos productos) throws MiException {
        productos.setIsActive(Constantes.Filtro);
        return productosRepository.save(productos);
    }

    @Override
    public Productos update(Productos productos) throws MiException {
        return productosRepository.save(productos);
    }

    @Override
    public String productoDeleteDto(Double id)  {                              //Delete lógico!!
        Optional<Productos> productosOptional = productosRepository.findById(id);
        if(productosOptional.isPresent()){
            Productos productos = productosOptional.get();
            productos.setIsActive(!Constantes.Filtro);
            productosRepository.save(productos);
        }
        DeleteDto deleteDto = new DeleteDto();
        return deleteDto.getMensajeProducto();
    }

    @Override
    public List<Productos> NamePrecio(String name, Double precio) throws MiException {
        return productosRepository.findByNameAndPrecio(name, precio);
    }

    @Override
    public List<ProductosDto> responseProductoByDto() throws MiException {
        List<Productos> productosList = productosRepository.findByProductDto();

        return productosList.stream().map(s->{
            ProductosDto productDto = new ProductosDto();
            productDto.setCodigo(s.getId());
            productDto.setProducto(s.getName());
            productDto.setDescripcionProducto(s.getDescripcionProducto());
            productDto.setPrecio(s.getPrecio());
            productDto.setCategoria(s.getCategoria());
            productDto.setStock(s.getStock());


            return  productDto;
        }).toList();
    }

}
