package ms.tienda.controller;

import ms.tienda.entity.Proveedores;
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
    public List<Proveedores>readAll(){
        return proveedoresService.readAll();
    }

    // Obtener proveedor por Id
    @GetMapping("/proveedor/{id}")
    public Proveedores readById(@PathVariable Long id){
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
    public void delete(@PathVariable Long id){
        proveedoresService.delete(id);
    }

}
