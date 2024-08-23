package ms.tienda.repository;
import ms.tienda.entity.Empleados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados,Long> {
	@Query(value="select e.* from empleados e inner join proveedores p on e.proveedor_id = p.id;",
			nativeQuery=true)
	List<Empleados> findByEmpleadosProveedore();

}
