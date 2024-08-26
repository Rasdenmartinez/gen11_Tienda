package ms.tienda.controller;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Pedidos;
import ms.tienda.model.DetallePedidoDto;
import ms.tienda.model.DetallesSinJoin;
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
    @GetMapping("/allDetails")
    public List<DetallesPedido> nomreadAll() { return iDetallesPedidoService.nomreadAll();
    }

    @GetMapping("/detallesPedido/{id}")
    public DetallesPedido readById(@PathVariable Integer id) { return iDetallesPedidoService.readById(id);
    }

    @PostMapping("/crear")
    public DetallesPedido insert(@RequestBody DetallesPedido detallesPedido) {
        return iDetallesPedidoService.insert(detallesPedido);

    }

    @PutMapping("/actualizar")
    public DetallesPedido update(@RequestBody DetallesPedido detallesPedido) {
        return iDetallesPedidoService.update(detallesPedido);
    }
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Integer id) { iDetallesPedidoService.delete(id);
    }

    @GetMapping("/dtailDto")
    public List<DetallePedidoDto> responseDtallePedidoDto() {
        return iDetallesPedidoService.responseDtallePedidoDto();

    }
    @GetMapping("detalleSimple")
    public List<DetallesSinJoin> findDettalleSmple() {
        return iDetallesPedidoService.findDettalleSmple();
    }





}
