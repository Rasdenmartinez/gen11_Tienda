package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Pedidos;
import ms.tienda.model.PedidosDto;
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

        return pedidosRepository.findAll().stream().filter(s-> s.getIsActive()== Constantes.Filtro).toList() ;
    }

    @Override
    public Pedidos readById(Integer idPedido){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(idPedido);
        if(pedidosOptional.isPresent() && pedidosOptional.get().getIsActive()==Constantes.Filtro){
           return pedidosOptional.get();
        }
        return new Pedidos();
    }

    @Override
    public Pedidos insert(Pedidos pedidos) {
        pedidos.setIsActive(Constantes.Filtro);
        return pedidosRepository.save(pedidos);
    }

    @Override
    public Pedidos update(Pedidos pedidos) {

        return pedidosRepository.save(pedidos);
    }

    @Override
    public void delete(Integer idPedido){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(idPedido);
        if(pedidosOptional.isPresent()){
            Pedidos pedidos = pedidosOptional.get();
            pedidos.setIsActive(Constantes.Filtro);
            pedidosRepository.save(pedidos);
            log.info(" Pedido {} deleted", idPedido);
        }
        {log.error("El id departamento no existe");}
    }

    @Override
    public List<PedidosDto> findByPedidosDto() {
       List<Pedidos> pedidosList =  pedidosRepository.findByPedidosDto();
       return pedidosList.stream().map(s->{
       PedidosDto pedidosDto =new PedidosDto();
       pedidosDto.setIdPedido(s.getIdPedido());
       pedidosDto.setFechaPedido(s.getFechaPedido());
       pedidosDto.setTotalPedido(s.getTotalPedido());
       pedidosDto.setClientesId(s.getClientesId().getId());
       pedidosDto.setNombre(s.getClientesId().getNombre());
     return pedidosDto;
        }).toList();
    }
}
