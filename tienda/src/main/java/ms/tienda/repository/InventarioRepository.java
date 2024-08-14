package ms.tienda.repository;

import ms.tienda.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario,Long> {
}
