package ms.tienda.client;

import ms.tienda.Configuration.FeignConfig;
import ms.tienda.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "users", url = "${user.mock-api.base-url}", configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("/users")
    List<User> getUsers();
}

