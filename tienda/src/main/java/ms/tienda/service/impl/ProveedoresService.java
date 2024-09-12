package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.constantes.ProveedoresConstantes;
import ms.tienda.entity.Proveedores;
import ms.tienda.exceptions.ResponseNotFound;
import ms.tienda.exceptions.ResponseServerError;
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

    // Logs
    String log204 = "Sin contenido";
    String log404 = "El elemento {} no existe";
    String log500 = "Error interno: Revisar la conexion a la base de datos y correcta implementacion de la capa Repository";
    String log200 = "Consulta exitosa";

    // Get Proveedores
    @Override
    public List<ResponseProveedores> readAll() {
        try{
            List<Proveedores> proveedoresList = proveedoresRepository.findAll().stream().filter(proveedores -> proveedores.getIsActive()!=ProveedoresConstantes.Filtrado).toList();
            if (proveedoresList.isEmpty()){
                log.info(log204);
                throw new ResponseNotFound(new ResponseNotFound().getMensaje());
            }
            return proveedoresList.stream().map(proveedores -> {
                ResponseProveedores responseProveedores = new ResponseProveedores();
                responseProveedores.setId(proveedores.getId());
                responseProveedores.setNombreEmpresa(proveedores.getNombreEmpresa());
                log.info(log200);
                return responseProveedores;
            }).toList();
        }catch (Exception e) {
            log.error(log500);
            throw new ResponseServerError(new ResponseServerError().getError());
        }
    }

    // Get Proveedor By Id
    @Override
    public ResponseProveedor readById(Double id) {
        try{
            Optional<Proveedores>proveedoresOptional=proveedoresRepository.findById(id);
            if (proveedoresOptional.isPresent() && proveedoresOptional.get().getIsActive()==ProveedoresConstantes.Filtrado){
                log.error(log404,id);
                throw new ResponseNotFound(new ResponseNotFound().getError());
            }

            if (proveedoresOptional.isEmpty()){
                log.error(log404,id);
                throw new ResponseNotFound(new ResponseNotFound().getError());
            }

            if (proveedoresOptional.isPresent() && proveedoresOptional.get().getIsActive()!= ProveedoresConstantes.Filtrado) {
                Proveedores proveedor = proveedoresOptional.get();
                ResponseProveedor responseProveedor = new ResponseProveedor();
                responseProveedor.setMensaje("Consulta exitosa");
                responseProveedor.setCodigo("200");
                responseProveedor.setId(proveedor.getId());
                responseProveedor.setNombreEmpresa(proveedor.getNombreEmpresa());
                responseProveedor.setContacto(proveedor.getContacto());
                responseProveedor.setCorreo(proveedor.getCorreo());
                responseProveedor.setTelefono(proveedor.getTelefono());
                log.info(log200);
                return responseProveedor;
            }
            return new ResponseProveedor();
        }catch (ResponseServerError e){
            log.error(log500);
            throw  new ResponseServerError(new ResponseServerError().getError());
        }
    }

    // Insert nuevo Proveedor
    @Override
    public Proveedores insert(Proveedores proveedor) {
        try{
            proveedoresRepository.save(proveedor);
            log.info(log200);
        }catch (Exception e){
            log.error(log500);
            throw new ResponseServerError(new ResponseServerError().getError());
        }
        return proveedor;
    }

    // Update Proveedor
    @Override
    public Proveedores update(Proveedores proveedor) {
        try{
            proveedoresRepository.save(proveedor);
            log.info(log200);
        }catch (Exception e){
            log.error(log500);
            throw new ResponseServerError(new ResponseServerError().getError());
        }
        return proveedor;
    }

    // Delete Proveedor
    @Override
    public ResponseDelete delete(Double id) {
        try{
            Optional<Proveedores>proveedoresOptional=proveedoresRepository.findById(id);
            if (proveedoresOptional.isPresent() && proveedoresOptional.get().getIsActive()==ProveedoresConstantes.Filtrado){
                log.error(log404,id);
                throw new ResponseNotFound(new ResponseNotFound().getError());
            }

            if (proveedoresOptional.isEmpty()){
                log.error(log404,id);
                throw new ResponseNotFound(new ResponseNotFound().getError());
            }

            if (proveedoresOptional.isPresent()){
                Proveedores proveedor = proveedoresOptional.get();
                proveedor.setIsActive(false);
                proveedoresRepository.save(proveedor);
                ResponseDelete responseDelete = new ResponseDelete();
                responseDelete.setId(proveedor.getId());
                responseDelete.setMensaje("Elemento borrado exitosamente");
                log.info(log200);
                return responseDelete;
            }
            return new ResponseDelete();
        }catch (ResponseServerError e){
            log.error(log500);
            throw new ResponseServerError(new ResponseServerError().getError());
        }
    }

    // JPA Query encontrar contacto por nombre
    @Override
    public List<ResponseContactos> findByNombreContacto(String contacto) {
        try{
            List<Proveedores>proveedoresList=proveedoresRepository.findByNombreContacto("%" + contacto + "%");
            if (proveedoresList.isEmpty()){
                log.error(log404,contacto);
                throw new ResponseNotFound(new ResponseNotFound().getError());
            }
            return proveedoresList.stream().map(proveedores -> {
                ResponseContactos responseContactos = new ResponseContactos();
                responseContactos.setNombreEmpresa(proveedores.getNombreEmpresa());
                responseContactos.setContacto(proveedores.getContacto());
                responseContactos.setCorreo(proveedores.getCorreo());
                responseContactos.setTelefono(proveedores.getTelefono());
                return responseContactos;
            }).toList();
        }catch (ResponseServerError e){
            log.error(log500);
            throw new ResponseServerError(new ResponseServerError().getError());
        }
    }
}
