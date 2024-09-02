package ms.tienda.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import ms.tienda.ConstantesCarlos.Constantes;
import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
import ms.tienda.model.DeleteDto;
import ms.tienda.model.DetallePedidoDto;
import ms.tienda.model.DetallesSinJoin;
import ms.tienda.repository.DetallesPedidoRepository;
import ms.tienda.repository.PedidosRepository;
import ms.tienda.repository.ProductosRepository;
import ms.tienda.service.IDetallesPedidoService;
import ms.tienda.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class DetallesPedidosService implements IDetallesPedidoService {
    @Autowired
    DetallesPedidoRepository detallesPedidoRepository;
    @Autowired
    PedidosRepository pedidosRepository;
    //@Autowired
  //  ProductosRepository productosRepository;
    @Override
    public List<DetallesPedido> nomreadAll() {
        return detallesPedidoRepository.findAll().stream().filter(s -> s.getIsActive()==Constantes.Filtro).toList();
    }

    @Override
    public DetallesPedido readById(Double id) {
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
        if(detallesPedidoOptional.isPresent() && detallesPedidoOptional.get().getIsActive()==Constantes.Filtro ){
            return detallesPedidoOptional.get();
        }
        return new DetallesPedido();
    }



  /*  @Override
    public DetallesPedido insert(DetallesPedido detallesPedido) {
      detallesPedido.setIsActive(Constantes.Filtro);
        return detallesPedidoRepository.save(detallesPedido);
    }*/

    @Override
    public DetallesPedido insert(DetallesPedido detallesPedido) {
        // Obtener el pedido del detalle del pedido
        Pedidos pedido = detallesPedido.getPedido();

        // Verificar y asignar valores predeterminados si es necesario
        if (pedido.getFechaPedido() == null) {
            pedido.setFechaPedido(LocalDateTime.now());
        }
        if (pedido.getModificacionFecha() == null) {
            pedido.setModificacionFecha(LocalDateTime.now());
        }
        if (pedido.getCantidad() == null) {
            pedido.setCantidad(1.0);
        }
        if (pedido.getTotalPedido() == null) {
            pedido.setTotalPedido(1.0); // Asignar un valor predeterminado a totalPedido
        }

        // Asegurarse de que el pedido esté activo
        pedido.setIsActive(Constantes.Filtro);

        // Guardar el pedido con los valores asignados
        Pedidos savedPedido = pedidosRepository.save(pedido);

        // Asignar el pedido guardado al detalle del pedido
        detallesPedido.setPedido(savedPedido);
        detallesPedido.setIsActive(Constantes.Filtro);

        // Guardar el detalle del pedido
        return detallesPedidoRepository.save(detallesPedido);
    }


    @Override
    public DetallesPedido update(DetallesPedido detallesPedido) {

        return detallesPedidoRepository.save(detallesPedido);
    }

    @Override
    public String detalleDeleteDto(Double id){ //
        Optional<DetallesPedido> detallesPedidoOptional = detallesPedidoRepository.findById(id);
        if(detallesPedidoOptional.isPresent()){
            DetallesPedido detallesPedido = detallesPedidoOptional.get();
            detallesPedido.setIsActive(!Constantes.Filtro);
        }
        DeleteDto deleteDto = new DeleteDto();
        return deleteDto.getMensajeDetalle();
    }

    @Override
    public List<DetallePedidoDto> responseDtallePedidoDto() {
         List<DetallesPedido> detallesPedidoList =  detallesPedidoRepository.findDetallesPedidoProductoDto();
        return detallesPedidoList.stream().map(s->{
            DetallePedidoDto detallePedidoDto = new DetallePedidoDto();
            detallePedidoDto.setPedido(s.getPedido().getIdPedido());
            detallePedidoDto.setFechaPedido(s.getPedido().getFechaPedido());
            detallePedidoDto.setTotalPedido(s.getPedido().getTotalPedido());
            detallePedidoDto.setDocumento(s.getId());
            detallePedidoDto.setFechaCreacion(s.getFechaCreacion());
            detallePedidoDto.setCodigo(s.getProducto().getId());
            detallePedidoDto.setName(s.getProducto().getName());
            detallePedidoDto.setDescripcionProducto(s.getProducto().getDescripcionProducto());
            detallePedidoDto.setPrecio(s.getProducto().getPrecio());


            return detallePedidoDto;
        }).toList();
    }

    @Override
    public List<DetallesSinJoin> findDettalleSmple() {
        List<DetallesPedido> detallesSimplelis = detallesPedidoRepository.finDetallesSimple();
        return detallesSimplelis.stream().map(s->{
            DetallesSinJoin detallesSinJoin = new DetallesSinJoin();
            detallesSinJoin.setDocumento(s.getId());
            detallesSinJoin.setPrecioUnitario(s.getPrecioUnitario());


            return detallesSinJoin;
        }).toList();

    }




}
