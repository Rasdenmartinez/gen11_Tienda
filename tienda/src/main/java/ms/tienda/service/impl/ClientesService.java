package ms.tienda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.ClientesConstantes;
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

}
