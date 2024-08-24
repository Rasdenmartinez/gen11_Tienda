package ms.tienda.service;

import ms.tienda.entity.Proveedores;
import ms.tienda.model.ResponseContactos;
import ms.tienda.model.ResponseDelete;
import ms.tienda.model.ResponseProveedor;
import ms.tienda.model.ResponseProveedores;

import java.util.List;

public interface IProveedoresService {
    List<ResponseProveedores> readAll();

    public ResponseProveedor readById(Double id);

    public Proveedores insert(Proveedores proveedor);

    public Proveedores update(Proveedores proveedor);

    public ResponseDelete delete(Double id);

    public List<ResponseContactos> contactoProveedor(String contacto);


}
