package ms.tienda.service;

import ms.tienda.entity.Productos;
import ms.tienda.model.ProductosDto;
import ms.tienda.service.impl.MiException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductosService {
   public List<Productos> readAll() throws MiException;

     public Productos readById(Integer id) throws MiException;

     public Productos insert(Productos productos) throws MiException;

     public Productos update(Productos productos) throws MiException;

     public void delete(Integer id) throws MiException;

    List<Productos> NamePrecio(String name, Double precio) throws MiException;

    List<ProductosDto> findProductoByDto() throws MiException;


}
