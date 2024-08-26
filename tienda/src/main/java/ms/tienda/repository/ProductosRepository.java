package ms.tienda.repository;

import ms.tienda.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface ProductosRepository extends JpaRepository<Productos, Long> {
=======
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProductosRepository extends JpaRepository<Productos, Long> {
   public List<Productos> findByNameAndPrecio(String nombreProducto, Double precio);
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
}
