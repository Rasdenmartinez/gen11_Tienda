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
    @GetMapping("/allProducts")
    public List<Productos> nomreadAll() {
        return productosService.nomreadAll();
    }

    @GetMapping("/productById/{id}")
    public Productos readById(@PathVariable Long id) {
        return productosService.readById(id);
    }

    @PostMapping("/capture")
    public Productos insert(@RequestBody Productos productos) {
        return productosService.insert(productos);

    }

    @PutMapping("/update")
    public Productos update(@RequestBody Productos productos) {
        return productosService.update(productos);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        productosService.delete(id);
    }


   @GetMapping("namePrice")
    public List<Productos> findByNamePrecio(@RequestParam String name, @RequestParam Double precio){

        return productosService.NamePrecio(name, precio);
   }


}
