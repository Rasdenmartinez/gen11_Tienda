package ms.tienda.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallesSinJoin {

    private Integer id;

    private Double cantidad;

    private Double precioUnitario;
}
