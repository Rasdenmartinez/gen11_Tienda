package ms.tienda.controller;

import ms.tienda.ConstantesCarlos.Constantes;
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
    public List<Pedidos> nomreadAll() { return pedidosService.nomreadAll().stream().filter(s->s.getIsActive()== Constantes.Filtro).toList();
    }

    @GetMapping("/pedidosId/{id}")
    public Pedidos readById(@PathVariable Double id) { return pedidosService.readById(id);
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
    public void delete(@PathVariable Double id) { pedidosService.pedidoDeleteDto(id);

    }
    @GetMapping("finByClienteId/{id}")
    public List<PedidosDto> findByClienteId(@PathVariable Long id){
        return pedidosService.findClienteById(id);
    }

    @GetMapping("pedidosDto")
    public List<PedidosDto> findByPedidosDto(){
        return pedidosService.findByPedidosDto();
    }

}
