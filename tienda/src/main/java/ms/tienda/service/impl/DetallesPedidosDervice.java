package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.DetallesPedido;
import ms.tienda.model.DetallePedidoDto;
import ms.tienda.repository.DetallesPedidoRepository;
import ms.tienda.service.IDetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class DetallesPedidosDervice implements IDetallesPedidoService {
    @Autowired
    DetallesPedidoRepository detallesPedidoRepository;
    @Override
    public List<DetallesPedido> nomreadAll() {
        return detallesPedidoRepository.findAll().stream().filter(s -> s.getIsActive()!= Constantes.Filtro).toList();
    }

    @Override
    public DetallesPedido readById(Long id){
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
        if(detallesPedidoOptional.isPresent() && detallesPedidoOptional.get().getIsActive()!=Constantes.Filtro){
            return detallesPedidoOptional.get();
        }
        return new DetallesPedido();
    }

    @Override
    public DetallesPedido insert(DetallesPedido detallesPedido) {
      detallesPedido.setIsActive(!Constantes.Filtro);
        return detallesPedidoRepository.save(detallesPedido);
    }

    @Override
    public DetallesPedido update(DetallesPedido detallesPedido) {
        return detallesPedidoRepository.save(detallesPedido);
    }

    @Override
    public void delete(Long id){
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
        if(detallesPedidoOptional.isPresent()){
            DetallesPedido detallesPedido = detallesPedidoOptional.get();
            detallesPedido.setIsActive(Constantes.Filtro);
            log.info(" Dettalle de pedido {} deleted", id);
        }


    }

    @Override
    public List<DetallePedidoDto> responseDtallePedidoDto(Double id, String name,
                                                          String descripcionProducto,
                                                          Double precio, LocalDateTime fechaPedido,
                                                          Double totalPedido)
    {
        return List.of();
    }
}
