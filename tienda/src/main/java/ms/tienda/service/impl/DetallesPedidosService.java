package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.DetallesPedido;
import ms.tienda.model.DetallePedidoDto;
import ms.tienda.model.DetallesSinJoin;
import ms.tienda.repository.DetallesPedidoRepository;
import ms.tienda.service.IDetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class DetallesPedidosService implements IDetallesPedidoService {
    @Autowired
    DetallesPedidoRepository detallesPedidoRepository;
    @Override
    public List<DetallesPedido> nomreadAll() {
        return detallesPedidoRepository.findAll().stream().filter(s -> s.getIsActive()==Constantes.Filtro).toList();
    }

    @Override
    public DetallesPedido readById(Integer id) {
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
        if(detallesPedidoOptional.isPresent() && detallesPedidoOptional.get().getIsActive()==Constantes.Filtro ){
            return detallesPedidoOptional.get();
        }
        return new DetallesPedido();
    }



    @Override
    public DetallesPedido insert(DetallesPedido detallesPedido) {
      detallesPedido.setIsActive(Constantes.Filtro);
        return detallesPedidoRepository.save(detallesPedido);
    }

    @Override
    public DetallesPedido update(DetallesPedido detallesPedido) {
        return detallesPedidoRepository.save(detallesPedido);
    }

    @Override
    public void delete(Integer id){ //todo Integrar response dto
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
        if(detallesPedidoOptional.isPresent()){
            DetallesPedido detallesPedido = detallesPedidoOptional.get();
            detallesPedido.setIsActive(Constantes.Filtro);
            log.info(" Dettalle de pedido {} deleted", id);
        }


    }

    @Override
    public List<DetallePedidoDto> responseDtallePedidoDto() {
         List<DetallesPedido> detallesPedidoList =  detallesPedidoRepository.findByIdDetallesPedidoProductoDto();
        return detallesPedidoList.stream().map(s->{
            DetallePedidoDto detallePedidoDto = new DetallePedidoDto();
            detallePedidoDto.setPedido(s.getIdPedido().getIdPedido());
            detallePedidoDto.setFechaPedido(s.getIdPedido().getFechaPedido());
            detallePedidoDto.setTotalPedido(s.getIdPedido().getTotalPedido());
            detallePedidoDto.setId(s.getId());
            detallePedidoDto.setFechaCreacion(s.getFechaCreacion());
            detallePedidoDto.setCantidad(s.getCantidad());
            detallePedidoDto.setProducto(s.getProducto().getId());
            detallePedidoDto.setName(s.getProducto().getName());
            detallePedidoDto.setDescripcionProducto(s.getProducto().getDescripcionProducto());


            return detallePedidoDto;
        }).toList();
    }

    @Override
    public List<DetallesSinJoin> findDettalleSmple() {
        List<DetallesPedido> detallesSimplelis = detallesPedidoRepository.finDetallesSimple();
        return detallesSimplelis.stream().map(s->{
            DetallesSinJoin detallesSinJoin = new DetallesSinJoin();
            detallesSinJoin.setId(s.getId());
            detallesSinJoin.setPrecioUnitario(s.getPrecioUnitario());
            detallesSinJoin.setCantidad(s.getCantidad());

            return detallesSinJoin;
        }).toList();

    }


}
