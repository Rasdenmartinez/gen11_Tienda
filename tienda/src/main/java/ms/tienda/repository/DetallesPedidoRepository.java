package ms.tienda.repository;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.model.DetallePedidoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido, Long> {
  /*  @Query(value = "select de.id, de.nombre, pe.edad, pe.domicilio, pe.departamento_id, pe.is_active, pe.fecha_creacion from persona pe\n" +
            "inner join departamento de on pe.departamento_id = de.id \n" +"where pe.nombre = :nombre", nativeQuery = true)
return*/
  List<DetallePedidoDto> obtederDatosPersonDepto(String nombre);
}
