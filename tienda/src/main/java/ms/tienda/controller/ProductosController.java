package ms.tienda.controller;

import ms.tienda.entity.Productos;
import ms.tienda.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class ProductosController {
   @Autowired
private IProductosService productosService;

    //CRUD - Create, Read, Update, Delete;
    @GetMapping("/persona")
    public List<Productos> nomreadAll() {
        return productosService.nomreadAll();
    }

    @GetMapping("/productos/{id}")
    public Productos readById(@PathVariable Long id) {
        return productosService.readById(id);
    }

    @PostMapping("/persona")
    public Productos insert(@RequestBody Productos persona) {
        return productosService.insert(persona);

    }

    @PutMapping("/persona")
    public Productos update(@RequestBody Productos productos) {
        return productosService.update(productos);
    }
    @DeleteMapping("productos/{id}")
    public void delete(@PathVariable Long id) {
        productosService.delete(id);
    }



}
