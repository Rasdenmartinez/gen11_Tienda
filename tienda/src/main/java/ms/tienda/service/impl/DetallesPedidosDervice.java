package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.DetallesPedido;
<<<<<<< HEAD
=======
import ms.tienda.model.DetallePedidoDto;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
import ms.tienda.repository.DetallesPedidoRepository;
import ms.tienda.service.IDetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.time.LocalDateTime;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class DetallesPedidosDervice implements IDetallesPedidoService {
    @Autowired
    DetallesPedidoRepository detallesPedidoRepository;
    @Override
    public List<DetallesPedido> nomreadAll() {
<<<<<<< HEAD
        return detallesPedidoRepository.findAll().stream().filter(s -> s.getIs_Active()!= Constantes.Filtro).toList();
=======
        return detallesPedidoRepository.findAll().stream().filter(s -> s.getIsActive()!= Constantes.Filtro).toList();
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
    }

    @Override
    public DetallesPedido readById(Long id){
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
<<<<<<< HEAD
        if(detallesPedidoOptional.isPresent() && detallesPedidoOptional.get().getIs_Active()!=Constantes.Filtro){
=======
        if(detallesPedidoOptional.isPresent() && detallesPedidoOptional.get().getIsActive()!=Constantes.Filtro){
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
            return detallesPedidoOptional.get();
        }
        return new DetallesPedido();
    }

    @Override
    public DetallesPedido insert(DetallesPedido detallesPedido) {
<<<<<<< HEAD
      detallesPedido.setIs_Active(!Constantes.Filtro);
=======
      detallesPedido.setIsActive(!Constantes.Filtro);
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
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
<<<<<<< HEAD
            detallesPedido.setIs_Active(Constantes.Filtro);
=======
            detallesPedido.setIsActive(Constantes.Filtro);
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
            log.info(" Dettalle de pedido {} deleted", id);
        }


    }
<<<<<<< HEAD
=======

    @Override
    public List<DetallePedidoDto> responseDtallePedidoDto(Double id, String name,
                                                          String descripcionProducto,
                                                          Double precio, LocalDateTime fechaPedido,
                                                          Double totalPedido)
    {
        return List.of();
    }
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
}
