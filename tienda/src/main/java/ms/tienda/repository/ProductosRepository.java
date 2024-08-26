package ms.tienda.repository;

import ms.tienda.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
//JPA query
   public List<Productos> findByNameAndPrecio(String name, Double precio);
   @Query(value = "SELECT p.id, p.producto, p.descripcion_producto, p.precio, " +
                 "p.categoria, p.stock, p.creacion_fecha, modificacion_fecha, "+
                "p.is_active, p.proveedor_id "+
                  "FROM productos p ", nativeQuery = true)
   public List<Productos> findByProductDto();
}
