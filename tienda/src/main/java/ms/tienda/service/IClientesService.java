package ms.tienda.service;


import ms.tienda.entity.Clientes;
import java.util.List;
public interface IClientesService {
	public List<Clientes> readAll();
	
	public Clientes readById(Long id);
	
	public Clientes insert(Clientes clientes);
	
	public Clientes update(Clientes clientes);
	
	public void delete(Long id);

}
