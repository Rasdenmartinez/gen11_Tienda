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
import org.springframework.web.bind.annotation.RestController;

import ms.tienda.entity.Empleados;
import ms.tienda.service.IEmpleadosService;

@RestController
@RequestMapping("/api/v1")
public class EmpleadosController {
    @Autowired
    private IEmpleadosService empleadosService;

    //CRUD - Create, Read, Update, Delete;
    @GetMapping("/empleados")
    public List<Empleados> readAll() {
        return empleadosService.readAll();
    }

    @GetMapping("/empleados/{id}")
    public Empleados readById(@PathVariable Long id) {
        return empleadosService.readById(id);
    }

    @PostMapping("/empleados")
    public Empleados insert(@RequestBody Empleados empleados) {
        return empleadosService.insert(empleados);

    }
    
    @PutMapping("/empleados")
    public Empleados update(@RequestBody Empleados empleados) {
        return empleadosService.update(empleados);
    }
    @DeleteMapping("empleados/{id}")
    public void delete(@PathVariable Long id) {
        empleadosService.delete(id);
    }

}
