package ms.tienda.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEmpleadoDTO {

	  	private Long idCliente;
	    private String nombreCliente;
	    private Long idEmpleado;
	    private String nombreEmpleado;
	    private String puesto;
	    private Double salario;
}
