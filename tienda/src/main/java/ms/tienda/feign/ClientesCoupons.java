package ms.tienda.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ms.tienda.model.Coupons;

@FeignClient(name = "clientesCoupons", url= "https://66c96f668a477f50dc30a012.mockapi.io/api/v1")
public interface ClientesCoupons {
	@GetMapping("/clientesmo")
	List<Coupons> getData();
}