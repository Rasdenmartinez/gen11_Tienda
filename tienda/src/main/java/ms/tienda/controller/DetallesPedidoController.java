package ms.tienda.controller;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Pedidos;
import ms.tienda.service.IDetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class DetallesPedidoController {
    @Autowired
    private IDetallesPedidoService iDetallesPedidoService;
    //CRUD - Create, Read, Update, Delete;
    @GetMapping("/detalles_pedido")
    public List<DetallesPedido> nomreadAll() { return iDetallesPedidoService.nomreadAll();
    }

    @GetMapping("/detalles_pedido/{id}")
    public DetallesPedido readById(@PathVariable Long id) { return iDetallesPedidoService.readById(id);
    }

    @PostMapping("/detalles_pedido")
    public DetallesPedido insert(@RequestBody DetallesPedido detallesPedido) {
        return iDetallesPedidoService.insert(detallesPedido);

    }

    @PutMapping("/detalles_pedido")
    public DetallesPedido update(@RequestBody DetallesPedido detallesPedido) {
        return iDetallesPedidoService.update(detallesPedido);
    }
    @DeleteMapping("detalles_pedido/{id}")
    public void delete(@PathVariable Long id) { iDetallesPedidoService.delete(id);
    }



}
