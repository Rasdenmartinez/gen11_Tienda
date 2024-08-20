package ms.tienda.controller;

import ms.tienda.entity.Clientes;
import ms.tienda.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientesController {
    @Autowired
    private IClientesService clientesService;

    //CRUD - Create, Read, Update, Delete;
    @GetMapping("/clientes")
    public List<Clientes> readAll() {
        return clientesService.readAll();
    }

    @GetMapping("/clientes/{id}")
    public Clientes readById(@PathVariable Long id) {
        return clientesService.readById(id);
    }

    @PostMapping("/clientes")
    public Clientes insert(@RequestBody Clientes Clientes) {
        return clientesService.insert(Clientes);

    }

    @PutMapping("/clientes")
    public Clientes update(@RequestBody Clientes Clientes) {
        return clientesService.update(Clientes);
    }
    @DeleteMapping("clientes/{id}")
    public void delete(@PathVariable Long id) {
        clientesService.delete(id);
    }
 
}
