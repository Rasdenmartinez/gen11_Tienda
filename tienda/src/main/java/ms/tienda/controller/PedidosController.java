package ms.tienda.controller;

import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
import ms.tienda.model.PedidosDto;
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
    @GetMapping("/allPedidos")
    public List<Pedidos> nomreadAll() { return pedidosService.nomreadAll();
    }

    @GetMapping("/pedidosId/{id}")
    public Pedidos readById(@PathVariable Integer idPedido) { return pedidosService.readById(idPedido);
    }

    @PostMapping("/pedidosInsert")
    public Pedidos insert(@RequestBody Pedidos pedidos) {
        return pedidosService.insert(pedidos);

    }

    @PutMapping("/pedidosUpdate")
    public Pedidos update(@RequestBody Pedidos pedidos) {
        return pedidosService.update(pedidos);
    }

    @DeleteMapping("pedidosDelete/{id}")
    public void delete(@PathVariable Integer idPedido) { pedidosService.delete(idPedido);

    }
    @GetMapping("pedidosDto")
    public List<PedidosDto> findByPedidosDto(){
        return pedidosService.findByPedidosDto();
    }

}
