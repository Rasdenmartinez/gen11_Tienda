package ms.tienda.repository;

import ms.tienda.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores,Double> {
    List<Proveedores> findByContacto(String contacto);
}
