package ms.tienda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.ClientesConstantes;
import ms.tienda.dto.ClienteEmpleadoDTO;
import ms.tienda.entity.Clientes;
import ms.tienda.repository.ClientesRepository;
import ms.tienda.service.IClientesService;

@Service
@Slf4j
public class ClientesService implements IClientesService {
    @Autowired
    ClientesRepository clientesRepository;
    @Override
    public List<Clientes> readAll() {

        return clientesRepository.findAll().stream().filter(s->s.getIsActive()!= ClientesConstantes.Filtrado).toList();
    }

    @Override
    public Clientes readById(Long id) {
        Optional<Clientes> clientesOptional=clientesRepository.findById(id);
        if(clientesOptional.isPresent() && clientesOptional.get().getIsActive()!=ClientesConstantes.Filtrado){
            return clientesOptional.get();
        }else{
            return new Clientes();
        }
    }

    @Override
    public Clientes insert(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    public Clientes update(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    public void delete(Long id) {
            Optional<Clientes> clientesOptional=clientesRepository.findById(id);
            if(clientesOptional.isPresent()){

            	Clientes clientes=clientesOptional.get();
            	clientes.setIsActive(false);
                clientesRepository.save(clientes);
                log.info("Cliente {} deleted", id);
            }else{
                log.error("El id de cliente no existe");
            }
    }
    
   //CONSULTAR TODOS LOS REGISTROS
    @Override
    public List<Clientes> findBySalario(Double salario) {
      return clientesRepository.findByIdEmpleadoSalarioLessThanEqual(salario);
    }
    

    //CONSULTAR LOS REGISTROS QUE SE MENCIONAN A PARTIR DE EMPLEADOS
    @Override
    public List<ClienteEmpleadoDTO> getClientesWithEmpleadoBySalario(Double salario){
    	List<Clientes> clientesList = clientesRepository.getClientesEmpleadosS(salario);
    	return clientesList.stream().map(s->{
    		ClienteEmpleadoDTO responseClientes = new ClienteEmpleadoDTO();
    		responseClientes.setIdCliente(s.getId());
    		responseClientes.setNombreCliente(s.getNombre());
    		responseClientes.setIdEmpleado(s.getIdEmpleado().getId());
    		responseClientes.setNombreEmpleado(s.getIdEmpleado().getNombre());
    		responseClientes.setPuesto(s.getIdEmpleado().getPuesto());
    		responseClientes.setSalario(s.getIdEmpleado().getSalario());
    		
    		return responseClientes;

    	}).toList();
    }

    
}
