package ms.tienda.model;
import java.util.List;

import lombok.*;
import ms.tienda.entity.Clientes;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesResponse {
	private String mensaje;
	private Long codigo;
	private List<Clientes> clientesList;
}
