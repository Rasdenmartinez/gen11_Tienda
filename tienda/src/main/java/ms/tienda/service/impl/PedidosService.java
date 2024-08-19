package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Pedidos;
import ms.tienda.repository.PedidosRepository;
import ms.tienda.service.IPedidosService;
import ms.tienda.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class PedidosService implements IPedidosService {
    @Autowired
    PedidosRepository pedidosRepository;
    @Override
    public List<Pedidos> nomreadAll() {

        return pedidosRepository.findAll().stream().filter(s-> s.getIs_Active()!= Constantes.Filtro).toList() ;
    }

    @Override
    public Pedidos readById(Long id){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
        if(pedidosOptional.isPresent() && pedidosOptional.get().getIs_Active()!=Constantes.Filtro){
           return pedidosOptional.get();
        }
        return new Pedidos();
    }

    @Override
    public Pedidos insert(Pedidos pedidos) {
        pedidos.setIs_Active(!Constantes.Filtro);
        return pedidosRepository.save(pedidos);
    }

    @Override
    public Pedidos update(Pedidos pedidos) {

        return pedidosRepository.save(pedidos);
    }

    @Override
    public void delete(Long id){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
        if(pedidosOptional.isPresent()){
            Pedidos pedidos = pedidosOptional.get();
            pedidos.setIs_Active(Constantes.Filtro);
            pedidosRepository.save(pedidos);
            log.info(" Pedido {} deleted", id);
        }
        {log.error("El id departamento no existe");}
    }
}
