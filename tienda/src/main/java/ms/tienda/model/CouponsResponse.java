package ms.tienda.model;
import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponsResponse {
	private String mensaje;
	private Long codigo;
	private List<Coupons> couponsList;
}
