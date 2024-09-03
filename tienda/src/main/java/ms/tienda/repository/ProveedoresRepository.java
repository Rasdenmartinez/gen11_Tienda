package ms.tienda.repository;

import ms.tienda.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores,Double> {
    @Query(value =
            "SELECT p.id, p.nombre_empresa, p.contacto, p.correo, p.telefono, p.is_active FROM proveedores p WHERE p.contacto LIKE :contacto ",nativeQuery = true)
    List<Proveedores> findByNombreContacto(@Param("contacto") String contacto);
}
