package ms.tienda.controller;

import jakarta.validation.Valid;
import ms.tienda.entity.Inventario;
import ms.tienda.model.ResponseDelete;
import ms.tienda.model.ResponseInventario;
import ms.tienda.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class InventarioController {
    @Autowired
    private IInventarioService inventarioService;

    // Obtener todos los items de inventario
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/items")
    public List<ResponseInventario>readAll(){
        return inventarioService.readAll();
    }

    // Obtener item por Id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/item/{id}")
    public ResponseInventario readById(@PathVariable Double id){
        return inventarioService.readById(id);
    }

    // Crear un nuevo item
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/item")
    public Inventario insert(@RequestBody @Valid Inventario inventario){
        return inventarioService.insert(inventario);
    }

    // Editar registro de un item
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/item/{id}")
    public  Inventario update(@Valid @RequestBody Inventario inventario, @PathVariable Double id){
        return inventarioService.update(inventario);
    }

    // Eliminar un item
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/item/{id}")
    public ResponseDelete delete(@PathVariable Double id){
        return inventarioService.delete(id);
    }

}
