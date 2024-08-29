package ms.tienda.service;


import java.util.List;

import ms.tienda.dto.ClienteEmpleadoDTO;
import ms.tienda.entity.Clientes;
import ms.tienda.model.ClientesResponse;
public interface IClientesService {
	public List<Clientes> readAll();
	
	public Clientes readById(Long id);
	
	public Clientes insert(Clientes clientes);
	
	public Clientes update(Clientes clientes);
	
	public void delete(Long id);

	public List<Clientes> findBySalario(Double salario);

	public List<ClienteEmpleadoDTO> getClientesWithEmpleadoBySalario(Double salario);

	public ClientesResponse leerTodo();

}
