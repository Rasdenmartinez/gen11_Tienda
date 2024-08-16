package ms.tienda.service;

import ms.tienda.entity.Proveedores;

import java.util.List;

public interface IProveedoresService {
    public List<Proveedores> readAll();

    public Proveedores readById(Double id);

    public Proveedores insert(Proveedores proveedor);

    public Proveedores update(Proveedores proveedor);

    public void delete(Double id);

}
