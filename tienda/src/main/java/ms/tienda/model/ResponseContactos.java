package ms.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseContactos {
    private String nombreEmpresa;
    private String contacto;
    private String correo;
    private String telefono;
}
