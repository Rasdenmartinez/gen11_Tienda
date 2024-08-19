package ms.tienda.repository;

import ms.tienda.entity.DetallesPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido, Long> {
}
