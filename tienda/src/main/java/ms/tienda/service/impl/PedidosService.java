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

<<<<<<< HEAD
        return pedidosRepository.findAll().stream().filter(s-> s.getIs_Active()!= Constantes.Filtro).toList() ;
=======
        return pedidosRepository.findAll().stream().filter(s-> s.getIsActive()!= Constantes.Filtro).toList() ;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
    }

    @Override
    public Pedidos readById(Long id){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
<<<<<<< HEAD
        if(pedidosOptional.isPresent() && pedidosOptional.get().getIs_Active()!=Constantes.Filtro){
=======
        if(pedidosOptional.isPresent() && pedidosOptional.get().getIsActive()!=Constantes.Filtro){
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
           return pedidosOptional.get();
        }
        return new Pedidos();
    }

    @Override
    public Pedidos insert(Pedidos pedidos) {
<<<<<<< HEAD
        pedidos.setIs_Active(!Constantes.Filtro);
=======
        pedidos.setIsActive(!Constantes.Filtro);
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
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
<<<<<<< HEAD
            pedidos.setIs_Active(Constantes.Filtro);
=======
            pedidos.setIsActive(Constantes.Filtro);
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
            pedidosRepository.save(pedidos);
            log.info(" Pedido {} deleted", id);
        }
        {log.error("El id departamento no existe");}
    }
}
