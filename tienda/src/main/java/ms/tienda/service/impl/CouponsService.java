package ms.tienda.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.feign.ClientesCoupons;
import ms.tienda.model.CouponsResponse;
import ms.tienda.service.ICouponsService;

@Service
@Slf4j
public class CouponsService implements ICouponsService{
	
	@Autowired
	ClientesCoupons clientesCoupons;

	@Override
	public CouponsResponse readAlls() {
		try {
			CouponsResponse response = new CouponsResponse();
			response.setMensaje("Consulta exitosa");
			response.setCodigo(201L);
			response.setCouponsList(clientesCoupons.getData());
			return response;
		}catch(Exception e) {
			log.error(e.getMessage());
			log.error(e.getStackTrace().toString());
			CouponsResponse couponsResponse = new CouponsResponse();
			couponsResponse.setMensaje("Error al consumir el servicio");
			couponsResponse.setCodigo(404L);
			couponsResponse.setCouponsList(new ArrayList<>());
			return couponsResponse;
		}
	}
	
}
