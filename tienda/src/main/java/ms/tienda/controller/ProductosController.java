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
    private IProductosService iProductosService;

    @GetMapping("/productos")
    public List<Productos>readAll(){
        return iProductosService.readAll();
    }

    @GetMapping("/producto/{id}")
    public  Productos readById(@PathVariable Double id) {
        return iProductosService.readById(id);
    }

    @PostMapping("/producto")
    public  Productos insert(@RequestBody Productos producto){
        return iProductosService.insert(producto);
    }

    @PutMapping("/producto/{id}")
    public  Productos update(@RequestBody Productos producto, @PathVariable Double id){
        return iProductosService.update(producto);
    }

    @DeleteMapping("/producto/{id}")
    public void delete(Double id){
        iProductosService.delete(id);
    }

}
