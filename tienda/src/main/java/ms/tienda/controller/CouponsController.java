package ms.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.tienda.model.CouponsResponse;
import ms.tienda.service.ICouponsService;

@RestController
@RequestMapping("/api/v1")
public class CouponsController {
	@Autowired
	ICouponsService couponsService;
	
	@GetMapping("/coupons-clientes")
	public CouponsResponse readAlls() {
		return couponsService.readAlls();
	}
}
