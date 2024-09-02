package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
import ms.tienda.model.DeleteDto;
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
    public Pedidos readById(Double id){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
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
    public List<PedidosDto> findClienteById(Long id) {
        List<Pedidos> pedidosList =  pedidosRepository.findByClienteId(id);
        return pedidosList.stream().map(s->{
            PedidosDto pedidosDto =new PedidosDto();
            pedidosDto.setIdPedido(s.getIdPedido());
            pedidosDto.setFechaPedido(s.getFechaPedido());
            pedidosDto.setTotalPedido(s.getTotalPedido());
            pedidosDto.setClientesId(s.getCliente().getId());
            pedidosDto.setNombre(s.getCliente().getNombre());
            pedidosDto.setApellido(s.getCliente().getApellido());
            return pedidosDto;
        }).toList();
    }


    @Override
    public String pedidoDeleteDto(Double id){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
        if(pedidosOptional.isPresent()){
            Pedidos pedidos = pedidosOptional.get();
            pedidos.setIsActive(!Constantes.Filtro);
            pedidosRepository.save(pedidos);

        }
        DeleteDto deleteDto = new DeleteDto();
        return deleteDto.getMensajePedido();

    }



    @Override
    public List<PedidosDto> findByPedidosDto() {
       List<Pedidos> pedidosList =  pedidosRepository.findByPedidosDto();
       return pedidosList.stream().map(s->{
       PedidosDto pedidosDto =new PedidosDto();
       pedidosDto.setIdPedido(s.getIdPedido());
       pedidosDto.setFechaPedido(s.getFechaPedido());
       pedidosDto.setTotalPedido(s.getTotalPedido());
       pedidosDto.setClientesId(s.getCliente().getId());
       pedidosDto.setNombre(s.getCliente().getNombre());
       pedidosDto.setApellido(s.getCliente().getApellido());
     return pedidosDto;
        }).toList();
    }
}
