package ms.tienda.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoProveedorDTO {

	private Long idEmpleado;
	private String nombreEmpleado;
	private String apellidoEmpleado;
	private String puesto;
	private Double idProveedor;
	private String nombreEmpresa;
	private String contacto;
	private String telefono;
}
