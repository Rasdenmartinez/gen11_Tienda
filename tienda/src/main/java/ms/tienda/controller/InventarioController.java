package ms.tienda.controller;

import ms.tienda.entity.Inventario;
import ms.tienda.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class InventarioController {
    @Autowired
    private IInventarioService inventarioService;

    // Obtener todos los items de inventario
    @GetMapping("/items")
    public List<Inventario>readAll(){
        return inventarioService.readAll();
    }

    // Obtener item por Id
    @GetMapping("/item/{id}")
    public Inventario readById(@PathVariable Long id){
        return inventarioService.readById(id);
    }

    // Crear un nuevo item
    @PostMapping("/item")
    public Inventario insert(@RequestBody Inventario inventario){
        return inventarioService.insert(inventario);
    }

    // Editar registro de un item
    @PutMapping("/item")
    public  Inventario update(@RequestBody Inventario inventario){
        return inventarioService.update(inventario);
    }

    // Eliminar un item
    @DeleteMapping("/item/{id}")
    public void delete(@PathVariable Long id){
        inventarioService.delete(id);
    }

}
