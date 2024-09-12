package ms.tienda.service.impl;


import ms.tienda.client.UserClient;
import ms.tienda.model.ResponseUser;
import ms.tienda.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserClient userClient;

    @Override
    public ResponseUser readAll() {
        try {
            ResponseUser responseUser = new ResponseUser();
            responseUser.setMensaje("Consulta exitosa");
            responseUser.setCodido("200");
            responseUser.setUserList(userClient.getUsers());
            return responseUser;
        }catch (Exception e){
            ResponseUser responseUser = new ResponseUser();
            responseUser.setMensaje("Error al consultar los usuarios");
            responseUser.setCodido("404");
            responseUser.setUserList(new ArrayList<>());
            return responseUser;
        }
    }

}
