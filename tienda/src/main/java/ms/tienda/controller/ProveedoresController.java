package ms.tienda.controller;

import jakarta.validation.Valid;
import ms.tienda.entity.Proveedores;
import ms.tienda.model.ResponseContactos;
import ms.tienda.model.ResponseDelete;
import ms.tienda.model.ResponseProveedor;
import ms.tienda.model.ResponseProveedores;
import ms.tienda.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class ProveedoresController {
    @Autowired
    private IProveedoresService proveedoresService;

    // Obtener todos los proveedores
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/proveedores")
    public List<ResponseProveedores>readAll(){
        return proveedoresService.readAll();
    }

    // Obtener proveedor por Id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/proveedor/{id}")
    public ResponseProveedor readById(@PathVariable Double id){
        return proveedoresService.readById(id);
    }

    // Crear un nuevo proveedor
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/proveedor")
    public Proveedores insert(@RequestBody @Valid Proveedores proveedor){
        return proveedoresService.insert(proveedor);
    }

    // Editar un proveedor
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/proveedor/{id}")
    public Proveedores update(@RequestBody @Valid Proveedores proveedor, @PathVariable Double id){
        return proveedoresService.update(proveedor);
    }

    // Eliminar un proveedor
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/proveedor/{id}")
    public ResponseDelete delete(@PathVariable Double id){
        return proveedoresService.delete(id);
    }

     // Encontrar contacto por nombre
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/proveedores/contactos")
    public List<ResponseContactos>proveedores(@RequestParam String contacto){
        return proveedoresService.findByNombreContacto(contacto);
    }
}
