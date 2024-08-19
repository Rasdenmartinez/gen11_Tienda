package ms.tienda.controller;

import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
import ms.tienda.service.IPedidosService;
import ms.tienda.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class PedidosController {
    @Autowired
    private IPedidosService pedidosService;

    //CRUD - Create, Read, Update, Delete;
    @GetMapping("/pedidos")
    public List<Pedidos> nomreadAll() { return pedidosService.nomreadAll();
    }

    @GetMapping("/pedidos/{id}")
    public Pedidos readById(@PathVariable Long id) { return pedidosService.readById(id);
    }

    @PostMapping("/pedidos")
    public Pedidos insert(@RequestBody Pedidos pedidos) {
        return pedidosService.insert(pedidos);

    }

    @PutMapping("/pedidos")
    public Pedidos update(@RequestBody Pedidos pedidos) {
        return pedidosService.update(pedidos);
    }
    @DeleteMapping("pedidos/{id}")
    public void delete(@PathVariable Long id) { pedidosService.delete(id);
    }

}
