package ms.tienda.controller;

import ms.tienda.entity.Proveedores;
import ms.tienda.model.ResponseContactos;
import ms.tienda.model.ResponseDelete;
import ms.tienda.model.ResponseProveedor;
import ms.tienda.model.ResponseProveedores;
import ms.tienda.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class ProveedoresController {
    @Autowired
    private IProveedoresService proveedoresService;

    // Obtener todos los proveedores
    @GetMapping("/proveedores")
    public List<ResponseProveedores>readAll(){
        return proveedoresService.readAll();
    }

    // Obtener proveedor por Id
    @GetMapping("/proveedor/{id}")
    public ResponseProveedor readById(@PathVariable Double id){
        return proveedoresService.readById(id);
    }

    // Crear un nuevo proveedor
    @PostMapping("/proveedor")
    public Proveedores insert(@RequestBody Proveedores proveedor){
        return proveedoresService.insert(proveedor);
    }

    // Editar un proveedor
    @PutMapping("/proveedor")
    public Proveedores update(@RequestBody Proveedores proveedor){
        return proveedoresService.update(proveedor);
    }

    // Eliminar un proveedor
    @DeleteMapping("/proveedor/{id}")
    public ResponseDelete delete(@PathVariable Double id){
        return proveedoresService.delete(id);
    }

    // Query
    @GetMapping("/proveedores/contacto")
    public List<ResponseContactos> contacto(@RequestParam String contacto){
        return proveedoresService.contactoProveedor(contacto);
    }
}
