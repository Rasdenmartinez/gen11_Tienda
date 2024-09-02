package ms.tienda.controller;

import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Productos;
import ms.tienda.model.ProductosDto;
import ms.tienda.service.IProductosService;
import ms.tienda.service.impl.MiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tienda")
public class ProductosController {
   @Autowired
private IProductosService productosService;

    //CRUD - Create, Read, Update, Delete;
    @GetMapping("/allProducts")
    public List<Productos> nomreadAll() throws MiException {
        return productosService.readAll();
    }

    @GetMapping("/productById/{id}")
    public Productos readById(@PathVariable Double id) throws MiException {
     return productosService.readById(id);
    }

    @PostMapping("/insert")
    public Productos insert(@RequestBody Productos productos) throws MiException {
        return productosService.insert(productos);
    }

    @PutMapping("/update")
    public Productos update(@RequestBody Productos productos) throws MiException {
        return productosService.update(productos);
    }

    @DeleteMapping("deleteProducto/{id}")
    public String responceDelete(@PathVariable Double id) throws MiException {
        return productosService.productoDeleteDto(id);
    }


   @GetMapping("namePrice")
    public List<Productos> findByNamePrecio(@RequestParam String name, @RequestParam Double precio) throws MiException {

        return productosService.NamePrecio(name, precio);
   }
   @GetMapping("productosDto")
    public List<ProductosDto> findByProductDto() throws MiException {
        return productosService.responseProductoByDto();
    }

}
