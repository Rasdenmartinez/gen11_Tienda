package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.ProveedoresConstantes;
import ms.tienda.entity.Proveedores;
import ms.tienda.model.ResponseContactos;
import ms.tienda.model.ResponseDelete;
import ms.tienda.model.ResponseProveedor;
import ms.tienda.model.ResponseProveedores;
import ms.tienda.repository.ProveedoresRepository;
import ms.tienda.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class ProveedoresService implements IProveedoresService {
    @Autowired
    ProveedoresRepository proveedoresRepository;

    // Get Proveedores
    @Override
    public List<ResponseProveedores> readAll() {
        List<Proveedores> proveedoresList = proveedoresRepository.findAll().stream().filter(proveedores -> proveedores.getIsActive()!=ProveedoresConstantes.Filtrado).toList();
        return proveedoresList.stream().map(proveedores -> {
            ResponseProveedores responseProveedores = new ResponseProveedores();
            responseProveedores.setId(proveedores.getId());
            responseProveedores.setNombreEmpresa(proveedores.getNombreEmpresa());
            return responseProveedores;
        }).toList();
    }

    // Get Proveedor By Id
    @Override
    public ResponseProveedor readById(Double id) {
        Optional<Proveedores>proveedoresOptional=proveedoresRepository.findById(id);
        if (proveedoresOptional.isPresent() && proveedoresOptional.get().getIsActive()!= ProveedoresConstantes.Filtrado) {
            Proveedores proveedor = proveedoresOptional.get();
            ResponseProveedor responseProveedor = new ResponseProveedor();
            responseProveedor.setId(proveedor.getId());
            responseProveedor.setNombreEmpresa(proveedor.getNombreEmpresa());
            responseProveedor.setContacto(proveedor.getContacto());
            responseProveedor.setCorreo(proveedor.getCorreo());
            responseProveedor.setTelefono(proveedor.getTelefono());
            return responseProveedor;
        }else {
            return new ResponseProveedor();
        }
    }

    // Insert nuevo Proveedor
    @Override
    public Proveedores insert(Proveedores proveedor) {

        return proveedoresRepository.save(proveedor);
    }

    // Update Proveedor
    @Override
    public Proveedores update(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    // Delete Proveedor
    @Override
    public ResponseDelete delete(Double id) {
        Optional<Proveedores>proveedoresOptional=proveedoresRepository.findById(id);
        if (proveedoresOptional.isPresent() && proveedoresOptional.get().getIsActive()==ProveedoresConstantes.Filtrado){
            ResponseDelete response = new ResponseDelete();
            response.setId(id);
            response.setMensaje("El elemento no existe");
            log.error("El elemento {} no existe",id);
            return response;
        }

        if (proveedoresOptional.isPresent()){
            Proveedores proveedor = proveedoresOptional.get();
            proveedor.setIsActive(false);
            proveedoresRepository.save(proveedor);
            ResponseDelete responseDelete = new ResponseDelete();
            responseDelete.setId(proveedor.getId());
            responseDelete.setMensaje("Elemento borrado exitosamente");
            log.info("Elemento {} borrado exitosamente",id);
            return responseDelete;
        }

        if (proveedoresOptional.isEmpty()){
            ResponseDelete response = new ResponseDelete();
            response.setId(id);
            response.setMensaje("El elemento no existe");
            log.error("El elemento {} no existe",id);
            return response;
        }
        return new ResponseDelete();
    }

    // Jpa Query contacto
    @Override
    public List<ResponseContactos> contactoProveedor(String contacto){
        List<Proveedores> proveedoresList=proveedoresRepository.findByContacto(contacto);
        return proveedoresList.stream().map(proveedores -> {
            ResponseContactos responseContactos = new ResponseContactos();
            responseContactos.setNombreEmpresa(proveedores.getNombreEmpresa());
            responseContactos.setContacto(proveedores.getContacto());
            responseContactos.setCorreo(proveedores.getCorreo());
            responseContactos.setTelefono(proveedores.getTelefono());
            return responseContactos;
        }).toList();
    }
}
