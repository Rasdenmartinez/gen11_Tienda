package ms.tienda.controller;

import ms.tienda.client.UserClient;
import ms.tienda.model.ResponseUser;
import ms.tienda.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/users")
    public ResponseUser readAll(){
        return userService.readAll();
    }


}
