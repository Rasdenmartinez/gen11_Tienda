package ms.tienda.repository;

import ms.tienda.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProductosRepository extends JpaRepository<Productos, Long> {
   public List<Productos> findByNameAndPrecio(String nombreProducto, Double precio);
}
