package ms.tienda.service;


import ms.tienda.entity.Empleados;
import java.util.List;


public interface IEmpleadosService {

	public List<Empleados> readAll();
	
	public Empleados readById(Long id);
	
	public Empleados insert(Empleados empleados);
	
	public Empleados update(Empleados empleados);
	
	public void delete(Long id);
	
}
