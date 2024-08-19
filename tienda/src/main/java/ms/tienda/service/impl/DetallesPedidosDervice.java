package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.DetallesPedido;
import ms.tienda.repository.DetallesPedidoRepository;
import ms.tienda.service.IDetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class DetallesPedidosDervice implements IDetallesPedidoService {
    @Autowired
    DetallesPedidoRepository detallesPedidoRepository;
    @Override
    public List<DetallesPedido> nomreadAll() {
        return detallesPedidoRepository.findAll().stream().filter(s -> s.getIs_Active()!= Constantes.Filtro).toList();
    }

    @Override
    public DetallesPedido readById(Long id){
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
        if(detallesPedidoOptional.isPresent() && detallesPedidoOptional.get().getIs_Active()!=Constantes.Filtro){
            return detallesPedidoOptional.get();
        }
        return new DetallesPedido();
    }

    @Override
    public DetallesPedido insert(DetallesPedido detallesPedido) {
      detallesPedido.setIs_Active(!Constantes.Filtro);
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
            detallesPedido.setIs_Active(Constantes.Filtro);
            log.info(" Dettalle de pedido {} deleted", id);
        }


    }
}
