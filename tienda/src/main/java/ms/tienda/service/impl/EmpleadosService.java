package ms.tienda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.EmpleadosConstantes;
import ms.tienda.dto.EmpleadoProveedorDTO;
import ms.tienda.entity.Empleados;
import ms.tienda.repository.EmpleadosRepository;
import ms.tienda.service.IEmpleadosService;

@Service
@Slf4j
public class EmpleadosService implements IEmpleadosService {
    @Autowired
    EmpleadosRepository empleadosRepository;
    @Override
    public List<Empleados> readAll() {

        return empleadosRepository.findAll().stream().filter(s->s.getIsActive()!= EmpleadosConstantes.Filtrado).toList();
    }

    @Override
    public Empleados readById(Long id) {
        Optional<Empleados> empleadosOptional=empleadosRepository.findById(id);
        if(empleadosOptional.isPresent() && empleadosOptional.get().getIsActive()!=EmpleadosConstantes.Filtrado){
            return empleadosOptional.get();
        }else{
            return new Empleados();
        }
    }

    @Override
    public Empleados insert(Empleados Empleados) {
        return empleadosRepository.save(Empleados);
    }

    @Override
    public Empleados update(Empleados Empleados) {
        return empleadosRepository.save(Empleados);
    }

    @Override
    public void delete(Long id) {
            Optional<Empleados> empleadosOptional=empleadosRepository.findById(id);
            if(empleadosOptional.isPresent()){

            	Empleados empleados=empleadosOptional.get();
            	empleados.setIsActive(false);
                empleadosRepository.save(empleados);
                log.info("Empleado {} deleted", id);
            }else{
                log.error("El id de Empleado no existe");
            }
    }

	@Override
	public List<EmpleadoProveedorDTO> findByEmpleadosProveedores() {
		
		List<Empleados> empleadosList = empleadosRepository.findByEmpleadosProveedore();
		return empleadosList.stream().map(s->{
			EmpleadoProveedorDTO responseEmpleados = new EmpleadoProveedorDTO();
			responseEmpleados.setIdEmpleado(s.getId());
			responseEmpleados.setNombreEmpleado(s.getNombre());
			responseEmpleados.setApellidoEmpleado(s.getApellido());
			responseEmpleados.setPuesto(s.getPuesto());
			responseEmpleados.setIdProveedor(s.getIdProveedor().getId());
			responseEmpleados.setNombreEmpresa(s.getIdProveedor().getNombreEmpresa());
			responseEmpleados.setContacto(s.getIdProveedor().getContacto());
			responseEmpleados.setTelefono(s.getIdProveedor().getTelefono());
			
			return 	responseEmpleados;
		}).toList();
	
	}

}
