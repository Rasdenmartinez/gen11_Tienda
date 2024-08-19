package ms.tienda.service;

import ms.tienda.entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductosService {
   public List<Productos> nomreadAll();

     public Productos readById(Long id);

     public Productos insert(Productos productos);

     public Productos update(Productos productos);

     public void delete(Long id);


}
