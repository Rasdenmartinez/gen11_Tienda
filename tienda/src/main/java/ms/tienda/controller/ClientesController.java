package ms.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.tienda.dto.ClienteEmpleadoDTO;
import ms.tienda.entity.Clientes;
import ms.tienda.service.IClientesService;

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
    
    @GetMapping("/salario")
    public List<Clientes> findBySalario(@RequestParam Double salario) {
        return clientesService.findBySalario(salario);
    }
    
    @GetMapping("/clientes-con-empleados")
    public List<ClienteEmpleadoDTO> getClientesConEmpleados(@RequestParam Double salario) {
        return clientesService.getClientesWithEmpleadoBySalario(salario);
    }
 
}
