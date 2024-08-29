package ms.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import feign.Param;
import ms.tienda.dto.ClienteEmpleadoDTO;
import ms.tienda.entity.Clientes;

import java.util.List;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    List<Clientes> findByIdEmpleadoSalarioLessThanEqual(Double salario);
    
    @Query(value="SELECT c.id,c.nombre,c.apellido,c.direccion,c.correo_electronico,c.telefono,c.empleado_id,c.is_active,c.create_date ,c.update_date FROM clientes c INNER JOIN empleados e ON c.empleado_id = e.id WHERE e.salario <= :salario;",
    		nativeQuery=true)
 	List<Clientes> getClientesEmpleadosS(Double salario);

}

