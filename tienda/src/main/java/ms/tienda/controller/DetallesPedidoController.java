package ms.tienda.controller;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
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

    @GetMapping("/detallesDetalle/{id}")
    public DetallesPedido readById(@PathVariable Double id) { return iDetallesPedidoService.readById(id);
    }

    @PostMapping("/crearDetalle")
    public DetallesPedido insert(@RequestBody DetallesPedido detallesPedido) {
        return iDetallesPedidoService.insert(detallesPedido);
    }

    @PutMapping("/actualizarDetalle")
    public DetallesPedido update(@RequestBody DetallesPedido detallesPedido) {
        return iDetallesPedidoService.update(detallesPedido);
    }
    @DeleteMapping("eliminarDetalle/{id}")
    public void delete(@PathVariable Double id) { iDetallesPedidoService.detalleDeleteDto(id);
    }

    @GetMapping("/dtailDto")
    public List<DetallePedidoDto> findDetallesPedidoProductoDto() {
        return iDetallesPedidoService.responseDtallePedidoDto();

    }
    @GetMapping("detalleSimple")
    public List<DetallesSinJoin> findDettalleSmple() {
        return iDetallesPedidoService.findDettalleSmple();
    }





}
