package ms.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.tienda.entity.Proveedores;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProducto {
    private Double id;
    private String nombreProducto;
    private Double precio;
    private String categoria;
}
