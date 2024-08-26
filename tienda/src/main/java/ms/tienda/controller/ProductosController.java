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
<<<<<<< HEAD
    @GetMapping("/persona")
=======
    @GetMapping("/allProducts")
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
    public List<Productos> nomreadAll() {
        return productosService.nomreadAll();
    }

<<<<<<< HEAD
    @GetMapping("/productos/{id}")
=======
    @GetMapping("/productById/{id}")
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
    public Productos readById(@PathVariable Long id) {
        return productosService.readById(id);
    }

<<<<<<< HEAD
    @PostMapping("/persona")
    public Productos insert(@RequestBody Productos persona) {
        return productosService.insert(persona);

    }

    @PutMapping("/persona")
    public Productos update(@RequestBody Productos productos) {
        return productosService.update(productos);
    }
    @DeleteMapping("productos/{id}")
=======
    @PostMapping("/capture")
    public Productos insert(@RequestBody Productos productos) {
        return productosService.insert(productos);

    }

    @PutMapping("/update")
    public Productos update(@RequestBody Productos productos) {
        return productosService.update(productos);
    }

    @DeleteMapping("delete/{id}")
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
    public void delete(@PathVariable Long id) {
        productosService.delete(id);
    }


<<<<<<< HEAD
=======
   @GetMapping("namePrice")
    public List<Productos> findByNamePrecio(@RequestParam String name, @RequestParam Double precio){

        return productosService.NamePrecio(name, precio);
   }

>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4

}
